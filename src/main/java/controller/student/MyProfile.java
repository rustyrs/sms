package controller.student;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 自分のプロフィール

@WebServlet(urlPatterns={"/student/my-profile"})
public class MyProfile extends HttpServlet {
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("../WEB-INF/jsp/student/my-profile/view.jsp")
		.forward(request, response);
	}
}