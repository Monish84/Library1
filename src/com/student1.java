package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class student1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Sname = request.getParameter("Sname");
		String Spassword = request.getParameter("Spassword");
		
		PrintWriter out=response.getWriter();
		DatabaseConnection db=new DatabaseConnection();
		Connection con = db.getConnection();
		
		String str1 = "select * from student where sname='"+Sname+"' and spassword='"+Spassword+"'";
		
		String name;
		String pass;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(str1);
			while(rs.next()){
				
				name = rs.getString("sname");
				pass = rs.getString("spassword");
				
				if(name.equals(Sname)&&pass.equals(Spassword)){
					out.println("<center><h3>Login Successfully....<h3><center>");	
					out.println("<h1>Welcome Mr."+rs.getString("sname")+"<br><h1>");
					out.println("<center><a href='show.jsp'>Want to Buy books ?</a><center><br/>");
					out.println("<center><a href='Student.jsp'>Sign Out</a><center>");
			   }
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}	
	}

	}


