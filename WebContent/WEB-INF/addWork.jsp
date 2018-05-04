<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <%@ page import="com.src.model.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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

<div class="nav nav-tabs" id="info_bar">
  <li><a href="login_controller" class="w3-bar-item w3-button">Home</a></li>
  <li><a href="edit_info" class="w3-bar-item w3-button">Change information</a></li>
  <li><a href="aptitude" class="w3-bar-item w3-button">Take Aptitude Test</a></li>
  <li><a href="search_job" class="w3-bar-item w3-button">search for jobs</a></li>
  <li><a href="redirect_cert" class="w3-bar-item w3-button">Edit Certification</a></li>
  <li class="active"><a href="#" class="w3-bar-item w3-button">Edit Experience</a></li>
  <li><a href="viewAppointment" class="w3-bar-item w3-button">View Appointment</a></li>
</div>

<div class="page">
<div class="form">


	<form action="addWork" method="post">
		<h3><center>Add Work Experience</center></h3>
			<input type="number" name="from_year" placeholder="Enter Starting year of the job" required/>
			<input type="number" name="to_year" placeholder="Enter Resignation year of the job" required/>
			<input type="text" name="description" placeholder="Enter Description about the Job" maxlength="50" required/>
			<input type="submit" value="submit" />
	</form>
	<h3><center>Remove Work Experience</center></h3>
	<form action="addWork" method="get">
	<center>
		<select name="work" class="select_box">
   		<c:forEach items="${sessionScope.experience}" var="item">
    		<option value="${item.description }">${item.description } [${item.from_year } - ${item.to_year }]
			</option>
    	</c:forEach>
  </select>
  <br />
  </center>
  <input type="submit" value=submit />
	</form>

</div>
</div>

</body>
</html>