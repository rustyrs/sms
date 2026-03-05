package controller.reset;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.LogDAO;
import model.dao.ManagerDAO;
import model.dao.StudentDAO;

// 権限メニュークラス

@WebServlet(urlPatterns={"/reset"})
public class Reset extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		
		String[] options = request.getParameterValues("reset-database");
		
		for (String o : options) {
			if (o.equals("manager")) {
				try {
					ManagerDAO.reset();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (o.equals("student")) {
				try {
					StudentDAO.reset();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} else if (o.equals("log")) {
					try {
						LogDAO.reset();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/reset/reset-menu.jsp")
			.forward(request, response);
	}
}