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

<script type="text/javascript">
function validateForm() {
    var x = document.forms["myForm"]["password"].value;
    var y = document.forms["myForm"]["confirmpassword"].value;
    if (x != y) {
        alert("Wrong Password");
        return false;
    }
}

</script>
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
  <li class="active"><a href="#" class="w3-bar-item w3-button">Change information</a></li>
  <li><a href="aptitude" class="w3-bar-item w3-button">Take Aptitude Test</a></li>
  <li><a href="search_job" class="w3-bar-item w3-button">search for jobs</a></li>
  <li><a href="redirect_cert" class="w3-bar-item w3-button">Edit Certification</a></li>
  <li><a href="redirect_experience" class="w3-bar-item w3-button">Edit Experience</a></li>
  <li><a href="viewAppointment" class="w3-bar-item w3-button">View Appointment</a></li>
  </div>


  <div id="home">
  <center><h2>Edit Information</h2></center>
  <br /><br />
    <div id="home_items">
    <form action="edit_info" method="post" name="myForm" onsubmit="return validateForm()">


  <table>
  <tr>
  <td><b>First Name  </b></td>
  <td>:</td>
  <td><input type="text" value=" ${sessionScope.user.fname }" name="fname" required></td>
  <th></th>

  <td><b>Last Name  </b></td>
  <td>:</td>
  <td><input type="text" value="${sessionScope.user.lname }" name="lname" required> </td>
  </tr>
  <tr>
  <td><b>City </b> </td>
  <td>:</td>
  <td><input type="text" value=" ${sessionScope.user.city }" name="city" required></td>
  <th></th>

  <td><b>State  </b></td>
  <td>:</td>
  <td><input type="text" value="${sessionScope.user.state }" name="state" required></td>
  </tr>
  <tr>
  <td><b>Educational Qualification </b> </td>
  <td>:</td>
  <td><input type="text" value="  ${sessionScope.user.edu_qualification }" name="edu_qualification" required></td>
  <th></th>
 <td><b>Phone Number </b> </td>
  <td>:</td>
  <td> <input type="text" value="${sessionScope.user.phone_number }" name="phone_number" required></td>
  
  </tr>
  <tr>
  <td><b>Date of Birth </b></td>
  <td>:</td>
  <td> <input type="text" value=" ${sessionScope.user.dob }" name="dob" readonly></td>
  <th></th>
  
  <td><b>email</b></td>
  <td>:</td>
  <td> <input type="text" value="${sessionScope.user.email }" name="email" readonly></td>
  </tr>
  <tr>
  <td><b>Login Password</b></td>
  <td>:</td>
  <td> <input type="password" value="${sessionScope.user.password }" name="password" readonly></td>
  <th></th>
  
  <td><b>Confirm Password</b></td>
  <td>:</td>
  <td> <input type="password" placeholder="Confirm your password" name="confirmpassword"/></td>
  </tr>
  
  </table>

  <center> <input type="submit" value="submit"></center>
  
</form>
</div>
<br /><br />
  </div>
</body>
</html>