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

#outer_frame
{
position:absolute;
top:170px;
left:100px;
}
#inner_frame
{
background-color:white;
padding:40px;
border-radius:13px;
box-shadow:10px 10px 10px lightblue;
}
pre
{
font-size:14px;
background-color:white;
border-style:hidden;
}
b{
font-size:18px;
font-family:Book Antiqua;
}
input[type=submit]
  {
    background-color: rgba(7,50,195,0.8);
      border: none;
      color: white;
      padding: 8px 30px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      border-radius: 20px;
  }
    input[type=submit]:hover
    {
      background-color: rgba(7,20,200,0.8);
    }
input[type=text]
{
border-style:hidden;
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
  <li><a href="login_controller" class="w3-bar-item w3-button">Home</a></li>
  <li><a href="edit_info" class="w3-bar-item w3-button">Change information</a></li>
  <li><a href="aptitude" class="w3-bar-item w3-button">Take Aptitude Test</a></li>
  <li class="active"><a href="#" class="w3-bar-item w3-button">search for jobs</a></li>
  <li><a href="redirect_cert" class="w3-bar-item w3-button">Edit Certification</a></li>
  <li><a href="redirect_experience" class="w3-bar-item w3-button">Edit Experience</a></li>
  <li><a href="viewAppointment" class="w3-bar-item w3-button">View Appointment</a></li>
  </div>

<div id="outer_frame">
<form action="apply_job">
<c:forEach items="${vacancy }" var="q">
	<div id="inner_frame">

	<pre><b>Designation </b>   ${q.position }                                               <b>Company</b>   ${q.company }                        <b>Deadline</b>    ${q.deadline }                           <input type="submit" value="Apply"/></pre>
	<pre><b>Salary </b>   ${q.salary }                                               <b>Email your resume at </b>  ${q.email }                                                      <b>Job id </b>  <input type="text" name="job_id" value="${q.job_id }" readonly/></pre>
	</div>
	<br />
	<br />
</c:forEach>
</form>
</div>

</body>
</html>