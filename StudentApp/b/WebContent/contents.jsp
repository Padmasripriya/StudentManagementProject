<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.demo.Meeting.StudentMeetingDto" %>
<%@ page import= "com.demo.Meeting.StudentMeetingDao" %>
<%@ page import= "java.util.*" %>

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
<h1 align = "center">Student Information</h1>
<div align = "right">
   <a href = "logoutUser.htm">Logout</a>
</div>


<div class="panel panel-primary">
  <div class="panel-heading">Student Details</div>
  <div class="panel-body"></div>
  
  <table class = "table table-bordered">
     <thead>
        <tr>
           <th>Meeting Id</th>
           <th>Name</th>
           <th>Meeting Agenda</th>
           <th>Select the below check boxes</th>
           <th>Action</th>
           
        </tr>
     </thead>
     
      <tbody>
      
     <c:forEach items="${requestScope.studmeetDtos}" var="row" varStatus = "status">
        <tr>
           <td>${row.id}</td>
           <td>${row.name}</td>
           <td>${row.meeting_agenda}</td>
            <td>
           <c:forEach var="i" begin="1" end="2">
              <label>
              <input type="checkbox" value="meeting"<c:out value="${i}"/> />
              M<c:out value="${i}"/>
              </label>
           </c:forEach>
           </td>
           <td>
           <form method="post" action="saveInfo.htm">
              <input type="hidden" value="${row.id}" name="id" />
              <input type="hidden" value="${row.name}" name="name" />
              <input type="hidden" value="${row.meeting_agenda}" name="meeting_agenda" />
              <input type="submit" value="Save" name="save" />
           </form>
           </td>
        </tr>
        </c:forEach> 
        
      </tbody>
    
  </table>
 </div>

</body>
</html>