package controller.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 学生更新対象指定画面クラス

@WebServlet(urlPatterns={"/update-failure"})
public class UpdateFailure extends HttpServlet {
	
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/update/form.jsp")
		.forward(request, response);
	}
}