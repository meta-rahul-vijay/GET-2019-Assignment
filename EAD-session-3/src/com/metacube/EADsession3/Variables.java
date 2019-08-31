package com.metacube.EADsession3;
/**
 * class to store static variables
 * @author Mahendar Singh
 *
 */
public class Variables {
	
	static String driverString = "com.mysql.cj.jdbc.Driver";
	static String  connectionString = "jdbc:mysql://localhost:3306/student";
	static String user = "root";
	static String password = "admin";
	
	static String upperBody = "<html> <head><title>Student List</title> <link rel='stylesheet' type='text/css' href='/EAD-session-3/navigation.css'></head> <body>"+
								"<ul>"+
									"<li><a class='active' href='index.html'>Home</a></li>"+
									"<li><a href='student_form.html'>Add Student</a></li>"+
									"<li><a href='ShowStudentServlet'>See Students</a></li>"+
									"<li><a href='search_student.html'>Search Student</a></li>"+
								"</ul>"+"<br><br>";
	
	static String lowerBody = "</body> <html>";
}
