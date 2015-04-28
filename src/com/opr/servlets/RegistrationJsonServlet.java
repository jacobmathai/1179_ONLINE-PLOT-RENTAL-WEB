package com.opr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;




import com.opr.bean.UserBean;
import com.opr.model.UserModel;

/**
 * Servlet implementation class RegistrationJsonServlet
 */
@WebServlet("/RegistrationJsonServlet")
public class RegistrationJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String json = request.getParameter("json");
		JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
		
		UserBean bean = new UserBean();
		bean.setName(jsonObject.get("name").toString());
		bean.setUsername(jsonObject.get("username").toString());
		bean.setPassword(jsonObject.get("password").toString());
		bean.setPhone(jsonObject.get("phone").toString());
		bean.setEmail(jsonObject.get("email").toString());
		bean.setCity(jsonObject.get("city").toString());
		
		JSONObject statusObj = new JSONObject();
		try {
		String status = new UserModel().doRegister(bean);
		statusObj.put("message", status);
		out.println(JSONObject.toJSONString(statusObj));
		
		} catch(SQLException ex){
			statusObj.put("message", "false");
			out.println(JSONObject.toJSONString(statusObj));
			//response.sendRedirect("index.jsp");
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			statusObj.put("message", "false");
			out.println(JSONObject.toJSONString(statusObj));
			//response.sendRedirect("index.jsp");
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
