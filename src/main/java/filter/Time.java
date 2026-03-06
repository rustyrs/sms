package filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// 現在時刻取得フィルター

@WebFilter(urlPatterns = {"/*"})
public class Time implements Filter {
	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		// 現在時刻取得
		LocalDateTime nowDate = LocalDateTime.now();
		
		// フォーマットを整える
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy年MM月dd日E曜日");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		
		String fDate = date.format(nowDate);
		String fTime = time.format(nowDate);	

		// セッションに入れる
		session.setAttribute("date", fDate);
		session.setAttribute("time", fTime);
		
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}