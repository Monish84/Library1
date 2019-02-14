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



public class ARegister extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pr;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Aname = request.getParameter("Aname");
		String Aid = request.getParameter("Aid");
		String Adesc = request.getParameter("Adesc");
		String Apassword = request.getParameter("Apassword");
		
		PrintWriter out = response.getWriter();
		try{
			con = new DatabaseConnection().getConnection();
			String str = "insert into admin values(?,?,?,?)";
			pr = con.prepareStatement(str);
			pr.setString(1, Aname);
			pr.setString(2, Adesc);
			pr.setString(3, Aid);
			pr.setString(4, Apassword);
	
			int a = pr.executeUpdate();
			if(a>0){
				out.println("Value is Inserted....");
				RequestDispatcher rd=request.getRequestDispatcher("Administrator.jsp");
				rd.include(request, response);
			}else{
				out.println("Value is not inserted...");
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
