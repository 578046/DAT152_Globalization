package no.hvl.dat152.main;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class InitSessionServlet
 */
@WebServlet("/home")
public class InitSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null ) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("locale")) {
					Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
				}
			}
		} else {
			Locale locale = request.getLocale();
			
			Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());
			Cookie localeCookie = new Cookie("locale", locale.getLanguage());
			localeCookie.setMaxAge(365 * 24 * 60 * 60);
			response.addCookie(localeCookie); 
		}
		response.sendRedirect("index.jsp");
	}
	
}
