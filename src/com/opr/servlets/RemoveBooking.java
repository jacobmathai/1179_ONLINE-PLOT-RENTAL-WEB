package com.opr.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opr.model.PropertyModel;

/**
 * Servlet implementation class RemoveBooking
 */
@WebServlet("/RemoveBooking")
public class RemoveBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String propId = request.getParameter("bookId");
	        try {
	            boolean status = new PropertyModel().remoBooking(propId);
	            if (status) {
	                response.sendRedirect("admin_view_booked_list.jsp");
	            } else {
	                response.sendRedirect("error.jsp");
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
	            request.setAttribute("javax.servlet.jsp.jspException", ex);
	            rd.forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
