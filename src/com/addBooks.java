package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class addBooks extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pr;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bname = request.getParameter("bname");
		String baname = request.getParameter("baname");
		String price = request.getParameter("price");
			
		PrintWriter out = response.getWriter();
		
		try{
			con = new DatabaseConnection().getConnection();
			String str = "insert into books values(?,?,?)";
			pr = con.prepareStatement(str);
			pr.setString(1, bname);
			pr.setString(2, baname);
			pr.setString(3, price);
			
	
			int a = pr.executeUpdate();
			if(a>0){
				out.println("Book is Added....");
	
				RequestDispatcher rd=request.getRequestDispatcher("books.jsp");
				rd.include(request, response);
				
			}else{
				out.println("Book is not Added....");
				RequestDispatcher rd=request.getRequestDispatcher("books.jsp");
				rd.include(request, response);
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