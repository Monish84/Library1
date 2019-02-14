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

public class view1 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	ResultSet rs;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("select");
		
		PrintWriter out=response.getWriter();
		DatabaseConnection db = new DatabaseConnection();
		con = db.getConnection();
		String str2 = "select * from books where bname='"+name+"'";
	
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(str2);
		
			while(rs.next()){
				out.println("The Book Name is : "+rs.getString("bname")+"<br>");
				out.println("The Author name is : "+rs.getString("bauthor")+"<br>");
				out.println("Price of the Book : "+rs.getString("bprice")+"<br>");
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
