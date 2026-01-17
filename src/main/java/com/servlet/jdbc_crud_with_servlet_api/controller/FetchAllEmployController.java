package com.servlet.jdbc_crud_with_servlet_api.controller;

import com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao;
import com.servlet.jdbc_crud_with_servlet_api.dto.Employ;

import java.util.*;
public class FetchAllEmployController {
	public static void main(String[] args) {
		EmployDao dao=new EmployDao();
		List<Employ> employ =dao.fetchAllEmployDataDao();
		if(!employ.isEmpty()) {
			for(Employ employs :employ) {
				System.out.println(employs);
			}
		}else {
			System.out.println("no data found!");
		}
	}
}
