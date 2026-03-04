package controller.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Log;
import model.bean.Student;
import model.dao.LogDAO;
import model.dao.StudentDAO;
import session.Session;

// 学生更新対象指定画面クラス

@WebServlet(urlPatterns={"/update-input"})
public class InputForm extends HttpServlet {
	
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object object = session.getAttribute("update-target");
		
		System.out.println(object==null);
		
		if (object!=null) {
			Student s =(Student) object;
			
			System.out.println(s.getName());
			
			request.setAttribute("targetNumber", s.getId());
			request.setAttribute("targetName", s.getName());
			request.setAttribute("targetCourse", s.getCourse());
		} else {
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/update/form.jsp")
		.forward(request, response);
	}
	public void doPost (
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException {
			
			// Form取得&初期化
		HttpSession session = request.getSession();
		Object targetObject = session.getAttribute("update-target");
		Student targetStudent = (Student) targetObject;
		int targetId = targetStudent.getId();
		
			int id = targetId;
			String name = request.getParameter("name");
			int course = Integer.parseInt(request.getParameter("course"));
			
			Student s = new Student(id, name, course);
			
			
			StudentDAO dao = new StudentDAO();
			 
			int lines = 0; // 成功失敗判定用
			
			try {
				String userId = Session.get("id", request, response);
				LogDAO.create(new Log(userId, "UPDATE", "students"));
				lines = dao.update(s, targetId);			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 成功した(追加された行があった)らtrue
			if (lines > 0) {
				request.setAttribute("result", true);
			} else {
				request.setAttribute("result", false);
			}
			
			request.getRequestDispatcher("WEB-INF/jsp/update/result.jsp")
				.forward(request, response);
		}
}