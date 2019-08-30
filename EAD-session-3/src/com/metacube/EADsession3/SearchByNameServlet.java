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


@WebServlet("/SearchByNameServlet")
public class SearchByNameServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out = response.getWriter();

		DataLayer dl=new DataLayer();
		dl.setDriver("com.mysql.jdbc.Driver") ;
		dl.setConnection("jdbc:mysql://localhost:3306/student","root","admin");

		BusinessLayer bl=new BusinessLayer();

		if(request.getParameter("name")!=null){

			String name = request.getParameter("name");
			System.out.println(name);
			String studentName[] = name.split(" ");
			System.out.println(studentName[0]+" "+studentName[1]);
			ArrayList<StudentPojo> students = null;
			try {
				students = bl.getStudentName(dl, studentName[0], studentName[1]);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			
			String upperBody = "<html> <head><title>Student List</title> <link rel='stylesheet' type='text/css' href='/EAD-session-3/studentDisplay.css'></head> <body>";
			String lowerBody = "</body> <html>";
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
			out.println(upperBody + lowerBody + content);

		}else{

			ArrayList<StudentPojo> students = null;
			try {
				students = bl.getStudentByClass(dl, Integer.parseInt(request.getParameter("class")));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			
			String upperBody = "<html> <head><title>Student List</title> <link rel='stylesheet' type='text/css' href='/EAD-session-3/studentDisplay.css'></head> <body>";
			String lowerBody = "</body> <html>";
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
			out.println(upperBody + lowerBody + content);

		}
	}


}
