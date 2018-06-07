<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.Date" %>
<%@ page import= "java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! 
int var = 90;

void callMe()
{
	
}

%>

<%
   System.out.println(new Date());
   String value1 = request.getParameter("param1");
   String value2 = request.getParameter("param2");
   
   out.println(value1);
%>
</body>
</html>