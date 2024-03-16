package com.air.appl.beans;

import javax.persistence.*;


@Entity
@Table(name = "Admins")
public class Admin {
		
	
	@Id
	@Column (name = "ADMIN_ID")
	private int adminId;
	
	@Column (name = "EMAIL")
	private String email;
	
	@Column (name = "PASSWORD")
	private String password;
	

	

	public Admin() {
		super();
	}

	public Admin(int adminId, String email, String password) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", password=" + password + "]";
	}
	



	


	
	




	
	
	
}
