<%@page import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="color:red">
	<%
		int a=10;
		
		if(a%2==0){
			System.out.println("Even number");
			out.print("Even number");
		}else{
			System.out.println("Odd number");
			out.print("Odd number");
		}
	
	%>
	
	<%for(int i=1; i<=10; i++){
		if(i%2==0){ 
			 %>
	<h4 style="color:green"><%=i %></h4>
	<%}else{ %>
	<h4 style="color:blue"><%=i %></h4>
	<%}} %>
	
	<%!
		public int addTwoNumber(int a, int b){
		return a+b;
	}
	%>
	<% int sum = addTwoNumber(12, 13);	%>
	<h4>Summation of a and b = <%= sum %></h4>
</body>
</html>