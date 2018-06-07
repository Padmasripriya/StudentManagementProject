package com.demo.Student;

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
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneNo = request.getParameter("phone_no");
			String email = request.getParameter("email");
			String password = request.getParameter("pwd");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studapp","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into student (id,name,address,phoneNo,email,password) values (?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, phoneNo);
			ps.setString(5, email);
			ps.setString(6, password);
			
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				response.sendRedirect("meeting_info.html");
			}
			
			else
			{
				response.sendRedirect("failureStudent.html");
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
