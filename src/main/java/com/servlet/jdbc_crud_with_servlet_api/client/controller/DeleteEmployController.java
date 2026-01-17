package com.servlet.jdbc_crud_with_servlet_api.client.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/delete")
public class DeleteEmployController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(id);
		
		boolean b= new EmployDao().deleteMultipleEmploy(integers);
	
	String msg = b?"deleted":"check given id or check your code";
	
	System.out.println(msg);
	
	req.getRequestDispatcher("employ-display.jsp").forward(req, resp);
	}
}
