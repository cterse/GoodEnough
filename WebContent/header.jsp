<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="header.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GOODENOUGH</title>
<script>

window.onload = function() {
	document.getElementById("incorrectpass").style.visibility = "hidden";
	document.getElementById("nouser").style.visibility = "hidden";
	document.getElementById("logoutBtn").style.visibility = "hidden";
	
	var pageUrl = window.location.href;
	var parameters = pageUrl.split("?")[1];
	var forgot = parameters.split("=");
	if(forgot[0]=="openlogin" && forgot[1]=="true") {
		document.getElementById('id01').style.display='block';
	}
	if(forgot[0]=="nouser" && forgot[1]=="true") {
		document.getElementById('id01').style.display='block';
		document.getElementById("nouser").style.visibility = "visible";
		document.getElementById("nouser").style.color = "#ff0000";
	}
	if(forgot[0]=="forgotpass" && forgot[1]=="true") {
		document.getElementById('id01').style.display='block';
		document.getElementById("incorrectpass").style.visibility = "visible";
		document.getElementById("incorrectpass").style.color = "#ff0000";
	}
};


	//Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	/* 
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	} */
</script>
</head>
<body>
	<!--  <h4>Welcome ${sessionScope.user_email}</h4>
	<h1 align="center">GOODENOUGH</h1>
	<h3 align="center"> BE DAPPER!</h3>
	<br>-->
	
	<a style="text-decoration: none; margin-left:50%;" href="index.jsp"><h1 align="center">GOODENOUGH</h1></a>

	<div class="container">

		<div class="dropdown">
			<button class="dropbtn">
				<a href="#">Men</a>
			</button>
			<div class="dropdown-content">
				<a href="find-products?productGender=male&productCategory=bottomwear">Bottom Wear</a> <a href="find-products?productGender=male&productCategory=topwear">Top Wear</a>

			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				<a href="#">Women</a>
			</button>
			<div class="dropdown-content">
				<a href="find-products?productGender=female&productCategory=bottomwear">Bottom Wear</a> <a href="find-products?productGender=female&productCategory=topwear">Top Wear</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				<a href="aboutus.jsp">About Us</a>
			</button>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				<a href="contactus.jsp">Contact Us</a>
			</button>
		</div>

		<div class="dropdown" style="float: right;">
			<button class="dropbtn" id="logoutBtn">
				<a href="logout.jsp" style="float: right;">Logout</a>
			</button>
		</div>
		<div class="dropdown" style="float: right;">
			<% if(session.getAttribute("user_email")==null) { %>
			<button class="dropbtn"
				onclick="document.getElementById('id01').style.display='block'">
					<a href="#id01">Login</a></button>
				<% } else { %>
				<button class="dropbtn">
					Welcome <% out.print(session.getAttribute("user_email")); %>
				<% } %>
			</button>
		</div>

	</div>

	<!-- The Modal -->
	<div id="id01" name="id01" class="modal">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>

		<!-- Modal Content -->
		<form class="modal-content animate" method="post"
			action="login-servlet">

			<div class="container1">
				<label><b>Email</b></label> <input type="text"
					placeholder="Enter Username" name="email" required> <label><b>Password</b></label><span
					id="incorrectpass" class="incorrectpass">&nbsp;&nbsp;Incorrect
					Password!</span> <input type="password" placeholder="Enter Password"
					name="pword" required> <input type="checkbox"
					name="login_type" value="vendor">Login as Vendor<br>

				<button class="modalbtn" type="submit">Login</button>
				<span class="register">New User? <a href="register.jsp">Register</a></span>
				<!-- <span class="psw"><a href="#">Forgot password?</a></span> -->
			</div>

			<div class="container1" style="background-color: #f1f1f1">
				<button class="modalbtn" type="button"
					onclick="document.getElementById('id01').style.display='none'"
					id="cancelbtn">Cancel</button>

			</div>
		</form>
	</div>


</body>
</html>