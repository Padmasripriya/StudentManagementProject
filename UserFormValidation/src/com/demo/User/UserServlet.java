package com.demo.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   
	   try
	   {
		   String name = request.getParameter("name");
		   String address = request.getParameter("address");
		   String phoneNo = request.getParameter("phone_no");
		   String email  = request.getParameter("email");
		   String password = request.getParameter("pwd");
		   String gender = request.getParameter("gender");
		   
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		   
		   PreparedStatement ps = con.prepareStatement("insert into user (name,address,phoneNo,email,password,gender) values (?,?,?,?,?,?)");
		   ps.setString(1, name);
		   ps.setString(2, address);
		   ps.setString(3, phoneNo);
		   ps.setString(4, email);
		   ps.setString(5, password);
		   ps.setString(6, gender);
		   
		   int i = ps.executeUpdate();
		   
		   if(i!=0)
		   {
			   response.sendRedirect("success.html");
		   }
		   else
		   {
			   response.sendRedirect("failure.html");
		   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }

}
