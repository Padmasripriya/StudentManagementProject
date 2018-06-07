<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.demo.Meeting.*" %>
<%@ page import= "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%
    List<StudentMeetingDto> studmeetDtos = (List<StudentMeetingDto>)request.getAttribute("studmeetDtos");
 %>

<form method = "get">
<h3>Select Meeting Id from the below Drop down list</h3>
     <table class = "table table-bordered">
     <thead>
     <tr>
     <th>Meeting Id</th>
     <th>Search</th>
     </tr>
     </thead>
      <tbody>
      <%
         for(StudentMeetingDto studmeetDto: studmeetDtos)
         {
      %>
      <tr>
      <td><%= studmeetDto.getId() %></td>
      <td>
       <button type="submit" class="btn btn-default" aria-label="center Align">
       <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
       </button>
       </td>
      </tr>
      <%
      }
      %>
      </tbody>
    
  </table>
  </div>
</form>
</body>
</html>