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

@WebServlet("/manager/*")
public class ManagerDetail extends HttpServlet {
  protected void doGet(
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {
 
        String pathInfo = request.getPathInfo(); 
        
        if (pathInfo != null) {
            String[] parts = pathInfo.split("/");
            System.out.println(parts[1]);
        }
    }
}