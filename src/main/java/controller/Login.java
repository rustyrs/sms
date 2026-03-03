package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Manager;
import model.bean.StudentDetail;
import model.dao.ManagerDAO;
import model.dao.StudentDetailDAO;


@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("studentUnsuccess", false);
		request.setAttribute("managerUnsuccess", false);
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
		.forward(request, response);
	}
	
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		// Form取得&初期化
		String id = request.getParameter("id");
		String numberString = request.getParameter("num");
		String password = request.getParameter("password");
		ManagerDAO managerDao = new ManagerDAO();
		StudentDetailDAO studentDetailDao = new StudentDetailDAO();
		HttpSession session = request.getSession();
		
		String nextPage = "login" ;
		
		boolean studentUnsuccess = false;
		boolean managerUnsuccess = false;
		
		if (id!= null) {
			 // 管理者・教員
			try {
				boolean isExists = managerDao.login(id, password);
				if (isExists) {
					managerUnsuccess = false;
					session.setAttribute("managerIsLogin", true);
					session.setAttribute("mode", "manager");
					
					Manager m = managerDao.getDetail(id, password);
					
					session.setAttribute("id", m.getId() );
					session.setAttribute("name", m.getName() );
					
					nextPage = "manager/menu";
				} else {
					managerUnsuccess = true;
				}
			} catch (Exception e) {
				request.setAttribute("error", e);
			}
		} else {
			// 学生
			try {
				System.out.println("学生がログインを試みました");
				int number = Integer.parseInt(numberString);
				boolean isExists = studentDetailDao.login(number, password);
				if (isExists) {
					System.out.println("発見");
					studentUnsuccess = false;
					session.setAttribute("studentIsLogin", true);
					session.setAttribute("mode", "student");
					
					StudentDetail s = studentDetailDao.getDetail(number, password);
					
					session.setAttribute("number", s.getNumber());
					session.setAttribute("name",  s.getName());
					session.setAttribute("comment", s.getComment());
					
					nextPage = "student/menu";
				} else {
					studentUnsuccess = true;
				}
			} catch (Exception e) {
				request.setAttribute("error", e);
			}
		}
		
		request.setAttribute("studentUnsuccess", studentUnsuccess);
		request.setAttribute("managerUnsuccess", managerUnsuccess);
		
		response.sendRedirect(nextPage);
	}
}