<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="loginpop.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GOODENOUGH</title>
<script> 

window.onload = function() {
	document.getElementById("incorrectpass").style.visibility = "hidden";
	var pageUrl = window.location.href;
	var parameters = pageUrl.split("?")[1];
	var forgot = parameters.split("=");
	if(forgot[0]=="forgotpass" && forgot[1]=="true") {
		document.getElementById('id01').style.display='block';
		document.getElementById("incorrectpass").style.visibility = "visible";
		document.getElementById("incorrectpass").style.color = "#ff0000";
	}
};

function openNav() {
    document.getElementById("myNav").style.width = "100%";
}

/* Close when someone clicks on the "x" symbol inside the overlay */
function closeNav() {
    document.getElementById("myNav").style.width = "0%";
} 

//Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
 window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}



</script>
</head>
<body >

<div align="center" >
<h2 align="center">GOODENOUGH</h2>
<button onclick="openNav()">Menu</button>
<button onclick="document.getElementById('id01').style.display='block'">Login</button>
<a class="regCSS" href="register.jsp">Register</a>
</div>
<div class="slideshow-container">
  <div class="mySlides fade">
    <img src="images/slider1.jpg" style="width:100%">

  </div>

  <div class="mySlides fade">
    <img src="images/slider2.jpg" style="width:100%">
  </div>

  <div class="mySlides fade">
    <img src="images/slider3.jpg" style="width:100%">
  </div>

  <div class="mySlides fade">
    <img src="images/slider4.jpg" style="width:100%">
  </div>

  <div class="mySlides fade">
    <img src="images/slider6.jpg" style="width:100%">
  </div>



<div id="myNav" class="overlay">

  <!-- Button to close the overlay navigation -->
  <a  class="closebtn" onclick="closeNav()">&times;</a>

  <!-- Overlay content -->
  <div class="overlay-content">
    <a href="find-products?productGender=male">Men</a>
    <a href="find-products?productGender=female">Women</a>
    <a href="aboutus.jsp">About Us</a>
    <a href="contactus.jsp">Contact Us</a>
  </div>

</div>


<!-- The Modal -->
<div id="id01" name="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" 
 class="close" title="Close Modal">&times;</span>

  <!-- Modal Content -->
  <form class="modal-content animate" method="post" action="login-servlet">
    
    <div class="container">
      <label><b>Email</b></label>
      <input type="text" placeholder="Enter Username" name="email" required>

      <label><b>Password</b></label><span id="incorrectpass" class="incorrectpass">&nbsp;&nbsp;Incorrect Password!</span>
      <input type="password" placeholder="Enter Password" name="pword" required>
		
		<input type="checkbox" name="login_type" value="vendor">Login as Vendor<br>
		
      <button type="submit">Login</button>
      <span class="register">New User? <a href="register.jsp">Register</a></span>
      <!-- <span class="psw"><a href="#">Forgot password?</a></span> -->
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      
    </div>
  </form>
</div> 

<!-- Use any element to open/show the overlay navigation menu -->
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex> slides.length) {slideIndex = 1}
    slides[slideIndex-1].style.display = "block";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

</body>


</html>