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
<!-- Code using Bootstrap for navigation bar -->

</head>
<body>

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
  			<li class="active"><a href="#" class="w3-bar-item w3-button">Edit Certification</a></li>
  			<li><a href="redirect_experience" class="w3-bar-item w3-button">Edit Experience</a></li>
  			<li><a href="viewAppointment" class="w3-bar-item w3-button">View Appointment</a></li>
		</div>
<div class="page">
<div class="form">


	<form action="addCertificate" method="post">
		<h3><center>Add Certificate</center></h3>
			<input type="text" name="c_no" placeholder="Enter Certificate Number" required/>
			<input type="number" name="year" placeholder="Enter Year of Certification" required/>
			<input type="text" name="description" placeholder="Enter Description about the certificate" maxlength="50" required/>
			<input type="submit" value="submit" />
	</form>
	<h3><center>Remove Certification</center></h3>
<form action="addCertificate" method="get">

<center>
  <select name="certificate" class="select_box">
   		<c:forEach items="${sessionScope.certificates}" var="item">
    		<option value="${item.c_no }">${item.description }</option>
			
    	</c:forEach>
   </select>

</center>
  <input type="submit" value=submit />
</form>

   
 
</div>
</div>
</body>
</html>