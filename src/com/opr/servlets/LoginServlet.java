package com.opr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opr.bean.LoginBean;
import com.opr.model.SearchModel;
import com.opr.utils.AppConstants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        try {
          
            LoginBean bean = new LoginBean();
            bean.setUsername(request.getParameter("username"));
            bean.setPassword(request.getParameter("password"));

            String type = new SearchModel().checkLogin(bean);
            if (type != null && !type.equals("")) {
                HttpSession session = request.getSession(true);
                bean.setUserType(type);
                session.setAttribute(AppConstants.SESSION, bean);

                if (type.equals(AppConstants.TYPE_ADMIN)) {
                    response.sendRedirect("admin_home.jsp?login=success");
                } else if (type.equals(AppConstants.TYPE_USER)) {
                    response.sendRedirect("user_home.jsp?login=success");
                } else {
                    response.sendRedirect("login.jsp?login=failed");
                }
            } else {
                response.sendRedirect("login.jsp?login=failed");
            }


        } catch (Exception ex) {
            // TODO Auto-generated catch block
            response.sendRedirect("404.jsp");
            ex.printStackTrace();
        }
    }
}
