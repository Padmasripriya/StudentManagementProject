package com.user.mng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mng.dao.UserDao;
import com.user.mng.dto.UserDto;

public class LoginServlet extends HttpServlet
{
	UserDao userDao = new UserDao();
	protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		try
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDto userDto = userDao.findByUsernameAndPassword(username, password);
			
			if(userDto!=null)
			{
				List<UserDto> userDtos = userDao.findAll();
				
				request.setAttribute("userDtos", userDtos);
				
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				//System.out.println("Correct!");
				//response.sendRedirect("dashboard.jsp");
			}
			else
			{
				response.sendRedirect("page.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
