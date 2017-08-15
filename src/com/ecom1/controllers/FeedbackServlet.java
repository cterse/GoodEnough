package com.ecom1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/feedback-servlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		String nm= request.getParameter("name");
		String email=request.getParameter("mail");
		String msg=request.getParameter("message");
		
		HttpSession session=request.getSession();
		session.setAttribute("somemsg", "Hello" +nm+ "Thank you for yor Feedback!" );
		
		RequestDispatcher view= request.getRequestDispatcher("responsefeedback.jsp");
		view.forward(request, response);
	}

}
