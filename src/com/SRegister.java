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

public class SRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pr;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Sname = request.getParameter("Sname");
		String Sid = request.getParameter("Sid");
		String Sdep = request.getParameter("Sdep");
		String Spassword = request.getParameter("Spassword");
		
		PrintWriter out = response.getWriter();
		
		try{
			con = new DatabaseConnection().getConnection();
			String str1 = "insert into student values(?,?,?,?)";
			pr = con.prepareStatement(str1);
			pr.setString(1, Sname);
			pr.setString(2, Sid);
			pr.setString(3, Sdep);
			pr.setString(4, Spassword);
			
	
			int a = pr.executeUpdate();
			if(a>0){
				out.println("Value is Inserted....");
				RequestDispatcher rd=request.getRequestDispatcher("Student.jsp");
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
