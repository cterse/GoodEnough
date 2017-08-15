package com.ecom1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecom1.daos.CustomerDAO;
import com.ecom1.daos.ProductDAO;
import com.ecom1.daos.VendorDAO;
import com.ecom1.models.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pword");
		String loginType = request.getParameter("login_type");
		
		Map<String, String> extractedMappings;
		if(loginType!=null && loginType.equals("vendor")) {
			extractedMappings = VendorDAO.getVendorLoginMappings();
		} else {
			extractedMappings = CustomerDAO.getCustomerLoginMappings();
		}
		
		if(extractedMappings.containsKey(email)) {
			if(extractedMappings.get(email).equals(password)) {
				System.out.println("Successful login");
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(60 * 5);
				session.setAttribute("user_email", email);
				if(loginType!=null && loginType.equals("vendor")) {
					request.getSession(false).setAttribute("product_count", ProductDAO.getVendorProductCount(email));
					response.sendRedirect("vendorhome.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
			} else {
				System.out.println("Unsuccessful login. Wrong password.");
				response.sendRedirect("index.jsp?forgotpass=true");
			}
		} else {
			System.out.println("Unsuccessful login. User not found.");
			response.sendRedirect("index.jsp?nouser=true");
		}
		
	}
}
