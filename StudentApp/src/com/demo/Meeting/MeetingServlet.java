package com.demo.Meeting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MeetingServlet
 */
@WebServlet("/MeetingServlet")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	StudentMeetingDao studmeetDao = new StudentMeetingDao();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			String meeting_id = request.getParameter("meeting_id");
			String meeting_date = request.getParameter("meeting_date");
			String meeting_agenda = request.getParameter("meeting_agenda");
			String faculty_name = request.getParameter("faculty_name");
			String remarks = request.getParameter("remarks");
			
			System.out.println(meeting_id);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studapp","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into meeting (id,meeting_date,meeting_agenda,faculty_name,remarks) values(?,?,?,?,?)");
			ps.setString(1, meeting_id);
			ps.setString(2, meeting_date);
			ps.setString(3, meeting_agenda);
			ps.setString(4, faculty_name);
			ps.setString(5, remarks);
			
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				List<StudentMeetingDto> studmeetDtos = studmeetDao.findAll();
				
				request.setAttribute("studmeetDtos", studmeetDtos);
				
				request.getRequestDispatcher("contents.jsp").forward(request, response);
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
