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
 * Servlet implementation class AdminDeleteProperty
 */
@WebServlet("/AdminDeleteProperty")
public class AdminDeleteProperty extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String propId = request.getParameter("prop_id");
        try {
            boolean status = new PropertyModel().removePorty(propId);
            if (status) {
                response.sendRedirect("admin_view_list.jsp");
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
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
