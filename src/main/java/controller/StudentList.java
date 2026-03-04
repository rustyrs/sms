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
		
		StudentDAO dao = new StudentDAO();
		
		try {
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "GET", "students"));
			List<Student> students = dao.getAll();
			request.setAttribute("students", students);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/student-list.jsp")
			.forward(request, response);
	}
}