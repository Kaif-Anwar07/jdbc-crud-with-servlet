package com.servlet.jdbc_crud_with_servlet_api.controller;

import java.util.Arrays;
import java.util.List;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;

public class DeleteMultipleData {
		public static void main(String[] args) {
			
			
			List<Integer> l1 = Arrays.asList(205,1234);
			boolean b=new EmployDao().deleteMultipleEmploy(l1);
			String msg = b?"All passed employee is deleted ":"Something went wrong";
			System.out.println(msg);
		}
}
