package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Log;
import model.dao.LogDAO;
import model.dao.StudentDAO;
import session.Session;


// 学生削除クラス

@WebServlet(urlPatterns={"/delete"})
public class DeleteStudent extends HttpServlet {
	
	// フォワード
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/jsp/delete/form.jsp")
			.forward(request, response);
	}

	// DAOを使って削除処理
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		// Form取得&初期化
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		boolean isExsits = true;
		StudentDAO dao = new StudentDAO(); 
		int lines = 0; // 成功失敗判定用

		try {
			// 対象が既に存在しているIDかを確認
			isExsits = StudentDAO.exists(id);
			session.setAttribute("deleteExists", isExsits);
		} catch (Exception e) {}
		
		// 存在していなければ戻る
		if (!isExsits) {	
			response.sendRedirect("delete");
			return;
		}
		
		// ログ追加と、実際にdelete処理
		try {
			String userId = Session.get("id", request, response);
			LogDAO.create(new Log(userId, "DELETE", "students"));
			lines = dao.delete(id);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 成功した(追加された行があった)らtrue
		if (lines > 0) {
			request.setAttribute("result", true);
		} else {
			request.setAttribute("result", false);
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/delete/result.jsp")
			.forward(request, response);
	}
}