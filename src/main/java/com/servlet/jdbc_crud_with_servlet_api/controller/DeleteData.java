package com.servlet.jdbc_crud_with_servlet_api.controller;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;

public class DeleteData {
	public static void main(String[] args) {
		EmployDao dao=new EmployDao();
		
		EmployDao.delete_A_Data(201);
	}
}
