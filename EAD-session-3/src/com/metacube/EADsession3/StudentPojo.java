package com.metacube.EADsession3;

public class StudentPojo {

	private String firstName;
	private String lastName;
	private String fatherName;
	private String email;
	private int age;
	private int studentClass;

	public StudentPojo() {
	}
	
	public StudentPojo(String firstName,String lastName,String fatherName,String email,int studentClass,int age) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.fatherName=fatherName;
		this.setEmail(email);
		this.age=age;
		this.studentClass=studentClass;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getStudentClass() {
		return studentClass;
	}
	
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

