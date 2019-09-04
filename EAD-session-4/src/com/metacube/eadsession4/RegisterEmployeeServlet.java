package com.metacube.eadsession4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servlet to register employee in data base
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class RegisterEmployeeServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		BusinessLayer bl =new BusinessLayer();
		
		String fullName=request.getParameter("ename");
		String gender = request.getParameter("egender");
		String email = request.getParameter("eemail");
		String password = request.getParameter("epass");
		Long contact = Long.parseLong(request.getParameter("ecnumber"));
		String organization = request.getParameter("eorganization");
		
		EmployeePojo employee = new EmployeePojo(fullName, gender, email, password, contact, organization);
		try {
			bl.insertIntoEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String content = "<br><br>"
						+"<p style='font-size:180%' > "+fullName +" Registered successfully..     <a href='LogIn.html'>"
								+ "click here to Login</a></p>";
		
		out.println(Variables.upperBody);
		out.println(content);
		out.println(Variables.lowerBody);
	
	}

}
