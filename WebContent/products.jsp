<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Products</title>
		
		<%@ page import="java.util.*, com.ecom1.models.Product" %>
		
		<script type="text/javascript">
			window.onload = function() {
				var thumbs = document.getElementsByClassName("thumbnail");
				for(var i = 0; i < thumbs.length; i++) {
					thumbs[i].style.cursor = "pointer";
				}
			}
			
			function getProductDetails(pid) {
				var nextPage = "product-details?productId="+pid;
				//alert(nextPage);
				//document.location.href = "/EComProject/product-details";
				
			}
		</script>
	</head>
	<body>
		<div class="container" style="margin-top:3em;">
		<div class="row">
			<div class="col-sm-12">
				<% 
				List<Product> products = (List<Product>)request.getAttribute("results");
				for(Product p : products) {
					//out.println(p.getProductId() + " -- " + p.getProductName() + "<br>");	
					//System.out.println(System.getProperty("catalina.base"));
					//System.exit(0);
				%>  	
				
				  <div class="col-sm-6 col-md-4">
				  	<a style="text-decoration:none;" href="product-details?productId=<% out.print(p.getProductId()); %>">
				    <div class="thumbnail">
				      <img src="<% out.print(p.getProductImage()); %>" alt="...">
				      <div class="caption">
				        <h4><b><% out.print(p.getProductName()); %></b></h4>
				        <p><% out.print(p.getProductBrand()); %></p>
				        <h5>Rs. <% out.println(p.getProductPrice()); %></h5>
				      </div>
				    </div>
				    </a>
				  </div>
				
				<%
					}
				%>
			</div>
		</div>
			
		</div>
	</body>
</html>