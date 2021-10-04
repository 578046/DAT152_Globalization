package no.hvl.dat152.main;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.jsp.jstl.core.Config;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    // Set locale from cookie
                    Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
                }else if(cookie.getName().equals("product0")) {
                	System.out.println("P0 cart GET Value: " + cookie.getValue());
                	request.setAttribute("p0Value", Integer.parseInt(cookie.getValue()));
                }else if(cookie.getName().equals("product1")) {
                	System.out.println("P1 cart GET Value: " + cookie.getValue());
                	request.setAttribute("p1Value", Integer.parseInt(cookie.getValue()));
                }
            }
        } else {
            Locale locale = request.getLocale();


            Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());

            Cookie localeCookie = new Cookie("locale", locale.getLanguage());
            localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
            response.addCookie(localeCookie);
            // Cookie with locale sent to client
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
