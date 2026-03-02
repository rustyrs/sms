package controller.manager;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Student;
import model.dao.StudentDAO;

// 生徒検索クラス

@WebServlet(urlPatterns={"/manager/search"})
public class Search extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("../WEB-INF/jsp/manager/search/form.jsp")
		.forward(request, response);
	}
	
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		// Form取得&初期化
		String name = request.getParameter("name");
		StudentDAO dao = new StudentDAO();
		
		try {
			List<Student> students = dao.findByName(name);
			request.setAttribute("students", students);
		} catch (Exception e) {
			request.setAttribute("error", e);
		}
		
		request.getRequestDispatcher("../WEB-INF/jsp/manager/search/list.jsp")
			.forward(request, response);
	}
}