package com.servlet.jdbc_crud_with_servlet_api.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import com.servlet.jdbc_crud_with_servlet_api.connection.EmployConnection;
import com.servlet.jdbc_crud_with_servlet_api.dto.Employ;

public class EmployDao {
	Connection connection = EmployConnection.getEmployConnection();

	PreparedStatement ps = null;

	public Employ saveEmployDao(Employ employ) {
		String insertEmployQuery = "INSERT INTO Employ(id,name,email,password,phone,doj,designation,gender) Values(?,?,?,?,?,?,?,?)";

		try {
			ps = connection.prepareStatement(insertEmployQuery);
			ps.setInt(1, employ.getId());
			ps.setString(2, employ.getName());
			ps.setString(3, employ.getEmail());
			ps.setString(4, employ.getPassword());
			ps.setLong(5, employ.getPhone());
			ps.setObject(6, employ.getDoj());
			ps.setString(7, employ.getDesignation());
			ps.setString(8, employ.getGender());

			int a = ps.executeUpdate();

			return a != 0 ? employ : null;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null && connection != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employ;

	}

	public List<Employ> fetchAllEmployDataDao() {

		String displayEmployQuery = "SELECT * FROM employ";

		ResultSet set = null;

		try {
			ps = connection.prepareStatement(displayEmployQuery);
			set = ps.executeQuery();

			List<Employ> employees = new ArrayList<Employ>();

			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
//				String password=set.getString("password");
				Long phone = set.getLong("phone");
				LocalDate doj = set.getDate("doj").toLocalDate();
				String designation = set.getString("designation");
				String gender = set.getString("gender");

				Employ employ = new Employ();

				employ.setId(id);
				employ.setName(name);
				employ.setEmail(email);
//				employ.setPassword(password);
				employ.setPhone(phone);
				employ.setDoj(doj);
				employ.setDesignation(designation);
				employ.setGender(gender);

				employees.add(employ);
			}

			// after while loop
			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (set != null && ps != null && connection != null) {
				try {
					set.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Employ> saveMultipleEmployeeDao(List<Employ> employees) {
		String insertEmployQuery = "INSERT INTO Employ(id,name,email,password,phone,doj,designation,gender) Values(?,?,?,?,?,?,?,?)";

		try {

			connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(insertEmployQuery);
			for (Employ employ : employees) {
				ps.setInt(1, employ.getId());
				ps.setString(2, employ.getName());
				ps.setString(3, employ.getEmail());
				ps.setString(4, employ.getPassword());
				ps.setLong(5, employ.getPhone());
				ps.setObject(6, employ.getDoj());
				ps.setString(7, employ.getDesignation());
				ps.setString(8, employ.getGender());

				ps.addBatch();
			}
			int a[] = ps.executeBatch();

			connection.commit();

			if (a.length != 0) {
				System.out.println(a.length + " row affected in db table");
				return employees;
			}
			return null;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null && ps != null) {
					ps.close();
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	public static void delete_A_Data(int id) {
		Connection c = null;
		PreparedStatement ps =null;

		String query = "DELETE FROM Employ WHERE id=?";
		try {
			c = EmployConnection.getEmployConnection();
			ps = c.prepareStatement(query);

			ps.setInt(1, id);
			int a = ps.executeUpdate();

			if (a > 0)
				System.out.println("Deleted Successfully");
			else
				System.out.println("Failed to delete");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null && c!=null) {
					ps.close();
					c.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean deleteMultipleEmploy(List<Integer> employId) {
		
		String deleteQuery="delete from employ where id=?";
		PreparedStatement ps=null;
		
		try {
			connection.setAutoCommit(false);
			
			 ps=connection.prepareStatement(deleteQuery);
			
			for(Integer id:employId) {
				ps.setInt(1, id);
				ps.addBatch();
				
				int a[]=ps.executeBatch();
				connection.commit();
				
				for(int result:a) {
					if(result==0) {
						return false;
					}
				}
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				
				connection.setAutoCommit(true);
				
			}catch(SQLException e2) {
				e2.printStackTrace();
				
			}
		}
		return false;
	}
	
	public Employ getEmployeByEmailDao(String empEmail) {
		
		String displayEmployQuery = "Select * from employ where email=?";
		
		ResultSet set = null;
		
		try {
			ps=connection.prepareStatement(displayEmployQuery);
			
			ps.setString(1, empEmail);
			
			set =ps.executeQuery();
			
			if(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				String password=set.getString("password");
				Long phone = set.getLong("phone");
				LocalDate doj = set.getDate("doj").toLocalDate();
				String designation = set.getString("designation");
				String gender = set.getString("gender");
				
				Employ employ =new Employ();
				employ.setId(id);
				employ.setName(name);
				employ.setEmail(email);
				employ.setPassword(password);
				employ.setPhone(phone);
				employ.setDoj(doj);
				employ.setDesignation(designation);
				employ.setGender(gender);
				
				return employ;
			}
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(set !=null && connection != null && ps!=null){
				try {
					set.close();
					connection.close();
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
