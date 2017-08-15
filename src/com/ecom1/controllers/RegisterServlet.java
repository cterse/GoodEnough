package com.ecom1.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom1.daos.CustomerDAO;
import com.ecom1.daos.VendorDAO;
import com.ecom1.models.Customer;
import com.ecom1.models.Vendor;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userType = request.getParameter("user_type");
		String firstName = request.getParameter("first_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone_number");
		
		String lastName = null, address = null;
		if(userType.equals("customer")) {
			lastName = request.getParameter("last_name");
			address = request.getParameter("address");
		}
		
		if(userType.equals("customer")) {
			Customer c = new Customer();
			c.setCustomerFirstName(firstName);
			c.setCustomerLastName(lastName);
			c.setCustomerAddress(address);
			c.setCustomerEmail(email);
			c.setCustomerPassword(password);
			c.setCustomerPhone(phone);
			c.setCustomerRegDate(new Date());
			System.out.println("Calling customerDAO: "+CustomerDAO.insertIntoCustomer(c));
		} else if(userType.equals("vendor")) {
			Vendor v = new Vendor();
			v.setVendorName(firstName);
			v.setVendorPhone(phone);
			v.setVendorEmail(email);
			v.setVendorPassword(password);
			System.out.println("Calling VendorDAO: "+VendorDAO.insertIntoVendor(v));
		}

		response.sendRedirect("index.jsp");
		
	}
	
}
