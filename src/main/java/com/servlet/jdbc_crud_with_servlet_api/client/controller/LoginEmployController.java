package com.servlet.jdbc_crud_with_servlet_api.client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;
import com.servlet.jdbc_crud_with_servlet_api.dto.Employ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginEmployController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("empEmail");
		String pass = req.getParameter("empPassword");
		
		Employ employ = new EmployDao().getEmployeByEmailDao(email);
		
		PrintWriter printWriter = resp.getWriter();
		
		if(employ!= null) {
			
			if(employ.getPassword().equals(pass)) {
				RequestDispatcher dispatcher =req.getRequestDispatcher("employ-display.jsp");
				dispatcher.forward(req, resp);
			}else {
				printWriter.write("<html><body><h4 style='color:red';>Password is Incorrect!</h4></body></html>");
				RequestDispatcher dispatcher =req.getRequestDispatcher("Employ-Login.jsp");
				dispatcher.include(req, resp);
				System.out.println("employ password is incorrect!!");
			}
		}else {
			printWriter.write("<html><body><h4 style='color:red';>Email is Incorrect!!</h4></body></html>");
			RequestDispatcher dispatcher =req.getRequestDispatcher("Employ-Login.jsp");
			dispatcher.include(req, resp);
			System.out.println("employ email is incorrect!");
		}
		
	}
}















