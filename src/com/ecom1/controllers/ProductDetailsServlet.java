package com.ecom1.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecom1.daos.ProductDAO;
import com.ecom1.models.Product;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Reached "+request.getQueryString());
		String strPid = request.getQueryString().split("=")[1];
		int pid = Integer.parseInt(strPid);
		
		Product p = ProductDAO.getProductById(pid);
		
		System.out.println(p.getProductId()+" : "+p.getProductName());
		
		request.setAttribute("product", p);
		request.getRequestDispatcher("productdetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
