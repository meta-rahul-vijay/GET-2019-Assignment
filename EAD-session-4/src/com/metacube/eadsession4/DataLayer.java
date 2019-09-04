package com.metacube.eadsession4;

import java.io.PrintStream;
import java.sql.*;
/**
 * class to manage connectivity
 * @author Mahendar Singh
 */
public class DataLayer {

	private Connection con ;
	
	boolean setDriver(String driver) {
		try{
			Class.forName(driver);
			return true;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return false;
	}
	
	boolean setConnection(String conString,String user,String pass) {
		
		try{
		    con=DriverManager.getConnection(conString,user,pass);
		    return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	Connection getConnection(){
		return con;
	}
	
	
}
