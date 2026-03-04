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
		
		List<Log> logs = null;
		
		String executorId = request.getParameter("executor-id");
		String actionType = request.getParameter("action-type");
		String targetTable = request.getParameter("target-table");
		
		try {
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "GET", "logs"));
		} catch (Exception e) {}
		
		if (executorId != null) {
			try {
				logs = LogDAO.findByExecuterId(executorId);				
			} catch (Exception e) {}
		} else if (actionType != null) {
			try {
				logs = LogDAO.findByActionType(actionType);				
			} catch (Exception e) {}
		} else if (targetTable != null) {
			try {
				logs = LogDAO.findByTargetTable(targetTable);				
			} catch (Exception e) {}
		} else {
			try {
				logs = LogDAO.findAll();				
			} catch (Exception e) {}
		}
		
		request.setAttribute("logs", logs);
		
		
		request.getRequestDispatcher("WEB-INF/jsp/log-list.jsp")
			.forward(request, response);
	}
}