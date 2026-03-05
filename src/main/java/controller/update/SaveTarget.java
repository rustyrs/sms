package controller.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Student;
import model.dao.StudentDAO;

// 学生更新対象指定画面クラス

@WebServlet(urlPatterns={"/update-save-target"})
public class SaveTarget extends HttpServlet {
	
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		int targetId = Integer.parseInt(request.getParameter("target"));
		StudentDAO dao = new StudentDAO();
		boolean isExists = false;
		HttpSession session = request.getSession();
		try {
			isExists = StudentDAO.exists(targetId);
		} catch (Exception e) {}
		
		Student s;
		
		if (isExists) {
			session.setAttribute("isExists", true);
			try {
				s = dao.getDetail(targetId);
				session.setAttribute("update-target", s);
			} catch (Exception e) {
				System.out.println("UpdateStudentSelect.java");
				return;
			}
			response.sendRedirect("update-input");
		} else {
			session.setAttribute("isExists", false);
			response.sendRedirect("update-select");
		}
	}
}