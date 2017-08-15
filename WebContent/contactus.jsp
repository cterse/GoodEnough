<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="contactus.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>

</head>
<body >

<div class="conform">
<fieldset>

				<legend>Contact Us</legend>
<form align="center" method="get" action="feedback-servlet" class="mainform">

<b>Enter your name:</b> <input type="text" name="name" required title="Enter valid name" /><br/><br/>
<b>Enter your E-mail address:</b> <input type="email" name="mail" required title="Enter valid E-Mail address" /><br><br/>
<b>Enter Message:</b><br/><br/> <textarea rows="4" cols="50" name="message" required> </textarea><br><br>
<input type="submit" value="SUBMIT"/>
</fieldset>
</div>
</form>

</body>
</html>