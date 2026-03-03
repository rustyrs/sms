package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/*"})
public class ManagerLoginFilter implements Filter {
	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
				
		String path = httpRequest.getRequestURI();
		
		if (path.startsWith("/sms/login") || path.startsWith("/sms/css/")) {
			chain.doFilter(request, response);
			return;
		}
	   
		HttpSession session = httpRequest.getSession();
		Object isLogin = session.getAttribute("managerIsLogin");
		
		if ((isLogin == null) || ((boolean)isLogin == false)) {
			httpResponse.sendRedirect("/sms/login");
			return;
		} else {
			String name = (String) session.getAttribute("name");
			request.setAttribute("name", name);	
		}
		
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}