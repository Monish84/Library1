<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" text="Red">
<center><h1>Student Login</h1></center>
<center><form action="student" method="post">
Student Name : <input type="text" name="Sname"><br/><br/>
Password : <input type="password" name="Spassword"><br/><br/>
<input type="submit" value="Login"><br/><br/>
<a href = "newStudent.jsp">New Student</a><br/><br/>
<a href="Validation.jsp">First Page</a>
</form></center>
</body>
</html>