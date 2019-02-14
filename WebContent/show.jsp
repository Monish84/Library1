<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import="com.DatabaseConnection , java.sql.*"%>
</head>

<body bgcolor="yellow" text="red">

	<center>
		<h1>Books Description</h1>
	</center>

	<center><%
		Connection con;
		ResultSet rs;
	
		DatabaseConnection db = new DatabaseConnection();
		con = db.getConnection();
		String str3 = "select * from books";

		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(str3);
			
			//out.println("<html><body>");
			while (rs.next()) {
				out.println("The Book Name is : " + rs.getString("bname") + "<br>"+"<br>");
				//out.println("<input type = 'checkbox' value ='+rs.getString('bname')+'");
				
			}
			
			//out.println("</body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%></center>
	<center>
		<form action="view" method="post">
			Book Name : <input type="text" name="select"><br/><br/>
			<input type="submit" value="Buy"><br/><br/>
			<a href='Validation.jsp'>Sign Out</a>
		</form>
	</center>
</body>

</html>