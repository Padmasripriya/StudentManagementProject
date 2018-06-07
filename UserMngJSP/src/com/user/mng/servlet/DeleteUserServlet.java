package com.user.mng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mng.dao.UserDao;
import com.user.mng.dto.UserDto;

public class DeleteUserServlet extends HttpServlet{
	
	UserDao userDao = new UserDao();
	
	protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		try
		{
		Integer id = Integer.valueOf(request.getParameter("id"));//returns non-primitive data
		
		userDao.deleteUserById(id);
		
		//to refresh the page
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
