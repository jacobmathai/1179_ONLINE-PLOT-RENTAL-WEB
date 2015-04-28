/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.ajax.servlet;

import com.opr.image.ImageUtils;
import com.opr.utils.AppConstants;
import com.opr.utils.AppVariable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author SUJITH
 */
public class MultiPartServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    File realDir = null;
    File navDir = null;
    File searchDir = null;
    File videoDir = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            AppVariable.REAL_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.REAL_FOLDER);
            AppVariable.NAVIGATE_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.NAVIGATE_FOLDER);
            AppVariable.SEARCH_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.SEARCH_FOLDER);
            AppVariable.VIDEO_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.VIDEO_FOLDER);

            realDir = new File(AppVariable.REAL_SERVLET_CONTEXT);
            navDir = new File(AppVariable.NAVIGATE_SERVLET_CONTEXT);
            searchDir = new File(AppVariable.SEARCH_SERVLET_CONTEXT);
            videoDir = new File(AppVariable.VIDEO_SERVLET_CONTEXT);

            if (!realDir.exists()) {
                realDir.mkdirs();
            }

            if (!navDir.exists()) {
                navDir.mkdirs();
            }

            if (!searchDir.exists()) {
                searchDir.mkdirs();
            }

            String propId = "";
//            List<FileItem> fileItems =
//                    new ServletFileUpload(new DiskFileItemFactory(1024 * 1024, new File("C:\\tmp"))).parseRequest(request);
            List<FileItem> fileItems =
                    new ServletFileUpload(new DiskFileItemFactory(1024 * 1024, new File(AppVariable.REAL_SERVLET_CONTEXT))).parseRequest(request);

            for (FileItem item : fileItems) {
                String fieldName = item.getFieldName();
                System.out.println("FieldName: " + fieldName);
                if (item.isFormField()) {
                    if (fieldName.equals("prop_id")) {
                        propId = item.getString();
                        System.out.println("Prop id in multipart : " + propId);
                    }
                } else {
                    if (fieldName.equals("image1")) {
                        InputStream inputStream = item.getInputStream();
                        File imgOne = new File(realDir + File.separator + AppConstants.PHOTO_ONE + propId.trim() + ".jpg");
                        OutputStream outStream = new FileOutputStream(imgOne);
                        ImageUtils.copy(inputStream, outStream);
                        ImageUtils.saveImage(propId, imgOne, AppConstants.PHOTO_ONE);
                        inputStream.close();
                        outStream.close();
                    } else if (fieldName.equals("image2")) {
                        InputStream inputStream = item.getInputStream();
                        File secondImg = new File(realDir + File.separator + AppConstants.PHOTO_TWO + propId + ".jpg");
                        OutputStream outStream = new FileOutputStream(secondImg);
                        ImageUtils.copy(inputStream, outStream);
                        ImageUtils.saveAllImage(propId, secondImg, AppConstants.PHOTO_TWO);
                        inputStream.close();
                        outStream.close();
                    } else if (fieldName.equals("image3")) {
                        InputStream inputStream = item.getInputStream();
                        File thirdImg = new File(realDir + File.separator + AppConstants.PHOTO_THREE + propId + ".jpg");
                        OutputStream outStream = new FileOutputStream(thirdImg);
                        ImageUtils.copy(inputStream, outStream);
                        ImageUtils.saveAllImage(propId, thirdImg, AppConstants.PHOTO_THREE);
                        inputStream.close();
                        outStream.close();
                    } else if (fieldName.equals("image4")) {
                        InputStream inputStream = item.getInputStream();
                        File fourthImg = new File(realDir + File.separator + AppConstants.PHOTO_FOUR + propId + ".jpg");
                        OutputStream outStream = new FileOutputStream(fourthImg);
                        ImageUtils.copy(inputStream, outStream);
                        ImageUtils.saveAllImage(propId, fourthImg, AppConstants.PHOTO_FOUR);
                        inputStream.close();
                        outStream.close();
                    } else if (fieldName.equals("video")) {
                        InputStream inputStream = item.getInputStream();
                        File path = new File(AppVariable.VIDEO_SERVLET_CONTEXT);
                        if (!path.exists()) {
                            path.mkdirs();
                        }
                        File videoFile = new File(path + File.separator + propId + ".MP4");
                        OutputStream outStream = new FileOutputStream(videoFile);
                        ImageUtils.copy(inputStream, outStream);
                        inputStream.close();
                        outStream.close();
                    }

                } // File uploaded
            }



        } catch (FileUploadException ex) {
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
