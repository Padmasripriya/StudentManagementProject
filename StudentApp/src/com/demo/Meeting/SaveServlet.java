package com.demo.Meeting;

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
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String meeting_agenda = request.getParameter("meeting_agenda");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studapp","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into stud_meeting (id,name,meeting_agenda) values (?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, meeting_agenda);
	
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				response.sendRedirect("success.html");
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
