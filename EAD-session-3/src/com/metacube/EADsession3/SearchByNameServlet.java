package com.metacube.EADsession3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to search and filter student
 * @author Mahendar Singh
 *
 */
@WebServlet("/SearchByNameServlet")
public class SearchByNameServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		BusinessLayer bl=new BusinessLayer();
		/**
		 * search all students by full name
		 */
		if(request.getParameter("name")!=null){

			String name = request.getParameter("name");
			String studentName[] = name.split(" ");

			ArrayList<StudentPojo> students = null;

			if(studentName.length==2) {
				try {
					students = bl.getStudentName(studentName[0], studentName[1]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			String content ="<form action='SearchByNameServlet' style='margin-left: 1%'><h1>Filter by class</h1>"+
					"<input type='number' name='class' id='class' placeholder='enter class'>&emsp;"+
					"<input type='submit' value='Filter'></form><br>"+
					"<table border='1px'>"+
					"<th>FirstName</th> <th>LastName</th> <th>FatherName</th> <th>Email</th> <th>Class</th> <th>Age</th>";
			
			if(students != null){
				for(int i=0; i<students.size(); i++){
					content = content + "<tr>" +
							"<td>" + students.get(i).getFirstName() + "</td>" +
							"<td>" + students.get(i).getLastName() + "</td>" +
							"<td>" + students.get(i).getFatherName() + "</td>" +
							"<td>" + students.get(i).getEmail() + "</td>" +
							"<td>" + students.get(i).getStudentClass() + "</td>" +
							"<td>" + students.get(i).getAge() + "</td></tr>";	
				}
			}else{
				content = "<h1> Failed Try Again <h1>";
			}	
			out.println(Variables.upperBody+ content + Variables.lowerBody );

		}
		/**
		 * filter student by class
		 */
		else{
			ArrayList<StudentPojo> students = null;
			try {
				students = bl.getStudentByClass(Integer.parseInt(request.getParameter("class")));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			String content = "<form action='SearchByNameServlet' style='margin-left: 1%'><h1>Filter by class</h1>"+
					"<input type='number' name='class' id='class' placeholder='enter class'>&emsp;"+
					"<input type='submit' value='Filter'></form><br>"+
					"<table border='1px'>"+
					"<th>FirstName</th> <th>LastName</th> <th>FatherName</th> <th>Email</th> <th>Class</th> <th>Age</th>";

			if(students != null){
				for(int i=0; i<students.size(); i++){
					content = content + "<tr>" +
							"<td>" + students.get(i).getFirstName() + "</td>" +
							"<td>" + students.get(i).getLastName() + "</td>" +
							"<td>" + students.get(i).getFatherName() + "</td>" +
							"<td>" + students.get(i).getEmail() + "</td>" +
							"<td>" + students.get(i).getStudentClass() + "</td>" +
							"<td>" + students.get(i).getAge() + "</td></tr>";	
				}
			}else{
				content = "<h1> Failed Try Again <h1>";
			}	
			out.println(Variables.upperBody + content + Variables.lowerBody);

		}
	}


}
