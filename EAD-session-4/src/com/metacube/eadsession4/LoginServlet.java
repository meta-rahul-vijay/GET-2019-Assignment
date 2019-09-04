package com.metacube.eadsession4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * servlet to validate user and log him in
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class LoginServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");  
		Cookie empId ;
		PrintWriter out= response.getWriter();
		
		BusinessLayer bl= new BusinessLayer();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		int accessId=-1;
		try {
			accessId = bl.checkLogin(email, password);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		if(accessId==0){

			RequestDispatcher rd=request.getRequestDispatcher("LogIn.html");  
			rd.include(request,response);  
			out.println("<p align='center' style='color:red;font-size:120%;'>"+"please enter right credentials ..</p>");
			return;
		}

		session.setAttribute("empId", accessId);
		session.setAttribute("email", email);
		String content="";
		try {
			if(!bl.checkFirstLogin(email)){
				response.sendRedirect("VehicleRegistration.jsp");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("HomePage.jsp");
		 
	}

}
