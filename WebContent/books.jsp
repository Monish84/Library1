<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" text="Red">
<center><h1>ADD BOOKS</h1></center><br/>
<center><form action="addBooks" method="post">
Book Name : <input type="text" name="bname"><br/><br/>
Author Name : <input type="text" name="baname"><br/><br/>
Price : <input type="text" name="price"><br/><br/>
<input type="submit" value="ADD"><br/><br/>
<a href="Administrator.jsp">Sign Out</a>
</form>
</center>
</body>
</html>