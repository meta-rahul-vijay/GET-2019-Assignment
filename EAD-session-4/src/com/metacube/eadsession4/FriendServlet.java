package com.metacube.eadsession4;

import java.sql.SQLException;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * servlet to find friends of a employee
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class FriendServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out=response.getWriter();
		
		BusinessLayer bl= new BusinessLayer();
		
		ArrayList<EmployeePojo> employees = null;
		HttpSession session = request.getSession();
		
		int empId = Integer.parseInt(session.getAttribute("empId").toString());
		
		
		try {
			employees = bl.getFriends(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(request.getParameter("email")==null){
			
			out.print(Variables.upperBody);
			out.print("<br><br> <h1 >Your Friends</h1><div>");
			out.print("<form id='form1' ><table style='font-size : 140%'>");
			out.print("<a style='float:right;margin-right:10%;font-size:140%' href = 'HomePage.jsp'>Home</a>");
			for(int i =0; i < employees.size(); i++){
				out.print("<tr><td>"	
						+ employees.get(i).getFullName()+ "</td>"
						+ "<td> <a href='FriendServlet?email="+employees.get(i).getEmail()+"'>View profile</a></td>");
			}
			out.print("</form></div>");
			out.print(Variables.lowerBody);
			
		}else{
			String fullName="";
			String gender="";
			String email="";
			Long contact=(long) 0;
			String organization="";
			for(int i=0;i<employees.size();i++){
				if(employees.get(i).getEmail().equals(request.getParameter("email"))){
					
					fullName=employees.get(i).getFullName();
					gender = employees.get(i).getGender();
					email = employees.get(i).getEmail();
					contact = employees.get(i).getContact();
					organization = employees.get(i).getOrganization();
					
				}
			}
			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("email", email);
			request.setAttribute("contact", String.valueOf(contact));
			request.setAttribute("organization", organization);
			RequestDispatcher rd=request.getRequestDispatcher("/FriendProfile.jsp");  
			rd.forward(request, response);
		}
	}
}
