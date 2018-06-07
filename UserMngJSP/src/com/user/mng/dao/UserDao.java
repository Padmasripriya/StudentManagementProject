package com.user.mng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.mng.dto.UserDto;

public class UserDao {
	
	public UserDto findByUsernameAndPassword(String username,String password) throws SQLException, ClassNotFoundException
	{
	    Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		try
		{
			PreparedStatement statement = con.prepareStatement("select * from login where username = ? and password  =?");
			statement.setString(1, username);
			statement.setString(2, password);
			
			List<UserDto> list = new ArrayList<UserDto>();
			
			ResultSet rs = statement.executeQuery();
			
			UserDto userDto = null;
			
			while(rs.next())
			{
				userDto = new UserDto();
				userDto.setId(rs.getInt("id"));
				userDto.setUsername(rs.getString("username"));
				userDto.setPassword(rs.getString("password"));
				
				list.add(userDto);
			}
			
			return userDto;
		}
		catch(Exception e)
		{
			return null;
		}
		
		finally
		{
			con.close();
		}
	}

	public List<UserDto> findAll() throws SQLException, ClassNotFoundException
	{
	    Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		try
		{
			PreparedStatement statement = con.prepareStatement("select * from faculty");
			
			ResultSet rs = statement.executeQuery();
			
			List<UserDto> dtoList = new ArrayList<UserDto>();
			
			while(rs.next())
			{
				UserDto studmeetDto = new UserDto();
				studmeetDto.setId(rs.getInt("id"));
				studmeetDto.setName(rs.getString("name"));
				studmeetDto.setLocation(rs.getString("location"));
				
				dtoList.add(studmeetDto);
			}
			
			return dtoList;
		}
		catch(Exception e)
		{
			return null;
		}
		
		finally
		{
			con.close();
		}
	}

	public void deleteUserById(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		try
		{
			PreparedStatement statement = con.prepareStatement("delete from faculty where id = ?");
			statement.setInt(1, id);
			
			statement.executeUpdate();
	
		}
		catch(Exception e)
		{
			throw e;
		}
		
		finally
		{
			con.close();
		}
		
	}

	public void insertUser(UserDto userDto) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		try
		{
			PreparedStatement statement = con.prepareStatement("insert into faculty(name,location) values(?,?)");
			statement.setString(1, userDto.getName());
			statement.setString(2, userDto.getLocation());
			
			statement.executeUpdate();
	
		}
		catch(Exception e)
		{
			throw e;
		}
		
		finally
		{
			con.close();
		}
		
	}

	public UserDto findById(Integer id)throws Exception {
		
		 Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			try
			{
				PreparedStatement statement = con.prepareStatement("select * from faculty where id = ?");
				statement.setInt(1, id);
				
				List<UserDto> list = new ArrayList<UserDto>();
				
				ResultSet rs = statement.executeQuery();
				
				UserDto userDto = null;
				
				while(rs.next())
				{
					userDto = new UserDto();
					userDto.setId(rs.getInt("id"));
					userDto.setName(rs.getString("name"));
					userDto.setLocation(rs.getString("location"));
					
					list.add(userDto);
				}
				
				return userDto;
			}
			catch(Exception e)
			{
				return null;
			}
			
			finally
			{
				con.close();
			}
	}

	public void updateUser(UserDto userDto)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		try
		{
			PreparedStatement statement = con.prepareStatement("update faculty set name=?,location=? where id=?");
			statement.setString(1, userDto.getName());
			statement.setString(2, userDto.getLocation());
			statement.setInt(3, userDto.getId());
			
			statement.executeUpdate();
	
		}
		catch(Exception e)
		{
			throw e;
		}
		
		finally
		{
			con.close();
		}
		
	}
		
		

}
