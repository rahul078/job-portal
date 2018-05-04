<!DOCTYPE html>
<html>
<head>
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

</head>

<body>
  <!-- Code using Bootstrap for navigation bar -->
  <nav class="navbar navbar-default" id="navigation">
	<img id="logo" src="images/logo_4.png" />
	<ul class="nav navbar-nav navbar-right">
    <li id="current"><a href="homepage.jsp"><center>Homepage</center></a></li>
    <li><a href="free_trial"><center>Free Trial</center></a></li>
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

<!-- The below code is used for image slider 1. html code    2. JQuery    3. JavaScript Code  -->
<div class="w3-content w3-display-container" style="max-width:100%" id="slider">
  <img class="mySlides w3-animate-right" src="images/slide5.jpg" style="width:100%">
  <img class="mySlides w3-animate-right" src="images/slide2.jpg" style="width:100%">
  <img class="mySlides w3-animate-right" src="images/slide3.jpg" style="width:100%">
  <img class="mySlides w3-animate-right" src="images/slide4.jpg" style="width:100%">
  <div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
	  <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(4)"></span>
  </div>
</div>
<script>

var myIndex = 0;
carousel();
<!--Implement timer -->
function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}
    x[myIndex-1].style.display = "block";
    setTimeout(carousel, 2000);// Change image every 4 seconds
    currentDiv(myIndex)
}
<!--Implement manual slider -->
var slideIndex = 1;
showDivs(slideIndex);
function currentDiv(n) {
  showDivs(slideIndex = n);
}
function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-white", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-white";
}
</script>
<!-- End of Image Slider code  -->

<!--Content of the Website -->
<div class="blocks" id="math">
  <center><img src="images/math_cut.png" alt="none" height="128px"></center>
  <br />
  <h3><center>Quantitative Maths Questions</center></h3>
  <br />
  <p>
     We usually understand <b>Quantitative aptitude</b> that basically judges our analytical and problem solving skills.
     In these questions, <b>speed of the candidate</b> matters more than his/her knowledge. Aptitude paper is an essential part of almost all competitive exams. If you are going to appear for any competitive exam or for a job interview, you must start working on your aptitude skills.

  </p>
</div>
<div class="blocks" id="verbal">
  <center><img src="images/verbal_cut.png" alt="none" height="128px"></center>
  <br />
  <h3><center>Verbal reasoning tests</center></h3>
  <br />
  <p>
     Verbal reasoning tests assess your <b>understanding and comprehension skills</b>. You will be presented with a short passage of text and will need to answer a True, False or Cannot Say response to each statement.
  </p>
</div>
<div class="blocks" id="situation">
  <center><img src="images/situation_cut.png" alt="none" height="128px"></center>
  <br />
  <h3><center>Situational judgement tests</center></h3>
  <br />
  <p>
     Situational Judgement Tests assess how you <b>approach situations</b> encountered in the workplace. Whilst there is some variation in how they are delivered, they typically present you with a written description of a scenario and ask you to select the appropriate response from a multiple choice list.
  </p>
</div>






</body>
</html>
