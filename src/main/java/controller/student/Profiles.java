package controller.student;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 学生登録クラス

@WebServlet(urlPatterns={"/student/profiles"})
public class Profiles extends HttpServlet {
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		request.getRequestDispatcher("../WEB-INF/jsp/manager/register/form.jsp")
		.forward(request, response);
	}
}