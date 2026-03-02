package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Manager;
import model.dao.ManagerDAO;


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
		String password = request.getParameter("password");
		ManagerDAO dao = new ManagerDAO();
		HttpSession session = request.getSession();
		
		String nextPage = "login" ;
		
		boolean studentUnsuccess = false;
		boolean managerUnsuccess = false;
		
		if (password != null) {
			 // 管理者・教員
			try {
				boolean isExists = dao.login(id, password);
				if (isExists) {
					studentUnsuccess = false;
					session.setAttribute("isLogin", true);
					session.setAttribute("mode", "manager");
					
					Manager m = dao.getDetail(id, password);
					
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
			// 生徒
			
		}
		
		request.setAttribute("studentUnsuccess", studentUnsuccess);
		request.setAttribute("managerUnsuccess", managerUnsuccess);
//		
//		request.getRequestDispatcher(nextPage)
//			.forward(request, response);
		response.sendRedirect(nextPage);
	}
}