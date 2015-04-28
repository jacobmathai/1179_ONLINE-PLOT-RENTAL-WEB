/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.ajax.servlet;

import com.opr.model.SearchModel;
import com.opr.utils.AppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author SUJITH
 */
public class PlotFetchingServlet extends HttpServlet {

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
            //city, prop_type, max_price, beds, for_sale
            //Data: {"property_type":["FARM_LAND","ASSOCIATED_LAND","NON_URBAN_LAND","MULTY_STORY_BUILDINGS"],"contract_type":"For_sale","max_amount":"500000","city":"Trivandrum","type":"plot"}
            String data = request.getParameter("json");
            if (AppConstants.DEBUG) {
                System.out.println("Plot json:" + data);
            }
            JSONObject jsonData = (JSONObject) JSONValue.parse(data);

            JSONArray searchResult = new SearchModel().getPlotForUser(jsonData);
            out.println(searchResult);
        } catch (ClassNotFoundException | SQLException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("javax.servlet.jsp.jspException", ex);
            rd.forward(request, response);
            ex.printStackTrace();
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
