package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Manager;
import model.dao.ManagerDAO;

@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {

	// フォワード
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		// セッション初期化
		request.setAttribute("studentUnsuccess", false);
		request.setAttribute("managerUnsuccess", false);
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp")
		.forward(request, response);
	}
	
	// ログイン処理
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		// Form取得&初期化
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		ManagerDAO managerDao = new ManagerDAO();
		HttpSession session = request.getSession();
		
		String nextPage = "login" ;
		
		boolean studentUnsuccess = false;
		boolean managerUnsuccess = false;
		
		try {
			// IDとパスワードを検証する
			boolean isExists = managerDao.login(id, password);
			if (isExists) {
				// 存在していればログイン状態のセッションをTrueにして名前等をセッションに保存
				managerUnsuccess = false;
				session.setAttribute("managerIsLogin", true);
				session.setAttribute("mode", "manager");
					
				Manager m = managerDao.getDetail(id, password);
					
				session.setAttribute("id", m.getId() );
				session.setAttribute("userName", m.getName() );
					
				nextPage = "menu";
			} else {
				managerUnsuccess = true;
			}
		} catch (Exception e) {
			request.setAttribute("error", e);
		}
		
		// jspに結果を表示するため
		request.setAttribute("studentUnsuccess", studentUnsuccess);
		request.setAttribute("managerUnsuccess", managerUnsuccess);
		
		response.sendRedirect(nextPage);
	}
}