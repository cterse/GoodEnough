package com.ecom1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecom1.daos.ProductDAO;
import com.ecom1.daos.VendorDAO;
import com.ecom1.models.Product;
import com.ecom1.models.Vendor;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add-product-servlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("quantity"));
		//System.exit(0);
			
		Product p=new Product();
		String product_name=request.getParameter("product_name");
		String size=request.getParameter("size");
		String color=request.getParameter("color");
		String brand=request.getParameter("brand");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String category=request.getParameter("category");
		String categorytype=request.getParameter("category-type");
		String description=request.getParameter("description");
		String imagepath=request.getParameter("image");
		String gender=request.getParameter("gender");
		Double price=Double.parseDouble(request.getParameter("price"));
		
		String currentVendorEmail = (String) request.getSession().getAttribute("user_email");
		Vendor currentVendor = VendorDAO.getVendorByEmail(currentVendorEmail);
		
		p.setProductName(product_name);
		p.setProductSize(size);
		p.setProductPrice(price);
		p.setProductColor(color);
		p.setProductBrand(brand);
		p.setProductCategory(category);
		p.setProductType(categorytype);
		p.setProductDescription(description);
		p.setProductImage(imagepath);
	    p.setProductGender(gender);
		p.setVendor(currentVendor);
		 
		int insertStatus = ProductDAO.insertIntoProduct(p,quantity);
		if(insertStatus == 0) {
			//response.sendRedirect("uploadimage.jsp");
			
			int vendorProductCount = VendorDAO.getVendorProductCount(currentVendorEmail);
			request.getSession(false).setAttribute("product_count", vendorProductCount);
			request.getRequestDispatcher("vendorhome.jsp").forward(request, response);
		} else {
			System.out.println("Add product wrong status");
		}
	}

}
