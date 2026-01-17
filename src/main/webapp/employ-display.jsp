<%@page import="com.servlet.jdbc_crud_with_servlet_api.dto.Employ"%>
<%@page import="com.servlet.jdbc_crud_with_servlet_api.dao.EmployDao"%>
<%@ page import="java.util.List" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h2 style=color:green>Welcome To Display Page</h2>
	
	<%
		List<Employ> employees=new EmployDao().fetchAllEmployDataDao();	
	%>
	
	<div>
		<table border="2" cellpadding="5px">
			<tr style=color:red>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>DOJ</th>
				<th>DESIGNATION</th>
				<th>GENDER</th>
				<th colspan="2">ACTION</th>
			</tr>
				
				<%for(Employ employ:employees){ %>
				
				<tr>
				
					<td><%=employ.getId() %></td>
					<td><%=employ.getName() %></td>
					<td><%=employ.getEmail() %></td>
					<td><%=employ.getPhone() %></td>
					<td><%=employ.getDoj() %></td>
					<td><%=employ.getDesignation() %></td>
					<td><%=employ.getGender()%></td>
					<td style="color:red"><a href="delete? id=<%=employ.getId()%>">DELETE</a></td>
					<td style="color:green">EDIT</td>
		
				</tr>
				<%} %>
				
		</table>
	
	</div>

</body>
</html>