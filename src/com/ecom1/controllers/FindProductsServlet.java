package com.ecom1.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom1.daos.ProductDAO;
import com.ecom1.models.Product;

/**
 * Servlet implementation class FindProductsServlet
 */
@WebServlet(description = "Servlet takes the filters as input from jsp pages and calls the appropriate method in ProductDAO", urlPatterns = { "/find-products" })
public class FindProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] parameters = request.getQueryString().split("&");
		Map<String, String> filters = new HashMap<String, String>();
		for(int i=0; i<parameters.length; i++) {
			String[] temp = parameters[i].split("=");
			filters.put(temp[0], temp[1]);
		}
		System.out.println("Finding products based on: "+filters);
		
		List<Product> result = ProductDAO.getProductsByFilters(filters);
		for(Product p : result) {
			System.out.println(p.getProductId()+" -- "+p.getProductName());
		}
		request.setAttribute("results", result);
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
