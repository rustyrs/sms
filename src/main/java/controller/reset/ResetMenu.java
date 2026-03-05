package controller.reset;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 権限メニュークラス

@WebServlet(urlPatterns={"/reset-menu"})
public class ResetMenu extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/reset/reset-menu.jsp")
			.forward(request, response);
	}
}