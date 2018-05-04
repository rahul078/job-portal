<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.src.model.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--Below 3 lines contains Bootstrap cdn -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Below line is used to link external stylesheet to html page-->
  <link rel="stylesheet" href="stylesheet/styling.css">
<title>Aptitude Trainer</title>
<style>
#question-border
{
align:center;
	width:800px;
	border:1px solid black;
	border-radius:20px;

	box-shadow: 0px 0px 5px rgba(66,66,66,.75);
}
#layout
{
position:absolute;
top:100px;
left:15%;
width:70%;
}
#button_style
{
color:black;
background-color:lightgray;
align:center;
padding-left:27%;
padding-right:22%;
padding-top:5%;
padding-bottom:4.5%;
border:0px;
font-weight:bold;
}
#button_style:hover
{
color:blue;
}
#choice
{
padding-left:30px;
}

</style>
</head>
<body>
 <!-- Code using Bootstrap for navigation bar -->
  <nav class="navbar navbar-default" id="navigation">
	<img id="logo" src="images/logo_4.png" />
	<ul class="nav navbar-nav navbar-right">
    <li><a href="homepage.jsp"><center>Homepage</center></a></li>
    <li id="current"><input type="submit" value=submit id="button_style" form="form_1"/></li>
	  <li><div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="login_button">Login
    <span class="caret"></span></button>
    <ul class="dropdown-menu" id="dropdown-menu">
      <li><a href="login.jsp">User Login</a></li>
      <li><a href="hr_login.jsp">HR Login</a></li>
      <li><a href="admin_login.jsp">Admin Login</a></li>
    </ul>
  </div>
</div></li>
	  <li><a href="contact_us.html"><center>Contact us</center></a></li>

	</ul>
</nav>

<!--End of navigation bar Code -->

<div id="layout">
<form action="free_trial" method="post" id="form_1">


<c:forEach items="${sessionScope.question }" var="q">
		<br />
		
	<div id="question-border">
	
	<center><h3>${q.question}</h3></center>
	<div id="choice" align="left" >
	<input type="radio" value="1" name="${q.question}" required>${q.choice_1 }</input><br/>
	<input type="radio" value="2" name="${q.question}" >${q.choice_2 }</input><br/>
	<input type="radio" value="3" name="${q.question}" >${q.choice_3 }</input><br/>
	<input type="radio" value="4" name="${q.question}" >${q.choice_4 }</input><br/>
	
	</div>
	
	</div>

	</c:forEach>
	
	
</form>
<br />
<br />
<br />
<br />
</div>

</body>
</html>