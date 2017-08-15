<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">

<%
	if(session.getAttribute("user_email") == null) {
		response.sendRedirect("index.jsp?openlogin=true");
	}
	out.print("Adding Product as Vendor = "+session.getAttribute("user_email"));
%>

<form method="post" action="add-product-servlet">
			Enter Product Name:<input type="text" name="product_name" required pattern="[A-Za-z]{1,30}" title="Enter Valid Characters"><br><br>
			
			Enter Size:<input type="text" name="size" required pattern="[sS|mM|lL]"><br><br>
			
			Enter Color:<input type="text" name="color" required pattern="[A-Za-z]{1,15}" title="Enter Valid Characters"><br><br>
			
			Enter Quantity:<input type="number" name="quantity" required><br><br>
			
			Enter Price:<input type="number" name="price" required><br><br>
			
			Enter Brand:<input type="text" name="brand" id="p_brand"  required pattern="[A-Za-z]{1,}" title="Enter Valid Characters"><br><br>
			
			Enter Product Description:<textarea rows="3" cols="15" name="description" required></textarea><br><br>
			
			Enter Category:<input type="text" name="category" required pattern="[A-Za-z]{1,40}" title="Enter Valid Characters"><br><br>
			
			Enter Category-type:<input type="text" name="category-type" required pattern="[A-Za-z]{1,50}" title="Enter Valid Characters"><br><br>
			
			Select Gender:<select id="gender" name="gender">
			<option value="male">Male</option>
			<option value="female">Female</option>
			</select><br><br>
			
			<input type="submit" value="Add Product"></span>
		</form>
		</div>
</body>
</html>