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

// 生徒一覧表示クラス

@WebServlet(urlPatterns={"/student-list"})
public class StudentList extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		String courseId = request.getParameter("course-id");
		
		StudentDAO dao = new StudentDAO();
		List<Student> students;
		
		try {
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "GET", "students"));
		} catch (Exception e) {}
		
		if (courseId != null) {
			try {
				students = dao.findByCourse(courseId);
				request.setAttribute("students", students);
			} catch (Exception e) {}
		} else {
			try {
				students = dao.getAll();
				request.setAttribute("students", students);
			} catch (Exception e) {}
		}
		
		
		
		request.getRequestDispatcher("WEB-INF/jsp/student-list.jsp")
			.forward(request, response);
	}
}