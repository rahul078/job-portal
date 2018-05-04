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
table th
{
min-width:400px;
}
table td
{
padding-left:40px;
padding-bottom:10px;
font-size:16px;
min-width:100px;
}
#make_bold
{
font-weight:bold;
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

<div class="nav nav-tabs" id="info_bar">
  <li class="active"><a href="#" class="w3-bar-item w3-button">Home</a></li>
  <li><a href="edit_info" class="w3-bar-item w3-button">Change information</a></li>
  <li><a href="aptitude" class="w3-bar-item w3-button">Take Aptitude Test</a></li>
  <li><a href="search_job" class="w3-bar-item w3-button">search for jobs</a></li>
  <li><a href="redirect_cert" class="w3-bar-item w3-button">Edit Certification</a></li>
  <li><a href="redirect_experience" class="w3-bar-item w3-button">Edit Experience</a></li>
  <li><a href="viewAppointment" class="w3-bar-item w3-button">View Appointment</a></li>
</div>
<h2>${requestScope.msg }</h2>

<div id="home">
<h2 style="color:red;">${msg }</h2>
	<center><h2>Basic Information</h2></center>
	<br /><br />
	<div id="home_items">
	<table>
	<tr>
	<td><b>First Name  </b></td>
	<td>:</td>
	<td> ${sessionScope.user.fname }</td>
	<th></th>
	<th></th>
	<td><b>Last Name  </b></td>
	<td>:</td>
	<td> ${sessionScope.user.lname }</td>
	</tr>
	<tr>
	<td><b>City </b> </td>
	<td>:</td>
	<td> ${sessionScope.user.city }</td>
	<th></th>
	<th></th>
	<td><b>State  </b></td>
	<td>:</td>
	<td> ${sessionScope.user.state }</td>
	</tr>
	<tr>
	<td><b>Educational Qualification </b> </td>
	<td>:</td>
	<td> ${sessionScope.user.edu_qualification }</td>
	<th></th>
	<th></th>
	<td><b>Date of Birth </b></td>
	<td>:</td>
	<td> ${sessionScope.user.dob }</td>
	</tr>
	<tr>
	<td><b>Phone Number </b> </td>
	<td>:</td>
	<td> ${sessionScope.user.phone_number }</td>
	<th></th>
	<th></th>
	<td><b>email</b></td>
	<td>:</td>
	<td> ${sessionScope.user.email }</td>
	</tr>
	</table>
	</div>
	<br /><br />
	
	<center><h2>Work Experience</h2></center>
	<br /><br />
	<table>
		<tr>
			<td></td><td></td>
			<td id="make_bold"> From Year</td>
			<td></td><td></td>
			<td id="make_bold">To Year</td>
			<td></td><td></td>
			<td id="make_bold">Job Description</td>
		</tr>
		<c:forEach items="${sessionScope.experience}" var="item">
    		
    			
    		<tr>
				<td></td><td></td>
				<td>${item.from_year }</td>
				<td></td><td></td>
				<td>${item.to_year}</td>
				<td></td><td></td>
				<td>${item.description }</td>
			</tr>
		</c:forEach>
	</table>

	<br /><br />
	<center><h2>Certificates</h2></center>
	
	<br /><br />
	<table>
		<tr>
			<td></td><td></td>
			<td id="make_bold"> Certificate Number</td>
			<td></td><td></td>
			<td id="make_bold">Year</td>
			<td></td><td></td>
			<td id="make_bold">Description</td>
	</tr>
		<c:forEach items="${sessionScope.certificates}" var="item">
    		
    			
    		<tr>
				<td></td><td></td>
				<td> ${item.c_no }</td>
				<td></td><td></td>
				<td>${item.year}</td>
				<td></td><td></td>
				<td>${item.description }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	




</body>
</html>