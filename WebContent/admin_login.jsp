<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <!--Below 3 lines contains Bootstrap cdn -->
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- Below line is used to link external stylesheet to html page-->
       <link rel="stylesheet" href="stylesheet/styling.css">
  <title>Login page</title>

<style>
#result
{
	position:absolute;
	top:90px;
	left:30px;
}
</style>
</head>
<body>
  <!-- Code using Bootstrap for navigation bar -->
  <nav class="navbar navbar-default" id="navigation">
  <img id="logo" src="images/logo_4.png" />
  <ul class="nav navbar-nav navbar-right">
    <li><a href="homepage.jsp"><center>Homepage</center></a></li>
    <li><a href="free_trial"><center>Free Trial</center></a></li>
    
    
    <li><div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="login_button">Login
    <span class="caret"></span></button>
    <ul class="dropdown-menu" id="dropdown-menu">
      <li><a href="login.jsp">User Login</a></li>
      <li><a href="hr_login.jsp">HR Login</a></li>
      <li id="current"><a href="admin_login.jsp">Admin Login</a></li>
    </ul>
  </div>
</div></li>
    <li><a href="contact_us.html"><center>Contact us</center></a></li>

  </ul>
</nav>

<div class="page">
  <div class="form">
    <form class="Login" method="post" action="admin_login_controller">
<p id="error_code">${error}</p>
    <img class="avatar" src="images/restricted.png" alt="Image not found">
      <br />
      <br/>
      <input type="text" placeholder="ENTER ADMIN ID" name="id" required>
      <input type="password" placeholder="Enter Password" name="password" required>
      <input type="submit" value="submit">
    </form>
    </div>
    </div>

</body>
</html>