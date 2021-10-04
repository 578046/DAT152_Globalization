package no.hvl.dat152.tags;

/**
 * Tag that limits the length of product description in the carts summary
 *
 */

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;



/**
 * Servlet implementation class ShortTag
 */
@WebServlet("/ShortTag")
public class ShortTag extends SimpleTagSupport {
	private String maxchars;

	   public void setMaxchars(String msg) {
	      this.maxchars = msg;
	   }
	   StringWriter sw = new StringWriter();

	   public void doTag() throws JspException, IOException {
		      if (maxchars != null) {
		         /* Use message from attribute */
		    	  int j = Integer.parseInt(maxchars);
			      getJspBody().invoke(sw);
			      String s = sw.toString();
			      String ret = "";
		    	  for(int i = 0; i<j; i++) {
		    		  if(i < s.length()) {
		    			  ret += s.charAt(i);
		    		  }
		    	  }
		    	  ret += " ...";
		    	  
		         JspWriter out = getJspContext().getOut();
		         out.println( ret );
		      } else {
		         /* use message from the body */
		         getJspBody().invoke(sw);
		         getJspContext().getOut().println(sw.toString());
		      }
		   }

}
