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

@WebFilter(urlPatterns = {"/manager/*"})
public class LoginFilter implements Filter {
	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
	   
		HttpSession session = httpRequest.getSession();
		Object isLogin = session.getAttribute("isLogin");
		
		if ((isLogin == null) || ((boolean)isLogin == false)) {
			httpResponse.sendRedirect("/sms/login");
			return;
		}
		
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}