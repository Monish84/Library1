package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Aname = request.getParameter("Aname");
		String Apassword = request.getParameter("Apassword");
		
		PrintWriter out=response.getWriter();
		
				if(Aname.equals("Monish")&&Apassword.equals("12345")){
					out.println("<center><h3>Login Successfully....<h3><center>");	
					out.println("<h1>Welcome Mr . "+Aname+"<br><h1>");
					out.println("<center><a href='books.jsp'>Want to add books ?</a><center><br/>");
					out.println("<center><a href='show.jsp'>Want to Buy books ?</a><center><br/>");
					out.println("<center><a href='Administrator.jsp'>Sign Out</a><center>");
				}else{
				out.println("<center><h1>Sorry You are not an authorised User<h1></center>");
				RequestDispatcher rd=request.getRequestDispatcher("/Administrator.jsp");
				rd.include(request, response);
				}
	}
}