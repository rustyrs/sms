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

// ログイン状態管理

@WebFilter(urlPatterns = {"/*"})
public class ManagerLoginFilter implements Filter {
	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
				
		String path = httpRequest.getRequestURI();
		
		// ログイン画面とCSSはフィルター対象から除外
		if (path.startsWith("/sms/login") || path.startsWith("/sms/css/")) {
			chain.doFilter(request, response);
			return;
		}
	   
		HttpSession session = httpRequest.getSession();

		// managerIsLoginでログイン状態を管理
		Object isLogin = session.getAttribute("managerIsLogin");
		
		// もし↑のものがnullならログインしていない
		// もしくはあったけどfalseなら
		if ((isLogin == null) || ((boolean)isLogin == false)) {
			// 強制的にログイン画面
			httpResponse.sendRedirect("/sms/login");
			return;
		} else {
			// ログイン状態ならユーザーネームをセッションに保存
			String name = (String) session.getAttribute("userName");
			request.setAttribute("userName", name);	
		}
		
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}