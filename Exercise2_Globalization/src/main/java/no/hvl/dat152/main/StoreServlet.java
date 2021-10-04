package no.hvl.dat152.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import no.hvl.dat152.webStore.*;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/store")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		Cookie[] cookies = request.getCookies();
		String localS = null;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals("locale")) {
					localS = cookie.getValue();
					Config.set(request.getSession(), Config.FMT_LOCALE, localS);
				} else if(cookie.getName().equals("produckt0")) {
					System.out.println("P0 TOP GET Value: " + cookie.getValue());
					request.setAttribute("p0Value", Integer.parseInt(cookie.getValue()));
				}else if(cookie.getName().equals("produckt1")) {
					System.out.println("P1 TOP GET Value: " + cookie.getValue());
					request.setAttribute("p1Value", Integer.parseInt(cookie.getValue()));
				}
			}
		} else {
			Locale locale = request.getLocale();
			localS = locale.toString();
			
			Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());
			
			Cookie localeCookie = new Cookie("locale", locale.getLanguage());
			localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
            response.addCookie(localeCookie);
			
		}
		
		Store store = new Store();
		ArrayList<Product> products = store.getProducts();
		ArrayList<Description> descriptions = new ArrayList<Description>();
		
		for(int i = 0; i < products.size(); i ++) {
			descriptions.add(store.getDescription(products.get(i).getPno(), localS));
		}
		
		request.setAttribute("d1", descriptions.get(0));
		request.setAttribute("d2", descriptions.get(1));
		request.setAttribute("i1", products.get(0));
        request.setAttribute("i2", products.get(1));
        request.getRequestDispatcher("store.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p0 = 0;
		int p1 = 1;
		
		boolean p0b = false;
		boolean p1b = false;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("product0")) {
					System.out.println("P0 COOKIE BOTTOM");
					p0 = Integer.parseInt(cookie.getValue());
					if(request.getParameter("0") != null) {
						p0++;
					} else if(request.getParameter("remove0") != null) {
						if (p0 != 0) 
							p0--;
					}
					
					cookie.setValue(Integer.toString(p0));
					System.out.println("P0 TOP POST: " + cookie.getName()+ " value " + p0);
					response.addCookie(cookie);
					p0b = true;
				} else if(cookie.getName().equals("product1")) {
					p1 = Integer.parseInt(cookie.getValue());
					if(request.getParameter("1") != null) 
						p1++;
					else if(request.getParameter("remove1") != null) {
						if (p1 != 0) 
							p1--;
					}
					cookie.setValue(Integer.toString(p1));
					System.out.println("P1 TOP POST: " + cookie.getName()+ " value " + p1);
		            response.addCookie(cookie);
					p1b = true;
				}
			}
		}
		
		if(request.getParameter("0") != null && !p0b) {
			p0++;
			Cookie productCookie = new Cookie("product0", Integer.toString(p0));
			productCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
			//System.out.println("P0 POST BOTTOM: " + productCookie.getName() + " value " + p0);
            response.addCookie(productCookie);
		}else if(request.getParameter("1") != null && !p1b){
			p1++;
			Cookie productCookie = new Cookie("product1", Integer.toString(p1));
			productCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds
			System.out.println("P1 POST BOTTOM: " + productCookie.getName() + " value " + p1);
            response.addCookie(productCookie);
		}
		response.sendRedirect("store");
	}

}
