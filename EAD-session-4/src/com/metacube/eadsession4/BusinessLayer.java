package com.metacube.eadsession4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * The Class BusinessLayer handle database operations.
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class BusinessLayer {


	//data layer object to make connection
	static DataLayer dl=new DataLayer();

	static {
		dl.setDriver(Variables.driverString) ;
		dl.setConnection(Variables.connectionString,Variables.user,Variables.password);
	}

	/**
	 * method to add employee in database.
	 * @param employee the employee to be added
	 * @throws SQLException the SQL exception
	 */
	public void insertIntoEmployee(EmployeePojo employee) throws SQLException{

		PreparedStatement insertStmt =dl.getConnection().prepareStatement("INSERT INTO Employee_record(Emp_name,Gender,Email,Password,Contact,Organization) VALUES(?,?,?,?,?,?)");

		insertStmt.setString(1,employee.getFullName());
		insertStmt.setString(2,employee.getGender());
		insertStmt.setString(3,employee.getEmail());
		insertStmt.setString(4,employee.getPassword());
		insertStmt.setLong(5,employee.getContact());
		insertStmt.setString(6,employee.getOrganization());

		insertStmt.execute();
		insertStmt.clearParameters();

	}

	/**
	 * checks if user exists
	 * @param email the email Id
	 * @param password the password
	 * @return the int employee Id
	 * @throws SQLException the SQL exception
	 */
	public int checkLogin(String email,String password) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT Emp_id FROM Employee_record WHERE Email = ? AND Password=?");
		selectStmt.setString(1, email);
		selectStmt.setString(2, password);
		ResultSet rset= selectStmt.executeQuery();

		if(rset.next()){
			return rset.getInt(1);
		}

		return 0;
	}

	/**
	 * Check  if user logging in first time.
	 * @param email the email Id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean checkFirstLogin(String email) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Employee_record , Vehicle_record WHERE Email = ? AND Employee_record.Emp_id=Vehicle_record.Emp_id");
		selectStmt.setString(1, email);
		ResultSet rset= selectStmt.executeQuery();

		if(rset.next()){
			return true;
		}

		return false;
	}

	/**
	 * add a vehicle.
	 * @param vehicle details
	 * @throws SQLException the SQL exception
	 */
	public void insertIntoVehicle(VehiclePojo vehicle) throws SQLException{

		PreparedStatement insertStmt =dl.getConnection().prepareStatement("INSERT INTO Vehicle_record VALUES(?,?,?,?,?)");

		insertStmt.setInt(1,vehicle.getEmpId());
		insertStmt.setString(2,vehicle.getVehicleName());
		insertStmt.setString(3,vehicle.getVehicleType());
		insertStmt.setString(4,vehicle.getVehicleNumber());
		insertStmt.setString(5,vehicle.getVehicleIdentity());

		insertStmt.execute();
		insertStmt.clearParameters();

	}

	/**
	 * choose a plan and add to database.
	 * @param empId the employee id
	 * @param vehicleNumber the vehicle number
	 * @param passType the type of pass
	 * @param price the price of plan choosen
	 * @throws SQLException the SQL exception
	 */
	public void insertIntoPlan(int empId, String vehicleNumber,String passType,float price) throws SQLException{

		PreparedStatement insertStmt =dl.getConnection().prepareStatement("INSERT INTO plan_record VALUES(?,?,?,?)");

		insertStmt.setInt(1,empId);
		insertStmt.setString(2,vehicleNumber);
		insertStmt.setString(3,passType);
		insertStmt.setFloat(4,price);

		insertStmt.execute();
		insertStmt.clearParameters();

	}

	/**
	 * Gets the employee details.
	 * @param empId the employee id
	 * @return the employee object
	 * @throws SQLException the SQL exception
	 */
	public EmployeePojo getEmployee(int empId) throws SQLException{

		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Employee_record WHERE Emp_id = ? ");
		selectStmt.setInt(1, empId);
		ResultSet rset= selectStmt.executeQuery();
		rset.next();
		EmployeePojo employee = new EmployeePojo(rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getLong(6),rset.getString(7));

		return employee;
	}

	/**
	 * Update employee details.
	 * @param employee the employee object
	 * @throws SQLException the SQL exception
	 */
	public void updateEmployee(EmployeePojo employee) throws SQLException{

		PreparedStatement insertStmt =dl.getConnection().prepareStatement("UPDATE Employee_record SET Emp_name=? ,Gender=?,Email=?,Password=?,Contact=?,Organization=? WHERE Email=?");

		insertStmt.setString(1,employee.getFullName());
		insertStmt.setString(2,employee.getGender());
		insertStmt.setString(3,employee.getEmail());
		insertStmt.setString(4,employee.getPassword());
		insertStmt.setLong(5,employee.getContact());
		insertStmt.setString(6,employee.getOrganization());
		insertStmt.setString(7,employee.getEmail());
		insertStmt.executeUpdate();
		insertStmt.clearParameters();

	}

	/**
	 * Gets the friends of a employee.
	 * @param empId the employee id
	 * @return list the friends of employee
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<EmployeePojo> getFriends(int empId) throws SQLException{

		ArrayList<EmployeePojo> employees= new ArrayList<EmployeePojo>();
		PreparedStatement selectStmt =dl.getConnection().prepareStatement("SELECT * FROM Employee_record WHERE Organization = (SELECT Organization FROM Employee_record WHERE Emp_id=?) AND Emp_id !=?");
		selectStmt.setInt(1, empId);
		selectStmt.setInt(2, empId);
		ResultSet rset= selectStmt.executeQuery();
		while(rset.next()){
			EmployeePojo employee = new EmployeePojo(rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getLong(6),rset.getString(7));
			employees.add(employee);

		}
		return employees;
	}

}
