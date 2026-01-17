package com.servlet.jdbc_crud_with_servlet_api.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;
import com.servlet.jdbc_crud_with_servlet_api.dto.Employ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//************************SERVLET PROGRAM*********************************
public class InsertEmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		 // 🧠 All form data come as String so Convert to correct data types
		int id=Integer.parseInt(req.getParameter("empId"));
		
		String name=req.getParameter("empName");
		
		String email=req.getParameter("empEmail");
		
		String password=req.getParameter("empPassword");
		
		Long phone=Long.parseLong(req.getParameter("empPhone"));
		
		LocalDate DOJ=LocalDate.parse(req.getParameter("empDOJ"));
			
		String Designation=req.getParameter("empDesignation");
		
		String gender=req.getParameter("Gender");
		
		Employ employ=new Employ();
		employ.setId(id);
		employ.setName(name);
		employ.setEmail(email);
		employ.setEmail(email);
		employ.setPassword(password);
		employ.setPhone(phone);
		employ.setDoj(DOJ);
		employ.setDesignation(Designation);
		employ.setGender(gender);
		
		EmployDao dao =new EmployDao();
		
		Employ employ2=dao.saveEmployDao(employ);
		
		PrintWriter printWriter=resp.getWriter();
		
		if(employ2!=null) {
			printWriter.write("<html><body><h4 style='color:green';>You Are Registered.!!!</h4></body></html>");
			RequestDispatcher dispatcher =req.getRequestDispatcher("Employ-Login.jsp");
			dispatcher.include(req, resp);
			System.out.println("Data saved...");
			
		}
		else {
			printWriter.write("<html><body><h4 style='color:red';>Check Your Data,Something Went Wrong!!!</h4></body></html>");
			RequestDispatcher dispatcher =req.getRequestDispatcher("employ-Register.jsp");
			dispatcher.include(req, resp);
			System.out.println("Something Went Wrong.!!!");
		}
		
		
//		
//		System.out.println("id: "+id);
//		System.out.println("name: "+name);
//		System.out.println("email: "+email);
//		System.out.println("password: "+password);
//		System.out.println("phone: "+phone);
//		System.out.println("DOJ: "+DOJ);
//		System.out.println("Designation: "+Designation);
//		System.out.println("gender: "+gender);
	}
}
