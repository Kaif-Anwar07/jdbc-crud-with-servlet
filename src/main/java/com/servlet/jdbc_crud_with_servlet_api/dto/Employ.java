package com.servlet.jdbc_crud_with_servlet_api.dto;

import java.time.LocalDate;

public class Employ {
	private int id;
	private String name;
	private String email;
	private String password;
	private long phone;
	private LocalDate doj;
	private String designation;
	private String gender;
	
	
	public Employ() {
		super();
	}


	public Employ(int id, String name, String email, String password, long phone, LocalDate doj, String designation,
			String gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.doj = doj;
		this.designation = designation;
		this.gender = gender;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public long getPhone() {
		return phone;
	}


	public LocalDate getDoj() {
		return doj;
	}


	public String getDesignation() {
		return designation;
	}


	public String getGender() {
		return gender;
	}


	@Override
	public String toString() {
		return "Employ [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", doj=" + doj + ", designation=" + designation + ", gender=" + gender + "]";
	}
	
	
	
}
