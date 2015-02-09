package com.example.springmvc.domain;

public class Employee {
	
	private String firstName = "f"; 
	private String lastName = "l"; 
	private String email = "e";
	private String telephone = "t";

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
