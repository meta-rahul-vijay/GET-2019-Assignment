package com.metacube.EADsession3;


import java.sql.*;
import java.util.*;
public class BusinessLayer {

	public void insertIntoStudent(DataLayer dl,StudentPojo student) throws SQLException{


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

	public ArrayList<StudentPojo> getStudent(DataLayer dl) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Student_record");
		ResultSet rset= selectStmt.executeQuery();

		ArrayList<StudentPojo> students = new ArrayList<StudentPojo>();

		while(rset.next()){

			StudentPojo student =new StudentPojo(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getInt(6));
			students.add(student);
		}

		return students;
	}

	public StudentPojo getStudentByEmail(DataLayer dl,String email) throws SQLException{

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
	
	public void updateStudent(DataLayer dl,StudentPojo student) throws SQLException{

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
	
	
	public ArrayList<StudentPojo> getStudentName(DataLayer dl,String firstName,String lastName) throws SQLException{

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
	
	public ArrayList<StudentPojo> getStudentByClass(DataLayer dl,int studentClass) throws SQLException{

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
