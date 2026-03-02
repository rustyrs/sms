package controller.manager;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.StudentDAO;


// 学生登録クラス

@WebServlet(urlPatterns={"/manager/delete"})
public class DeleteStudent extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {	
		request.getRequestDispatcher("../WEB-INF/jsp/manager/delete/form.jsp")
			.forward(request, response);
	}
	
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		// Form取得&初期化
		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDAO dao = new StudentDAO();
		 
		int lines = 0; // 成功失敗判定用
		
		try {
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
		
		request.getRequestDispatcher("../WEB-INF/jsp/manager/delete/result.jsp")
			.forward(request, response);
	}
}