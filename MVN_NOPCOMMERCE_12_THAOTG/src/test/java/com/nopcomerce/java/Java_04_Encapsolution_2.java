package com.nopcomerce.java;

public class Java_04_Encapsolution_2 {
	private String firstName ="Automation", lastName="Test";
	public String address, city;
	String phone, email;
	protected String password;
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
	public void showFirstAndLastname() {
		System.out.println("First Name = "+firstName);
		System.out.println("Last Name = "+lastName);
	}
	public class Mobile{
		
	}
}
