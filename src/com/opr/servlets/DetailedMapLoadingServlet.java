/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.servlets;

import com.opr.bean.PropertyBean;
import com.opr.model.SearchModel;
import com.opr.utils.AppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Administrator
 */
public class DetailedMapLoadingServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            PropertyBean bean = new PropertyBean();
            bean.setPropType(request.getParameter("propType"));
            bean.setCity(request.getParameter("city"));
            bean.setPrice(request.getParameter("price"));
            bean.setBedrooms(request.getParameter("beds"));
            bean.setBathrooms(request.getParameter("baths"));
            bean.setArea(request.getParameter("area"));
            if (request.getParameter("type").equals("For_Sale")) {
                bean.setContractType(AppConstants.FOR_SALE);
            } else if (request.getParameter("type").equals("For_Rent")) {
                bean.setContractType(AppConstants.FOR_RENT);
            } else {
                bean.setContractType(AppConstants.ALL);
            }

            JSONArray defaultJSONArray = new SearchModel().getMapInfo(bean);
            out.println(defaultJSONArray);

        } catch (SQLException | ClassNotFoundException | ParseException ex) {
            ex.printStackTrace();
            out.println(ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
