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
      <li id="current"><a href="hr_login.jsp">HR Login</a></li>
      <li><a href="admin_login.jsp">Admin Login</a></li>
    </ul>
  </div>
</div></li>
    <li><a href="contact_us.html"><center>Contact us</center></a></li>

  </ul>
</nav>

<!--End of navigation bar Code -->

<!-- Below code to view and asynchronously load logib and registration forms -->

<p id="hr_code">
${errors["email"] }
<br />
${errors["password"] }
</p>
  <div class="page">
  <div class="form">

    <form class="Login" method="post" action="hr_login_controller">
<p id="error_code">${error}</p>
    <img class="avatar" src="images/hr_image.jpg" alt="Image not found">
      <br />
      <br/>
      <input type="text" placeholder="Enter Email" name="email" required>
      <input type="password" placeholder="Enter Password" name="password" required>
      <input type="submit" value="submit">
      <p class="message">If not registered <a href="#">Click here</a></p>
    </form>


    <form class="register" method="post" action="hr_register_controller">
      <input type="text" placeholder="Enter Email " name="email" value="${details['email'] }" required>
      <input type="text" placeholder="Enter name " name="name" value="${details['name'] }" id="name" required>
      <input type="text" placeholder="Enter Company " name="company" value="${details['company'] }" id="dob" required>
      <input type="number" placeholder="Enter Phone Number " name="phone_number" value="${details['phone_number'] }" id="phone" required>
      <input type="text" placeholder="Enter comapny address" name="c_address" value="${details['c_address'] }" required>
      <input type="password" placeholder="Enter Password" name="password" required>
      <input type="password" placeholder="Confirm Password" name="cpassword" required>
      <input type="submit" value="submit">
      <p class="message">If Already Registered <a href="#">Click here</a></p>
    </form>
  </div>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
  <script type="text/javascript">
    $('p a').click(function(){
    $('form').animate({height: "toggle" ,opacity: "toggle"}, "slow");
  });
  </script>
  <!-- End of forms code -->
  
  <div id="result">
  	<h4> ${correct }</h4>
  
  </div>
</body>
</html>