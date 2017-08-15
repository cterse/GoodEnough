<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" href="register.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register</title>
	<script>
		function validate()
		{
			var pword=document.getElementById("pword").value;
			var confpword=document.getElementById("confpword").value;
			if(pword!=confpword) {
				alert("Passwords must match");
			}
		}
		function getUser()
		{
			user=document.getElementById("user").value;
			if(user=="customer")
			{
				window.location("register.jsp");
				}
			else
				if(user=="vendor")
				{
					window.location("vendorregister.jsp");
					}
		}
		
	</script>
	</head>
	<body>
		<div align="center">
		<form method="post" action="register-servlet">
		Register as:<select id="user" name="user_type" onchange="getUser()">
		<option value="customer">Customer</option>
		<option value="vendor">Vendor</option>
		</select><br><br>
			Enter First Name:<input type="text" name="first_name" required><br><br>
			Enter Last Name:<input type="text" name="last_name" required><br><br>
			Enter Email:<input type="text" name="email" required pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[a-z]{2,3}$" title="Incorrect Email Format"><br><br>
			Enter Phone Number:<input type="text" name="phone_number" required pattern="[1-9][0-9]{9}" title="Phone Number must start with either 7, 8 or 9 and must have 10 digits" ><br><br>
			Enter Address:<textarea rows="3" cols="15" name="address" required></textarea><br><br>
			Enter Password:<input type="password" name="password" id="pword"  required></textarea><span id="msg"></span><br><br>
			Confirm Password:<input type="password" name="confirm_password" id="confpword" onBlur="validate()" required></textarea><br><br>
			<input type="submit" value="Register"></span>
		</form>
		</div>
	</body>
</html>