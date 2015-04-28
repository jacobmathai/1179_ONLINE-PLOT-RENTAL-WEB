/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.ajax.servlet;

import com.opr.utils.AppVariable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class VideoFetchingServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final int BYTES_DOWNLOAD = 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String propId = request.getParameter("prop_id");
//            String videoPath = AppConstants.VIDEO_FOLDER + File.separator
//                    + propId + ".MP4";
            String videoPath = AppVariable.VIDEO_SERVLET_CONTEXT + File.separator
                    + propId + ".MP4";
            File videoFile = new File(videoPath);

            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Length", String.valueOf(videoFile.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + videoFile.getName() + "\"");
            response.setHeader("Cache-Control", "public");


            BufferedInputStream input = null;
            BufferedOutputStream output = null;

            try {
                // Open streams.
                input = new BufferedInputStream(new FileInputStream(videoFile));
                output = new BufferedOutputStream(response.getOutputStream());

                // Write file contents to response.
                byte[] buffer = new byte[BYTES_DOWNLOAD];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
            } finally {
                out.close();
                input.close();
                output.close();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
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
