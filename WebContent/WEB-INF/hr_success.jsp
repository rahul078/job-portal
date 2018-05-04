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
		<link rel="stylesheet" href="stylesheet/styling1.css">

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
  <li class="active"><a href="#">Edit Job Vacancies</a></li>
  <li><a href="hr_get_application">View Applications</a></li>
  
</ul>
</div>
<div class="page">
<div class="form">


	<form action="vacancy_controller" method="post">
		<h3><center>Add Vacancy</center></h3>
			<input type="text" name="position" placeholder="Enter Job Designation" required/>
			<input type="text" name="min_qualification" placeholder="Enter Minimum Qualification" required/>
			<b>Enter deadline time</b><input type="date" name="deadline" placeholder="Enter Deadline time" required/>
			<input type="text" name="salary" placeholder="Enter annual package offer" required/>
			<input type="submit" value="submit" />
	</form>
	<h3><center>Remove Vacancy</center></h3>
	<form action="vacancy_controller" method="get">
	<center>
		<select class="select_box" name="vacancy">
   		<c:forEach items="${sessionScope.vacancy}" var="item">
    		<option value="${item.job_id }">${item.position }
			</option>
    	</c:forEach>
  </select>
  </center>
  <br />
  <input type="submit" value=submit />
	</form>

</div>
</div>

</body>
</html>