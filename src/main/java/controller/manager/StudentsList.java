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

// 生徒一覧表示クラス

@WebServlet(urlPatterns={"/manager/list"})
public class StudentsList extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		StudentDAO dao = new StudentDAO();
		
		try {
			List<Student> students = dao.getAll();
			request.setAttribute("students", students);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../WEB-INF/jsp/manager/list.jsp")
			.forward(request, response);
	}
}