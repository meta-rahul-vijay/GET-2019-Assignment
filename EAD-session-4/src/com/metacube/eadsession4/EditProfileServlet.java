package com.metacube.eadsession4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * servlet to edit profile of a user.
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class EditProfileServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out= response.getWriter();

		BusinessLayer bl=new BusinessLayer();

		HttpSession session = request.getSession();
		int empId=Integer.parseInt(session.getAttribute("empId").toString());

		if(request.getParameter("ename")==null){
			EmployeePojo employee =null;
			try {
				employee=bl.getEmployee(empId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.setAttribute("fullName", employee.getFullName());
			request.setAttribute("gender", employee.getGender());
			request.setAttribute("email", employee.getEmail());
			request.setAttribute("password", employee.getPassword());
			request.setAttribute("contact", String.valueOf(employee.getContact()));
			request.setAttribute("organization", employee.getOrganization());
			RequestDispatcher rd=request.getRequestDispatcher("/EditProfile.jsp");  
			rd.forward(request, response);
		}else{

			String fullName=request.getParameter("ename");
			String gender = request.getParameter("egender");
			String email = request.getParameter("eemail");
			String password = request.getParameter("epass");
			Long contact = Long.parseLong(request.getParameter("ecnumber"));
			String organization = request.getParameter("eorganization");

			EmployeePojo employee = new EmployeePojo(fullName, gender, email, password, contact, organization);
			try {
				bl.updateEmployee(employee);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");  
			rd.include(request,response);  

			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('details updated successfully');");  
			out.println("</script>");


		}
	}

}
