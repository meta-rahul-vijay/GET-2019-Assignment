package com.metacube.EADsession3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowStudentServlet")
public class ShowStudentServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

		PrintWriter out = response.getWriter();

		DataLayer dl=new DataLayer();
		dl.setDriver("com.mysql.jdbc.Driver") ;
		dl.setConnection("jdbc:mysql://localhost:3306/student","root","admin");

		BusinessLayer bl=new BusinessLayer();

		if(request.getParameter("email")==null&&request.getParameter("Semail")==null){

			ArrayList<StudentPojo> studentList = null;
			try {
				studentList = bl.getStudent(dl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String upperBody = "<html> <head><title>Student List</title> <link rel='stylesheet' type='text/css' href='/EAD-session-3/navigation.css'></head> <body>";
			String lowerBody = "</body> <html>";
			String navigation ="<ul>"+
					"<li><a class='active' href='index.html'>Home</a></li>"+
					"<li><a href='student_form.html'>Add Student</a></li>"+
					"<li><a href='ShowStudentServlet'>See Students</a></li>"+
					"<li><a href='search_student.html'>Search Student</a></li>"+
						"</ul>"+"<br><br>";
			String content = "<ul>"+
					"<li><a class='active' href='index.html'>Home</a></li>"+
					"<li><a href='student_form.html'>Add Student</a></li>"+
					"<li><a href='ShowStudentServlet'>See Students</a></li>"+
					"<li><a href='search_student.html'>Search Student</a></li>"+
						"</ul>"+"<br><br>"+
						"<table align ='center'>" +
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
							"<td>" + "<a href=/EAD-session-3/ShowStudentServlet?email="+studentList.get(i).getEmail()+">Update</a>" + "</td>";	

				}
			}else{
				content = "<h1> Failed Try Again <h1>";
			}	
			out.println(upperBody + lowerBody + content);

		}else if(request.getParameter("email")!=null){
			StudentPojo student=null;
			try {
				student = bl.getStudentByEmail(dl, request.getParameter("email"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("<html><head><link rel='stylesheet' type='text/css' href='/EAD-session-3/navigation.css'></head><body>");
			out.println("<ul>"+
					"<li><a class='active' href='index.html'>Home</a></li>"+
					"<li><a href='student_form.html'>Add Student</a></li>"+
					"<li><a href='ShowStudentServlet'>See Students</a></li>"+
					"<li><a href='search_student.html'>Search Student</a></li>"+
						"</ul>"); 
				out.println("<br><br>");
			out.print("<form  action = './ShowStudentServlet' method = 'Post' ><h1 align ='center'>Student details</h1>"); 
			out.print("<table align ='center'> "
					+ "<tr><td>First Name :</td> <td> <input type = 'text' name = 'first_name' value = '"+student.getFirstName()+"' required></td></tr>"
					+ "<tr><td>last Name :</td> <td> <input type = 'text' name = 'last_name' value = '"+student.getLastName()+"' required></td></tr>"
					+ "<tr><td>Father Name :</td> <td> <input type = 'text' name = 'father_name' value = '"+student.getFatherName()+"' required></td></tr>"
					+ "<tr><td>Email :</td> <td> <input type = 'text' name = 'Semail' value = '"+student.getEmail()+"' required></td></tr>"
					+ "<tr><td>Class :</td> <td> <input type = 'text' name = 'Sclass' value = '"+student.getStudentClass()+"' required></td></tr>"
					+ "<tr><td>Age :</td> <td> <input type = 'text' name = 'Sage' value = '"+student.getAge()+"' required></td></tr>"
					+ "<tr> <td>  <input type = 'submit' value= 'Update' id='submit' colspan='2'></tr>"
					+ "</table></form>");
			out.print("</body></html>");	


		}else{

			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String fatherName = request.getParameter("father_name");
			String email = request.getParameter("Semail");
			int studentClass = Integer.parseInt(request.getParameter("Sclass"));
			int age = Integer.parseInt(request.getParameter("Sage"));

			StudentPojo student  = new StudentPojo(firstName,lastName,fatherName ,email,studentClass,age );


			try {
				bl.updateStudent(dl, student);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			out.print("<html><head><link rel='stylesheet' type='text/css' href='/EAD-session-3/navigation.css'></head><body>");
			out.println("<ul>"+
				"<li><a class='active' href='index.html'>Home</a></li>"+
				"<li><a href='student_form.html'>Add Student</a></li>"+
				"<li><a href='ShowStudentServlet'>See Students</a></li>"+
				"<li><a href='search_student.html'>Search Student</a></li>"+
					"</ul>");
			out.println("<br><br>");
			out.print("<p style='font-size:150%' >Student "+student.getFirstName()+" updated successfully</p>");
			out.print("</body></html>");	
		}
	}

}
