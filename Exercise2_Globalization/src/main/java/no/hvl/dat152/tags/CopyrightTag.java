package no.hvl.dat152.tags;

/**
 * Tag that writes the “since year” and the current year in Roman numerals
 *
 */

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.util.Calendar;

/**
 * Servlet implementation class CopyrightTag
 */
@WebServlet("/CopyrightTag")
public class CopyrightTag extends SimpleTagSupport {
	private String since;
	
	public void setSince(String msg) {
		this.since = msg;
	}
	StringWriter sw = new StringWriter();

	
	public void doTag() throws JspException, IOException {
		if (since != null) {
			/* Use message from attribute */
	        JspWriter out = getJspContext().getOut();
	        
	        try {
	        	String msg = "&copy;" ;
	        	msg += toRoman(Integer.parseInt(this.since));
	        	msg += "-";
	        	msg += toRoman(Calendar.getInstance().get(Calendar.YEAR));
	        	msg += " ";
	        	out.println(msg);
	        	getJspBody().invoke(null);
			}catch(NumberFormatException e){
				/* use message from the body */
		        getJspBody().invoke(sw);
		        getJspContext().getOut().println(sw.toString());
			}
	        
		} else {
			/* use message from the body */
	        getJspBody().invoke(sw);
	        getJspContext().getOut().println(sw.toString());
		}
	}

	private static String toRoman(int number) {
        return String.valueOf(new char[number]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

}
