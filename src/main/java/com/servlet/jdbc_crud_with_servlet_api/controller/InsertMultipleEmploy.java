package com.servlet.jdbc_crud_with_servlet_api.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;
import com.servlet.jdbc_crud_with_servlet_api.dto.Employ;

public class InsertMultipleEmploy {
	public static void main(String[] args) {
		Employ employ=new Employ();
		employ.setId(201);
		employ.setName("Arun");
		employ.setEmail("Arun34@gmail.com");
		employ.setPassword("Arun784@1");
		employ.setPhone(985858586);
		employ.setDoj(LocalDate.parse("1998-01-09"));
		employ.setDesignation("Java Developer");
		employ.setGender("Male");
		
		
		Employ employ1=new Employ();
		employ1.setId(20);
		employ1.setName("tarun");
		employ1.setEmail("tarun34@gmail.com");
		employ1.setPassword("Arun784@1");
		employ1.setPhone(912125586);
		employ1.setDoj(LocalDate.parse("1997-12-05"));
		employ1.setDesignation("Sql Developer");
		employ1.setGender("Male");
		
		Employ employ2=new Employ();
		employ2.setId(203);
		employ2.setName("Warun");
		employ2.setEmail("Warun34@gmail.com");
		employ2.setPassword("Warun784@1");
		employ2.setPhone(912456586);
		employ2.setDoj(LocalDate.parse("1990-02-05"));
		employ2.setDesignation("Web Developer");
		employ2.setGender("Male");
		List<Employ> employees=Arrays.asList(employ,employ1,employ2);
		
		List<Employ> employees2=new EmployDao().saveMultipleEmployeeDao(employees);
		
		
	}
}
