package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// メニュークラス

@WebServlet(urlPatterns={"/menu"})
public class Menu extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/menu.jsp")
			.forward(request, response);
	}
}