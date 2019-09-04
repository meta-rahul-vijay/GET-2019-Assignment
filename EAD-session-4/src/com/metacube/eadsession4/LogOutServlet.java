package com.metacube.eadsession4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * servlet to invalidate the session
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class LogOutServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
            
          request.getRequestDispatcher("LogIn.html").include(request, response);  
            
          HttpSession session=request.getSession();  
          session.invalidate();  
            
          response.setContentType("text/html");  
          out.println("<script type=\"text/javascript\">");  
          out.println("alert('Logged out successfully');");  
          out.println("</script>");
            
          out.close();  
	}

}
