package com.metacube.EADsession3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet to add student
 * @author Mahendar Singh
 *
 */
public class AddStudentServlet extends HttpServlet{

	/**
	 * service method of servlet
	 */
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException{

		PrintWriter out = response.getWriter();

		BusinessLayer bl=new BusinessLayer();

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("email");
		int studentClass = Integer.parseInt(request.getParameter("class"));
		int age = Integer.parseInt(request.getParameter("age"));

		StudentPojo student  = new StudentPojo(firstName,lastName,fatherName ,email,studentClass,age );

		out.print(Variables.upperBody);
		try {
			bl.insertIntoStudent(student);
		} catch (SQLException e) {
			out.println("<p style='font-size:150%'>Email Id already exists , please try again </p>");
			return;
		}

		out.println("<p style='font-size:150%' >Student " +firstName + " registered successfully</p>");
		out.print(Variables.lowerBody);

	}

}
