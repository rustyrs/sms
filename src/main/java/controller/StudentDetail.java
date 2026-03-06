//
//
// 未使用
//
//
package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Student;
import model.dao.StudentDAO;

@WebServlet("/student/*")
public class StudentDetail extends HttpServlet {
    protected void doGet(
    		HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
 
        String pathInfo = request.getPathInfo(); 
        String numberString = null;
        int number;
        
        if (pathInfo != null) {
            String[] parts = pathInfo.split("/");
            numberString = parts[1];
        }
        
        if ((numberString != null)&&(!numberString.contains("WEB-INF"))) {
        	try {
        		number = Integer.parseInt(numberString);
        		StudentDAO dao = new StudentDAO();
        		
        		Student s = dao.getDetail(number);
        		request.setAttribute("number", s.getId());
        		request.setAttribute("name", s.getName());
        		request.setAttribute("course", s.getCourse());
        		
        	} catch (Exception e) {
        		System.out.println("StudentDetail.java");
        		return;
        	}
        }
        request.getRequestDispatcher("WEB-INF/jsp/user-detail/student-detail.jsp")
		.forward(request, response);
    }
}