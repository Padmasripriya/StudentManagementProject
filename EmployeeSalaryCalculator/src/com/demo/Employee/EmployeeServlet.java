package com.demo.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet
{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			String pay_rate = request.getParameter("pay_rate");
			String hours_worked = request.getParameter("hours_worked");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into employee (pay_rate,hours_worked) values(?,?)");
			ps.setString(1, pay_rate);
			ps.setString(2,hours_worked);
			
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				response.sendRedirect("success.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

