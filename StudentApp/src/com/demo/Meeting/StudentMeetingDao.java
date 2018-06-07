package com.demo.Meeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentMeetingDao 
{
	
	public List<StudentMeetingDto> findAll() throws SQLException, ClassNotFoundException
	{
		 Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studapp","root","root");
			try
			{
				PreparedStatement statement = con.prepareStatement("select * from student,meeting where student.id = meeting.id order by meeting.id asc");
				
				ResultSet rs = statement.executeQuery();
				
				List<StudentMeetingDto> dtoList = new ArrayList<StudentMeetingDto>();
				
				while(rs.next())
				{
					StudentMeetingDto studmeetDto = new StudentMeetingDto();
					studmeetDto.setId(rs.getString("id"));
					studmeetDto.setName(rs.getString("name"));
					studmeetDto.setAddress(rs.getString("address"));
					studmeetDto.setEmail(rs.getString("email"));
					studmeetDto.setPassword(rs.getString("password"));
					studmeetDto.setMeeting_date(rs.getString("meeting_date"));
					studmeetDto.setMeeting_agenda(rs.getString("meeting_agenda"));
					studmeetDto.setFaculty_name(rs.getString("faculty_name"));
					studmeetDto.setRemarks(rs.getString("remarks"));
					
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

}
