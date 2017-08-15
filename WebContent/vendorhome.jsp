<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vendor Home</title>
</head>
<body>
	<h1><% out.println("Welcome " + session.getAttribute("user_email")); %></h1>
	<h2><% 
		out.println("Your Product count = "+session.getAttribute("product_count"));
	%></h2>
	
	<a href="vendoraddproduct.jsp">Add Products</a><br>
	<a href="vendordeleteproduct.jsp">Delete Products</a>
	
	<a href="?logout=true">Logout</a>
</body>

<% 
	String queryString = request.getQueryString();
	if(queryString!=null && queryString.contains("logout=true")) {
		session.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>

</html>