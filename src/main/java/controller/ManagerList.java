package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Log;
import model.bean.Manager;
import model.dao.LogDAO;
import model.dao.ManagerDAO;
import session.Session;

// 教員一覧表示クラス

@WebServlet(urlPatterns={"/manager-list"})
public class ManagerList extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		ManagerDAO dao = new ManagerDAO();
		
		try {
			// ログ追加
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "GET", "managers"));
			
			// ログ取得
			List<Manager> managers = dao.findAll();
			request.setAttribute("managers", managers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/manager-list.jsp")
			.forward(request, response);
	}
}