package Form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveFormData
 */
@WebServlet("/SaveFormData")
public class SaveFormData extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		response.setContentType("text/html");
		
		try
		{
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String familyName = request.getParameter("familyname");
			String relationship = request.getParameter("relationship");
			String dob = request.getParameter("dob");
			String payrate = request.getParameter("payrate");
			String hoursworked = request.getParameter("hoursworked");
			String grosssalary = request.getParameter("grosssalary");
			String houseloan = request.getParameter("houseloan");
			String carloan = request.getParameter("carloan");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into employeeform (name,phone,address,familyname,relationship,dob,payrate,hoursworked,grosssalary,houseloan,carloan) values (?,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.setString(4, familyName);
			ps.setString(5, relationship);
			ps.setString(6, dob);
			ps.setString(7, payrate);
			ps.setString(8, hoursworked);
			ps.setString(9, grosssalary);
			ps.setString(10, houseloan);
			ps.setString(11, carloan);
			
			
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				response.sendRedirect("Success.html");
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
