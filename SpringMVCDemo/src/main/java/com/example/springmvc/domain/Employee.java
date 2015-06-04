package com.example.springmvc.domain;

public class Employee {
	
	private String firstName; 
	private String lastName; 
	private String email;
	private String telephone;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email,
			String telephone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String toString() {
		return this.firstName + " -- " + this.lastName + " -- " + this.email + " -- " + this.telephone;
	}
}
