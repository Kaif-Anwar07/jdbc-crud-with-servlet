# JDBC CRUD with Servlet API

This project is a Java web application that demonstrates **CRUD operations
(Create, Read, Update, Delete)** using **JDBC and Servlet API**.
It connects a Java application with a MySQL database and performs operations
on employee data.

This is a beginner-level backend project focused on understanding
database connectivity and servlet-based request handling.

---

# Features

- Insert employee data
- Display all employee records
- Update employee information
- Delete employee records
- JDBC-based database connectivity
- Servlet-based request handling
- Maven project structure

---

# Technologies Used

- Java
- JDBC
- Servlet API
- MySQL
- Maven
- Apache Tomcat
- Eclipse IDE

---

# Project Structure
src/
└── com.jspider.jdbc_crud_with_servlet_api
├── connection
│ └── EmployeeConnection.java
└── controller
├── InsertEmployeeController.java
├── FetchAllEmployeeController.java
├── DeleteEmployeeController.java
├── DeleteMultipleData.java
└── LoginEmployeeController.java

---

# How It Works

1. Servlet receives request from client
2. JDBC establishes connection with MySQL database
3. SQL queries are executed using JDBC
4. Result is processed and sent back as response

---

# How To Run the Project

1. Clone the repository:
git clone -https://github.com/Kaif-Anwar07/jdbc-crud-with-servlet.git

2. Import the project into **Eclipse** as a Maven project

3. Configure **Apache Tomcat** server

4. Create a MySQL database and required tables

5. Update database username and password in JDBC connection class

6. Run the project on Tomcat server

---

##  Author

**Kaif Anwar**  
Java Backend Developer | JDBC | Servlet | MySQL
