package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Log;
import model.bean.Student;
import model.dao.LogDAO;
import model.dao.StudentDAO;
import session.Session;

// 生徒検索クラス

@WebServlet(urlPatterns={"/search"})
public class Search extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/search/form.jsp")
		.forward(request, response);
	}
	
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		// Form取得&初期化
		String name = request.getParameter("name");
		String fuzzy = request.getParameter("fuzzy");
		StudentDAO dao = new StudentDAO();
		
		List<Student> students;
		
		try {
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "GET", "students"));
			if (fuzzy == null) {
				students = dao.findByName(name);	
			} else {
				students = dao.findByNameFuzzy(name);
			}
			request.setAttribute("students", students);
		} catch (Exception e) {
			request.setAttribute("error", e);
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/search/list.jsp")
			.forward(request, response);
	}
}