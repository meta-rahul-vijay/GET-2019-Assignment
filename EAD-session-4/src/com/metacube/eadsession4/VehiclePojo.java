package com.metacube.eadsession4;

/**
 * pojo class for vehicle
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class VehiclePojo {
	
	/** The emp id. */
	int empId;
	
	/** The vehicle identity. */
	String vehicleName ,vehicleType,vehicleNumber,vehicleIdentity;
	
	/**
	 * Instantiates a new vehicle pojo.
	 * @param empId 
	 * @param vehicleName
	 * @param vehicleType
	 * @param vehicleNumber
	 * @param vehicleIdentity
	 */
	public VehiclePojo(int empId, String vehicleName, String vehicleType,String vehicleNumber, String vehicleIdentity) {
		this.empId = empId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleIdentity = vehicleIdentity;
	}
	
	/**
	 * Gets the emp id.
	 * @return the emp id
	 */
	public int getEmpId() {
		return empId;
	}
	
	/**
	 * Sets the emp id.
	 * @param empId 
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	/**
	 * Gets the vehicle name.
	 * @return the vehicle name
	 */
	public String getVehicleName() {
		return vehicleName;
	}
	
	/**
	 * Sets the vehicle name.
	 * @param vehicleName 
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	/**
	 * Gets the vehicle type.
	 * @return the vehicle type
	 */
	public String getVehicleType() {
		return vehicleType;
	}
	
	/**
	 * Sets the vehicle type.
	 * @param vehicleType 
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	/**
	 * Gets the vehicle number.
	 * @return the vehicle number
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	/**
	 * Sets the vehicle number.
	 * @param vehicleNumber
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	/**
	 * Gets the vehicle identity.
	 * @return the vehicle identity
	 */
	public String getVehicleIdentity() {
		return vehicleIdentity;
	}
	
	/**
	 * Sets the vehicle identity.
	 * @param vehicleIdentity
	 */
	public void setVehicleIdentity(String vehicleIdentity) {
		this.vehicleIdentity = vehicleIdentity;
	}
	
}
