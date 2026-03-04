package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Log;
import model.dao.LogDAO;
import session.Session;

// ログ一覧表示クラス

@WebServlet(urlPatterns={"/log-list"})
public class LogList extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		LogDAO dao = new LogDAO();
		
		try {
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "GET", "logs"));
			List<Log> logs = dao.getAll();
			request.setAttribute("logs", logs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/log-list.jsp")
			.forward(request, response);
	}
}