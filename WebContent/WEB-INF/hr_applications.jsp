<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.src.model.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="com.src.model.*" %>
    <%@ page import="java.util.*" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Aptitude Trainer</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--Below 3 lines contains Bootstrap cdn -->
     	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     
	<!-- Below line is used to link external stylesheet to html page-->
 		 <link rel="stylesheet" href="stylesheet/styling.css">

	
	<style>
		#outer
		{
position:absolute;
top:200px;
left:200px;
width:50%;
}
#inner
{

background-color:white;
border:5px solid lightgray;
margin:20px;

}
	</style>
	<script type="text/javascript">
function load()
{
setTimeout("window.location='hr_get_application';", 5000);
}
</script>
</head>
<body onload="load()">

<!-- Code using Bootstrap for navigation bar -->
	<nav class="navbar navbar-default" id="navigation">
		<img id="logo" src="images/logo_4.png" />
		<ul class="nav navbar-nav navbar-right">
		<li><a href="logoutcontroller"><center>Logout</center></a></li>

		</ul>
	</nav>
	<!--End of navigation bar Code -->
	<div id="info_bar">
<ul class="nav nav-tabs">
  <li><a href="hr_login_controller">Edit Job Vacancies</a></li>
  <li class="active"><a href="#">View Applications</a></li>
  
</ul>
</div>
<div id="outer">

 <c:forEach items="${sessionScope.app }" var="a" >
 <form method="post" action="hr_view_user" target="_blank" onsubmit="self">
 <div id="inner">
<pre style="font-family:times-new-roman;font-size:15px; " > Email : <input type="text" value="${a.email }" name="email" readonly/>                                                                                                     Job Position : ${a.job_position }</pre>



<pre>Applied date : ${a.date }             <input type="text" value="${a.app_id }" name="app_id" readonly/>                                                          <input type="submit" value="view applicant" /></pre> 
 </div>
 </form>
 </c:forEach>
 </div>
</body>
</html>