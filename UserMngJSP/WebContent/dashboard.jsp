<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List" %>
<%@ page import= "com.user.mng.dto.UserDto" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style type = "text/css">
body
{
     padding: 25px;
}
</style>
</head>
<body>

 <%--<%
    List<UserDto> userDtos = (List<UserDto>)request.getAttribute("userDtos");
 %>--%>
 
 <div class="panel panel-primary">
  <div class="panel-heading">User Entry</div>
  <div class="panel-body">
  
  <form action="processUser.htm" method = "post">
  
  <input type="hidden" id = "id" name = "id" value = "${requestScope.userDto.id}">
  
  <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" class="form-control" id="name" name = "name" value = "${requestScope.userDto.name}">
  </div>
  <div class="form-group">
    <label for="location">Location:</label>
    <input type="text" class="form-control" id="location" name = "location" value = "${requestScope.userDto.location}">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>
  
  </div>
  </div>
 

<div class="panel panel-primary">
  <div class="panel-heading">User Details</div>
  <div class="panel-body">
  
  <table class = "table table-bordered">
     <thead>
        <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Location</th>
           <th>Action</th>
        </tr>
     </thead>
     
     <tbody>
     <%-- 
        <%
           for(UserDto userDto: userDtos)
           {
        %>
        <tr>
           <td><%= userDto.getId() %></td>
           <td><%= userDto.getName() %></td>
           <td><%= userDto.getLocation() %></td>
        </tr>
        <%
        }
        %>--%>
        
       <c:forEach items="${requestScope.userDtos}" var="row">
        <tr>
           <td><c:out value="${row.id}"></c:out></td>
           <td><c:out value="${row.name}"></c:out></td>
           <td>${row.location}</td>
           <td><a href="editUser.htm?id=${row.id}">Edit</a> / <a href="deleteUser.htm?id=${row.id}">Delete</a></td>
        </tr>
        </c:forEach>  
     </tbody>
  </table>
</div>
</div>



</body>
</html>