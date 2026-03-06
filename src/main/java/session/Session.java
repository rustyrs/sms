package session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// セッションから値を引数で取る

public class Session {
	public static String get(
		String key,
	    HttpServletRequest request, HttpServletResponse response		
	) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String value = (String)session.getAttribute(key);
		return value;
	}
}
