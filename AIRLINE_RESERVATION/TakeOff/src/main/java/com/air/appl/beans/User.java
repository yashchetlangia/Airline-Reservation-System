package com.air.appl.beans;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Table(name = "Users")
public class User {
	//"user_id_generation"
	
	@Id
	@Column (name = "USER_ID")
	private int userId;
	
	@Column (name = "EMAIL")
	private String email;
	
	@Column (name = "PASSWORD")
	private String password;
	
	@Column (name = "TITLE")
	private String title;
	
	@Column (name = "FIRST_NAME")
	private String firstName;
	
	@Column (name = "LAST_NAME")
	private String lastName;
	
	@Column (name = "PHONE_NUMBER")
	private long phoneNumber;
	
	
	@Column (name = "DOB")
	private Date  dob ;


	public User() {
		super();
	}


	public User(int userId, String email, String password, String title, String firstName, String lastName,
			long phoneNumber,Date dob) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


public Date getDob() {
	return dob;
}



public void setDob(Date dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", title=" + title
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", dob="
				 +"]";
	}
	
	
}
