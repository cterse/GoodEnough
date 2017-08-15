<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Welcome ${sessionScope.user_email}</h4>
<h1 align="center">GOODENOUGH</h1>
<br><br><br>
<ul>
   <li><a href="#">Men</a></li>
   <li><a href="#">Women</a></li>
   <li><a href="#">About Us</a></li>
   <li><a href="#">Contact Us</a></li>
   <li><a href="#">Shopping Bag</a></li>
   <li style="float:right;"><a href="logout.jsp">Logout</a></li>
</ul>
</body>
</html>