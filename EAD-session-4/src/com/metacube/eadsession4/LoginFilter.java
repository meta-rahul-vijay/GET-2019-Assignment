package com.metacube.eadsession4;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * filter to check if session of employee exists
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
@WebFilter(urlPatterns = { "/registerVehicle","/getPass", "/EditProfileServlet","/FriendServlet","/EditProfile.jsp","/FriendProfile.jsp","/VehicleRegistration.jsp","/ChoosePlan.jsp","/HomePage.jsp"})
public class LoginFilter implements Filter {

   

	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest requestOne = (HttpServletRequest) request;
		HttpServletResponse responseOne = (HttpServletResponse) response;

		// Get the HttpSession object.
		HttpSession session = requestOne.getSession();	
		String email=(String)session.getAttribute("email"); 
		   if (email!=null) {
		   	// pass the request along the filter chain
		         chain.doFilter(requestOne, responseOne);
		     } 
		   else {
		   	//if not logged in redirect to login page
		         responseOne.sendRedirect("LogIn.html");
		     } 
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
