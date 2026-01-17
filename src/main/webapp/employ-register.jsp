<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employ-Register</title>
</head>
<body>
<h1>Register Form</h1>
	<div>
		<form action="employRegister" method="get">

			<label>EmpId:</label><br> 
			<input type="text" placeholder="Enter emp id" name="empId"><br>
			 <label>EmpName:</label><br>
			<input type="text" placeholder="Enter your name " name="empName"><br>

			<label>EmpEmail:</label><br>
			 <input type="email" placeholder="Enter Your email" name="empEmail"><br>
			  <label>EmpPassword:</label><br>
			<input type="password" placeholder="Enter Your password"name="empPassword"><br> 
			<label>EmpPhone:</label><br>
			<input type="tel" placeholder="Enter Your PhoneNo." name="empPhone"><br>

			<label>EmpDOJ:</label><br> 
			<input type="date" name="empDOJ"><br>

			<label>EmpDesignation:</label><br>
			 <input type="text" placeholder="Enter Your Designation" name="empDesignation"><br>

			<label>Gender:</label><br> <input type="radio" value="MALE"
				name="Gender">MALE <input type="radio" value="FEMALE"
				name="Gender">FEMALE <input type="radio" value="OTHER"
				name="Gender">OTHER <br> 
				<input type="submit"
				value="Register">
		</form>


	</div>

</body>
</html>