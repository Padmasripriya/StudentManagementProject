package com.user.mng.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mng.dao.UserDao;
import com.user.mng.dto.UserDto;

/**
 * Servlet implementation class ProcessUserServlet
 */
@WebServlet("/ProcessUserServlet")
public class ProcessUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	UserDao userDao = new UserDao();
	
	//doPost handles post request
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		try
		{
			
			String id = request.getParameter("id");
			
			if(id == null || id.isEmpty())
			{
				String name = request.getParameter("name");
				String location = request.getParameter("location");
				
				UserDto userDto = new UserDto();
			    userDto.setName(name);
			    userDto.setLocation(location);
			
			
				userDao.insertUser(userDto);
			}
			else
			{
				String name = request.getParameter("name");
				String location = request.getParameter("location");
				
				UserDto userDto = new UserDto();
				userDto.setId(Integer.valueOf(id));
			    userDto.setName(name);
			    userDto.setLocation(location);
			
			
				userDao.updateUser(userDto);
			}
			
			List<UserDto> userDtos = userDao.findAll();
			request.setAttribute("userDtos", userDtos);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
