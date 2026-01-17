package com.servlet.jdbc_crud_with_servlet_api.controller;

import java.time.LocalDate;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;
import com.servlet.jdbc_crud_with_servlet_api.dto.Employ;

public class InsertEmployController {
	public static void main(String[] args) {
		Employ employ=new Employ();
		employ.setId(1234);
		employ.setName("Amit");
		employ.setEmail("Amit654@gmail.com");
		employ.setPassword("Amit@321#");
		employ.setPhone(985746545);
		employ.setDoj(LocalDate.parse("2025-09-15"));
		employ.setDesignation("Software engineer");
		employ.setGender("Male");
		
		EmployDao dao=new EmployDao();
		Employ dbEmploy=dao.saveEmployDao(employ);
		
		String msg=dbEmploy!=null?"Data Stored":"Something went wrong";
		System.out.println(msg);
	}
}
