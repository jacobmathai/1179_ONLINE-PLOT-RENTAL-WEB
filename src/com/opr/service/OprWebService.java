/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.service;

import com.opr.bean.LoginBean;
import com.opr.bean.UserBean;
import com.opr.model.PropertyModel;
import com.opr.model.SearchModel;
import com.opr.model.UserModel;
import com.opr.utils.AppConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "OprWebService")
public class OprWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "doLogin")
    public String doLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        try {
            if (AppConstants.DEBUG) {
                System.out.println("UserName: " + username);
                System.out.println("Password: " + password);
            }
            LoginBean bean = new LoginBean();
            bean.setUsername(username);
            bean.setPassword(password);
            String status = new SearchModel().checkLogin(bean);
            if (status.equals(AppConstants.TYPE_USER)) {
                return AppConstants.TRUE;
            }
            if (AppConstants.DEBUG) {
                System.out.println("Status--> " + status);
            }
        } catch (Exception ex) {
        }
        return AppConstants.FALSE;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateGcmKey")
    public String updateGcmKey(@WebParam(name = "username") String username, @WebParam(name = "key") String key) {
        String response = "";
        try {
            //TODO write your implementation code here:
            System.out.println("Username " + username);
            System.out.println("Key " + key);
            response = new PropertyModel().updateGcmKey(username, key);
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return response;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "doRegister")
    public String doRegister(@WebParam(name = "regParam") String regParam) {
        try {
            if (AppConstants.DEBUG) {
                System.out.println("regJson: " + regParam);
            }

            JSONObject regJSON = (JSONObject) JSONValue.parse(regParam);
            String userExist = new SearchModel().isUserExist(regJSON.get("username").toString());
            if (!userExist.equals(AppConstants.TRUE)) {
                UserBean bean = new UserBean();
                bean.setUsername(regJSON.get("username").toString());
                bean.setPassword(regJSON.get("password").toString());
                bean.setName(regJSON.get("name").toString());
                bean.setPhone(regJSON.get("phone").toString());
                bean.setEmail(regJSON.get("email").toString());
                bean.setCity(regJSON.get("city").toString());
                String regStatus = new UserModel().doRegister(bean);
                return regStatus;
            } else {
                return AppConstants.USER_EXIST;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OprWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AppConstants.FALSE;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bookProperty")
    public String bookProperty(@WebParam(name = "propertyId") String propertyId, @WebParam(name = "username") String username) {
        String status = "";
        try {
            if (AppConstants.DEBUG) {
                System.out.println("PropertyId: " + propertyId + " Username: " + username);
            }

            status = new PropertyModel().doBook(propertyId, username);
            if (AppConstants.DEBUG) {
                System.out.println("Status: " + status);
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return status;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addProperty")
    public String addProperty(@WebParam(name = "propertyJson") String propertyJson) {
        try {
            if (AppConstants.DEBUG) {
                System.out.println("Property: " + propertyJson);
            }
            
            JSONObject propertyJsonObj = (JSONObject) new JSONParser().parse(propertyJson);
            new PropertyModel().addPropertyInfo(propertyJsonObj);
            String propId = new PropertyModel().addPropertyInfo(propertyJsonObj);
             if (AppConstants.DEBUG) {
                System.out.println("Property Id : " + propId);
            }
            return propId;
        } catch (SQLException | ClassNotFoundException | IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
