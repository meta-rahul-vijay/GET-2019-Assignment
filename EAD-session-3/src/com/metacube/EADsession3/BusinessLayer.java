package com.metacube.EADsession3;

import java.sql.*;
import java.util.*;
/**
 * class containing methods for database operations
 * @author Mahendar Singh
 *
 */
public class BusinessLayer {

	//data layer object to make connection
	static DataLayer dl=new DataLayer();

	static {
		dl.setDriver(Variables.driverString) ;
		dl.setConnection(Variables.connectionString,Variables.user,Variables.password);
	}

	/**
	 * method to add student in database
	 * @param student
	 * @throws SQLException
	 */
	public void insertIntoStudent(StudentPojo student) throws SQLException{
		
		PreparedStatement insertStmt =dl.getConnection().prepareStatement("INSERT INTO Student_record VALUES(?,?,?,?,?,?)");

		insertStmt.setString(1,student.getFirstName());
		insertStmt.setString(2,student.getLastName());
		insertStmt.setString(3,student.getFatherName());
		insertStmt.setString(4,student.getEmail());
		insertStmt.setInt(5,student.getStudentClass());
		insertStmt.setInt(6,student.getAge());

		insertStmt.execute();
		insertStmt.clearParameters();

	}

	/**
	 * method to fetch all students
	 * @return student list
	 * @throws SQLException
	 */
	public ArrayList<StudentPojo> getStudent() throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Student_record");
		ResultSet rset= selectStmt.executeQuery();

		ArrayList<StudentPojo> students = new ArrayList<StudentPojo>();

		while(rset.next()){

			StudentPojo student =new StudentPojo(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getInt(6));
			students.add(student);
		}

		return students;
	}

	/**
	 * fetch student details by email
	 * @param email
	 * @return student details
	 * @throws SQLException
	 */
	public StudentPojo getStudentByEmail(String email) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Student_record WHERE email = ?");
		selectStmt.setString(1, email);
		ResultSet rset= selectStmt.executeQuery();

		ArrayList<StudentPojo> students = new ArrayList<StudentPojo>();

		StudentPojo student=null;
		while(rset.next()){
			student =new StudentPojo(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getInt(6));
		}

		return student;
	}

	/**
	 * method to update a student details
	 * @param student containing student details
	 * @throws SQLException
	 */
	public void updateStudent(StudentPojo student) throws SQLException{

		PreparedStatement updateStmt =dl.getConnection().prepareStatement("UPDATE Student_record SET First_name =? ,Last_name = ? ,Father_name = ?, Email = ? ,Class = ? ,Age =? WHERE Email = ?");
		updateStmt.setString(1, student.getFirstName());
		updateStmt.setString(2, student.getLastName());
		updateStmt.setString(3, student.getFatherName());
		updateStmt.setString(4, student.getEmail());
		updateStmt.setInt(5, student.getStudentClass());
		updateStmt.setInt(6, student.getAge());
		updateStmt.setString(7, student.getEmail());

		updateStmt.executeUpdate();

	}

	/**
	 * fetch student by full name
	 * @param firstName
	 * @param lastName
	 * @return student details
	 * @throws SQLException
	 */
	public ArrayList<StudentPojo> getStudentName(String firstName,String lastName) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Student_record WHERE First_name = ? AND Last_name = ? ");
		selectStmt.setString(1, firstName);
		selectStmt.setString(2, lastName);
		ResultSet rset= selectStmt.executeQuery();

		ArrayList<StudentPojo> students = new ArrayList<StudentPojo>();

		StudentPojo student=null;
		while(rset.next()){

			student =new StudentPojo(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getInt(6));
			students.add(student);
		}

		PreparedStatement viewStmt =dl.getConnection().prepareStatement("CREATE OR REPLACE VIEW studentDetails AS SELECT * FROM Student_record WHERE First_name = ? AND Last_name = ? ");
		viewStmt.setString(1, firstName);
		viewStmt.setString(2, lastName);
		viewStmt.execute();
		return students;
	}

	/**
	 * filter student by class 
	 * @param studentClass
	 * @return student list in that class
	 * @throws SQLException
	 */
	public ArrayList<StudentPojo> getStudentByClass(int studentClass) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM studentDetails WHERE Class = ? ");
		selectStmt.setInt(1, studentClass);
		ResultSet rset= selectStmt.executeQuery();

		ArrayList<StudentPojo> students = new ArrayList<StudentPojo>();

		StudentPojo student=null;
		while(rset.next()){

			student =new StudentPojo(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getInt(6));
			students.add(student);
		}

		return students;
	}
}
