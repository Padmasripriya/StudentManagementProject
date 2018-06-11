package com.demo.jquerydemo;

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
 * Servlet implementation class SaveDataServlet
 */
@WebServlet("/SaveDataServlet")
public class SaveDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			String country = request.getParameter("country");
			String city = request.getParameter("city");
			String zip = request.getParameter("zip");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into info (country,city,zip) values(?,?,?)");
			ps.setString(1, country);
			ps.setString(2,city);
			ps.setString(3,zip);
			
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
