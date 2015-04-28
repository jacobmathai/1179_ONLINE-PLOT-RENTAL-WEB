/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.opr.bean.LoginBean;
import com.opr.bean.PropertyBean;
import com.opr.image.ImageResizer;
import com.opr.model.GcmModel;
import com.opr.model.PasswordGenerator;
import com.opr.model.PropertyModel;
import com.opr.utils.AppConstants;
import com.opr.utils.AppVariable;
import java.io.PrintWriter;

/**
 *
 * @author SUJITH
 */
public class PlotSubmitServlet extends HttpServlet {

    File realDir = null;
    File navDir = null;
    File searchDir = null;
    File videoDir = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int maxFileSize = 524280000;
        RequestDispatcher dispatcher = null;
        try {
            AppVariable.REAL_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.REAL_FOLDER);
            AppVariable.NAVIGATE_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.NAVIGATE_FOLDER);
            AppVariable.SEARCH_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.SEARCH_FOLDER);
            AppVariable.VIDEO_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.VIDEO_FOLDER);
            AppVariable.TEMP_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.TEMP_FOLDER);

            realDir = new File(AppVariable.REAL_SERVLET_CONTEXT);
            navDir = new File(AppVariable.NAVIGATE_SERVLET_CONTEXT);
            searchDir = new File(AppVariable.SEARCH_SERVLET_CONTEXT);
            videoDir = new File(AppVariable.VIDEO_SERVLET_CONTEXT);


            //     String username = request.getParameter("username");
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            System.out.println("isMultipart :" + isMultipart);
            // Create a factory for disk-based file items
            if (isMultipart) {
                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);

                // Set overall request size constraint
                upload.setSizeMax(maxFileSize);

                List items = upload.parseRequest(request);

                // ----------------Our Code---------------------------
                PropertyBean bean = new PropertyBean();
                bean.setPropertyId(new PasswordGenerator().getRandomNumber());
                // bean.setUsername(username);
                bean.setType(AppConstants.PLOT);
                Iterator itr = items.iterator();
                while (itr.hasNext()) {
                    FileItem fileItem = (FileItem) itr.next();
                    // System.out.println("Item Name :" +
                    // fileItem.getFieldName());
                    if (fileItem.isFormField()) {
                        if (fileItem.getFieldName().equals("owner")) {
                            bean.setUsername(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("prop_title")) {
                            bean.setPropTitle(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("location")) {
                            bean.setLocation(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("prop_type")) {
                            bean.setPropType(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("city")) {
                            bean.setCity(fileItem.getString());
                        } else if (fileItem.getFieldName().equals(
                                "pub_location")) {
                            bean.setPublicLocaton(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("distance")) {
                            bean.setDistance(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("address")) {
                            bean.setAddress(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("rate")) {
                            bean.setPrice(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("area")) {
                            bean.setArea(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("description")) {
                            bean.setDescription(fileItem.getString());

                        } else if (fileItem.getFieldName().equals(
                                "contract_type")) {
                            bean.setContractType(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("proof")) {
                            bean.setProofType(fileItem.getString());
                        } else if (fileItem.getFieldName().equals("proof_id")) {
                            bean.setProofId(fileItem.getString());
                        }
                    } else {
                        if (fileItem.getSize() > 0) {
                            try {
                                String fileName = fileItem.getName();
                                if (fileItem.getFieldName().equals("prop_image")) {

                                    if (fileName.endsWith(".jpg")
                                            || fileName.endsWith(".JPG")
                                            || fileName.endsWith(".png")
                                            || fileName.endsWith(".PNG")
                                            || fileName.endsWith(".jpeg")
                                            || fileName.endsWith(".JPEG")
                                            || fileName.endsWith(".ico")
                                            || fileName.endsWith(".ICO")) {

                                        if (!realDir.exists()) {
                                            realDir.mkdirs();
                                        }

                                        File realImg = new File(realDir + File.separator + AppConstants.PHOTO_ONE
                                                + bean.getPropertyId() + ".jpg");
                                        File realFile = new File(realDir,
                                                realImg.getName());

                                        fileItem.write(realFile);
                                        saveImage(bean.getPropertyId(), realImg, AppConstants.PHOTO_ONE);
                                    }
                                } else if (fileItem.getFieldName().equals(
                                        "photo1")) {
                                    if (fileName.endsWith(".jpg")
                                            || fileName.endsWith(".JPG")
                                            || fileName.endsWith(".png")
                                            || fileName.endsWith(".PNG")
                                            || fileName.endsWith(".jpeg")
                                            || fileName.endsWith(".JPEG")
                                            || fileName.endsWith(".ico")
                                            || fileName.endsWith(".ICO")) {

                                        if (!realDir.exists()) {
                                            realDir.mkdirs();
                                        }

                                        File realImg = new File(realDir + File.separator + AppConstants.PHOTO_TWO
                                                + bean.getPropertyId() + ".jpg");
                                        File realFile = new File(realDir,
                                                realImg.getName());

                                        fileItem.write(realFile);
                                        saveAllImage(bean.getPropertyId(), realImg, AppConstants.PHOTO_TWO);

                                    }
                                } else if (fileItem.getFieldName().equals(
                                        "photo2")) {
                                    if (fileName.endsWith(".jpg")
                                            || fileName.endsWith(".JPG")
                                            || fileName.endsWith(".png")
                                            || fileName.endsWith(".PNG")
                                            || fileName.endsWith(".jpeg")
                                            || fileName.endsWith(".JPEG")
                                            || fileName.endsWith(".ico")
                                            || fileName.endsWith(".ICO")) {

                                        if (!realDir.exists()) {
                                            realDir.mkdirs();
                                        }

                                        File realImg = new File(realDir + File.separator + AppConstants.PHOTO_THREE
                                                + bean.getPropertyId() + ".jpg");
                                        File realFile = new File(realDir,
                                                realImg.getName());

                                        fileItem.write(realFile);
                                        saveAllImage(bean.getPropertyId(), realImg, AppConstants.PHOTO_THREE);
                                    }
                                } else if (fileItem.getFieldName().equals(
                                        "photo3")) {
                                    if (fileName.endsWith(".jpg")
                                            || fileName.endsWith(".JPG")
                                            || fileName.endsWith(".png")
                                            || fileName.endsWith(".PNG")
                                            || fileName.endsWith(".jpeg")
                                            || fileName.endsWith(".JPEG")
                                            || fileName.endsWith(".ico")
                                            || fileName.endsWith(".ICO")) {

                                        if (!realDir.exists()) {
                                            realDir.mkdirs();
                                        }

                                        File realImg = new File(realDir + File.separator + AppConstants.PHOTO_FOUR
                                                + bean.getPropertyId() + ".jpg");
                                        File realFile = new File(realDir,
                                                realImg.getName());

                                        fileItem.write(realFile);
                                        saveAllImage(bean.getPropertyId(), realImg, AppConstants.PHOTO_FOUR);
                                    }
                                } else if (fileItem.getFieldName().equals(
                                        "video")) {
                                    if (fileName.endsWith(".mp4")
                                            || fileName.endsWith(".MP4")
                                            || fileName.endsWith(".avi")
                                            || fileName.endsWith(".3gp")
                                            || fileName.endsWith(".mpeg")
                                            || fileName.endsWith(".vob")
                                            || fileName.endsWith(".mkv")
                                            || fileName.endsWith(".flv")
                                            || fileName.endsWith(".wmv")
                                            || fileName.endsWith(".mov")) {
                                        if (!videoDir.exists()) {
                                            videoDir.mkdirs();
                                        }
                                    }
                                    File propImage = new File(videoDir
                                            + File.separator
                                            + bean.getPropertyId() + ".MP4");
                                    File videoFile = new File(videoDir,
                                            propImage.getName());

                                    fileItem.write(videoFile);
                                }

                            } catch (Exception ex) {
                                dispatcher = request.getRequestDispatcher("error.jsp");
                                request.setAttribute("javax.servlet.jsp.jspException", ex);
                                dispatcher.forward(request, response);
                                ex.printStackTrace();
                            }
                        }
                    }
                }
                String status = "";
                HttpSession session = request.getSession();
                LoginBean loginBean = (LoginBean) session.getAttribute(AppConstants.SESSION);
                if (loginBean != null
                        && loginBean.getUserType().equals(AppConstants.TYPE_ADMIN)) {
                    bean.setStatus(AppConstants.APPROVED);
                    bean.setUsername(loginBean.getUsername());
                    status = new PropertyModel().addPlotInfo(bean);
                    if (status.equals(AppConstants.TRUE)) {
                        new GcmModel().sendGcm(bean.getPropertyId());
                        if (status.equals(AppConstants.TRUE)) {
                            response.sendRedirect("admin_submit_plot.jsp?status="
                                    + AppConstants.SUCCESS);
                        } else {
                            response.sendRedirect("admin_submit_plot.jsp?status="
                                    + AppConstants.FAILED);
                        }
                    }
                } else if (loginBean != null && loginBean.getUserType().equals(AppConstants.TYPE_USER)) {
                    bean.setStatus(AppConstants.PENDING);
                    bean.setUsername(loginBean.getUsername());
                    status = new PropertyModel().addPlotInfo(bean);
                    if (status.equals(AppConstants.TRUE)) {
                        new GcmModel().sendGcm(bean.getPropertyId());
                        if (status.equals(AppConstants.TRUE)) {
                            response.sendRedirect("user_submit_plot.jsp?status="
                                    + AppConstants.SUCCESS);
                        } else {
                            response.sendRedirect("user_submit_plot.jsp?status="
                                    + AppConstants.FAILED);
                        }
                    }
                } else {
                    response.sendRedirect("404.jsp");
                }


            }

        } catch (FileUploadException | ClassNotFoundException | SQLException ex) {
            dispatcher = request.getRequestDispatcher("error.jsp");
            request.setAttribute("javax.servlet.jsp.jspException", ex);
            dispatcher.forward(request, response);
            ex.printStackTrace();
        }

    }

    private void saveImage(String propertyId, File realImg, String photoNo) throws IOException {

        if (!navDir.exists()) {
            navDir.mkdirs();
        }
        if (!searchDir.exists()) {
            searchDir.mkdirs();
        }

        File navImg = new File(navDir
                + File.separator
                + photoNo
                + propertyId + ".jpg");

        File searchImg = new File(searchDir
                + File.separator
                + photoNo
                + propertyId + ".jpg");

        // Resize image to real image size
        ImageResizer.resize(
                realImg.getAbsolutePath(),
                realImg.getAbsolutePath(),
                AppConstants.REAL_IMG_WIDTH,
                AppConstants.REAL_IMG_HEIGHT);

        // Resize image to navigate image size
        ImageResizer.resize(realImg.getAbsolutePath(),
                navImg.getAbsolutePath(),
                AppConstants.NAVIGATE_IMG_WIDTH,
                AppConstants.NAVIGATE_IMG_HEIGHT);

        // Resize image to search image size
        ImageResizer.resize(realImg.getAbsolutePath(),
                searchImg.getAbsolutePath(),
                AppConstants.SEARCH_IMG_WIDTH,
                AppConstants.SEARCH_IMG_HEIGHT);

    }

    private void saveAllImage(String propertyId, File realImg, String photoNo) throws IOException {

        if (!navDir.exists()) {
            navDir.mkdirs();
        }

        File navImg = new File(navDir
                + File.separator
                + photoNo
                + propertyId + ".jpg");



        // Resize image to real image size
        ImageResizer.resize(
                realImg.getAbsolutePath(),
                realImg.getAbsolutePath(),
                AppConstants.REAL_IMG_WIDTH,
                AppConstants.REAL_IMG_HEIGHT);

        // Resize image to navigate image size
        ImageResizer.resize(realImg.getAbsolutePath(),
                navImg.getAbsolutePath(),
                AppConstants.NAVIGATE_IMG_WIDTH,
                AppConstants.NAVIGATE_IMG_HEIGHT);
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
