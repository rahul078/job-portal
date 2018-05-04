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
#layout
{
position:absolute;
top:100px;
left:200px;
width:70%;
}
#hr_data
{
background-color:white;
border:5px solid lightgray;

}
</style>

</head>
<body>
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
  <li><a href="admin_login_controller">Verify Hr</a></li>
  <li class="active"><a href="#">Verify Job</a></li>
</ul>
</div>


<div id="layout">
<c:forEach items="${jobs }" var="q">
<br />
<br />
<form action="admin_validate_jobs" method="post">
<div id="hr_data">
<p><pre>Designation : <b>${q.position }</b>                     Company : <b>${q.company }</b>            phone Number : <b>${q.phone_number }</b></pre></p>
<br />
<p><pre>Job id :<input type="text" name="job_id" value="${q.job_id }" readonly />                             <input type="submit" value="Validate" /></pre></p>
</div>
</form>
</c:forEach>
</div>
</body>
</html>