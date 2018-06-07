package com.user.mng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mng.dao.UserDao;
import com.user.mng.dto.UserDto;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserDao userDao = new UserDao();
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
    
    {
    	try
    	{
    	Integer id = Integer.valueOf(request.getParameter("id"));
    	
    	UserDto userDto = userDao.findById(id);
    	
    	//keeping data into request
    	request.setAttribute("userDto", userDto);
    	
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
