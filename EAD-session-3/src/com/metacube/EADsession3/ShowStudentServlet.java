package com.metacube.EADsession3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to see and update student
 * @author Mahendar Singh
 *
 */
@WebServlet("/ShowStudentServlet")
public class ShowStudentServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

		PrintWriter out = response.getWriter();

		BusinessLayer bl=new BusinessLayer();

		/**
		 * show all students
		 */
		if(request.getParameter("email")==null&&request.getParameter("Semail")==null){

			System.out.println("hi");
			
			ArrayList<StudentPojo> studentList = null;
			try {
				studentList = bl.getStudent();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String content ="<table align ='center'>" +
					"<th>FirstName</th> <th>LastName</th> <th>FatherName</th> <th>Email</th> <th>Class</th> <th>Age</th>";

			if(studentList != null){
				for(int i=0; i<studentList.size(); i++){
					content = content + "<tr>" +
							"<td>" + studentList.get(i).getFirstName() + "</td>" +
							"<td>" + studentList.get(i).getLastName() + "</td>" +
							"<td>" + studentList.get(i).getFatherName() + "</td>" +
							"<td>" + studentList.get(i).getEmail() + "</td>" +
							"<td>" + studentList.get(i).getStudentClass() + "</td>" +
							"<td>" + studentList.get(i).getAge() + "</td>" +
							"<td>" + "<a href=/EAD-session-3/ShowStudentServlet?email="+studentList.get(i).getEmail()+">Update</a>" + "</td>"+
							"</tr>";	
				}
			}else{
				content = "<h1> Failed Try Again <h1>";
			}	
			out.println(Variables.upperBody + content + Variables.lowerBody);

		}
		/**
		 * show page to update student details
		 */
		else if(request.getParameter("email")!=null){
			StudentPojo student=null;
			try {
				student = bl.getStudentByEmail(request.getParameter("email"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print(Variables.upperBody);
			out.println("<div align ='center'>");
			out.print("<form  action = './ShowStudentServlet' method = 'Post' ><h1>Student details</h1><hr>"); 
			out.print("<table> "
					+ "<tr><td>First Name :</td> <td> <input type = 'text' name = 'first_name' value = '"+student.getFirstName()+"' required></td></tr>"
					+ "<tr><td>last Name :</td> <td> <input type = 'text' name = 'last_name' value = '"+student.getLastName()+"' required></td></tr>"
					+ "<tr><td>Father Name :</td> <td> <input type = 'text' name = 'father_name' value = '"+student.getFatherName()+"' required></td></tr>"
					+ "<tr><td>Email :</td> <td> <input type = 'text' name = 'Semail' value ='"+student.getEmail()+"' readonly></td></tr>"
					+ "<tr><td>Class :</td> <td> <input type = 'text' name = 'Sclass' value = '"+student.getStudentClass()+"' required></td></tr>"
					+ "<tr><td>Age :</td> <td> <input type = 'text' name = 'Sage' value = '"+student.getAge()+"' required></td></tr>"
					+ "</table>"
					+ "<input type = 'submit' value= 'Update' id='submit'>"
					+ "</form></div>");
			out.print(Variables.lowerBody);	

		}
		/**
		 * update student details in database
		 */
		else{
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String fatherName = request.getParameter("father_name");
			String email = request.getParameter("Semail");
			int studentClass = Integer.parseInt(request.getParameter("Sclass"));
			int age = Integer.parseInt(request.getParameter("Sage"));

			StudentPojo student  = new StudentPojo(firstName,lastName,fatherName ,email,studentClass,age );

			try {
				bl.updateStudent( student);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			out.print(Variables.upperBody);
			out.print("<p style='font-size:150%' >Student "+student.getFirstName()+" updated successfully</p>");
			out.print(Variables.lowerBody);	
		}
	}

}
