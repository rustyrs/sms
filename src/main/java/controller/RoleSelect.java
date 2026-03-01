package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 学生か先生か選択

@WebServlet(urlPatterns={"/select"})
public class RoleSelect extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/role-select.jsp")
			.forward(request, response);
	}
}