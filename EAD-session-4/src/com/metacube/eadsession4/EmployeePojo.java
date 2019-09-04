package com.metacube.eadsession4;

/**
 * pojo class for employee.
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class EmployeePojo {
	
	/** The organization. */
	String fullName,gender,email,password,organization;
	
	/** The contact. */
	long contact;
	
	/**
	 * Instantiates a new employee pojo.
	 * @param fullName 
	 * @param gender
	 * @param email
	 * @param password
	 * @param contact
	 * @param organization
	 */
	public EmployeePojo(String fullName, String gender, String email,String password, long contact ,String organization) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.organization = organization;
		this.contact = contact;
	}

	/**
	 * Instantiates a new employee pojo.
	 */
	public EmployeePojo() {
	}

	/**
	 * Gets the full name.
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * Sets the full name.
	 * @param fullName 
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Gets the gender.
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 * @param gender 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the organization.
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	
	/**
	 * Sets the organization.
	 * @param organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	/**
	 * Gets the contact.
	 * @return the contact
	 */
	public long getContact() {
		return contact;
	}
	
	/**
	 * Sets the contact.
	 * @param contact 
	 */
	public void setContact(long contact) {
		this.contact = contact;
	}

}
