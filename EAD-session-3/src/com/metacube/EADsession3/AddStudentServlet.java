package com.metacube.EADsession3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddStudentServlet extends HttpServlet{
	
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		
		DataLayer dl=new DataLayer();
		dl.setDriver("com.mysql.jdbc.Driver") ;
        dl.setConnection("jdbc:mysql://localhost:3306/student","root","admin");
        
		BusinessLayer bl=new BusinessLayer();
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("email");
		int studentClass = Integer.parseInt(request.getParameter("class"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		StudentPojo student  = new StudentPojo(firstName,lastName,fatherName ,email,studentClass,age );
		
		try {
			bl.insertIntoStudent(dl, student);
		} catch (SQLException e) {
			out.println("Email Id already exists , please try again ");
			return;
		}
		
		
		out.print("<html><head><link rel='stylesheet' type='text/css' href='/EAD-session-3/navigation.css'></head><body>");
		out.println("<ul>"+
			"<li><a class='active' href='index.html'>Home</a></li>"+
			"<li><a href='student_form.html'>Add Student</a></li>"+
			"<li><a href='ShowStudentServlet'>See Students</a></li>"+
			"<li><a href='search_student.html'>Search Student</a></li>"+
				"</ul>");
		out.println("<br><br>");
		out.println("<p style='font-size:150%' >Student " +firstName + " registered successfully</p>");
		out.print("</body></html>");
		
		out.println("Student " +firstName + " registered successfully");
		
	}

}
