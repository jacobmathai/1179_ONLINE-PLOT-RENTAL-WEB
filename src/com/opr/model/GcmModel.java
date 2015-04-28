/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.model;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.opr.bean.PropertyBean;
import com.opr.utils.AppConstants;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class GcmModel {

    public boolean sendSms(String empId, String message) throws ClassNotFoundException {
        boolean status = true;
        try {
            Sender sender = null;
            sender = new Sender("app id");
            Message m = new Message.Builder().addData("ALERT", message).build();
            Result send = sender.send(m, new KeySearchModel().getGcmKey(empId), 5);
            if (AppConstants.DEBUG) {
                System.out.println("GCM status for " + empId + ": " + send);
            }
        } catch (IOException ex) {
            status = false;
            Logger.getLogger(GcmModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void sendGcm(String propId) throws SQLException, ClassNotFoundException, IOException {
        Sender sender = null;
        ArrayList<String> keyList = new SearchModel().getAllGcmKeys();

        for (String gcm_Key : keyList) {
            sender = new Sender(AppConstants.GCM_KEY);
            Result send = null;
            Message m = new Message.Builder().addData("TEST", propId).build();
            send = sender.send(m, gcm_Key, 5);
            if (AppConstants.DEBUG) {
                System.out.println("result" + send.toString());
            }

        }
    }

    public static void main(String[] args) {
        try {
            Sender sender = null;
            sender = new Sender(AppConstants.GCM_KEY);
            Message m = new Message.Builder().addData("alert", "test message").build();
            Result send = sender.send(m, "APA91bE91YJyv4yOBn2qGNS-jXmYdkVM9RUSmJG27UAk2Lsrf7T3ED9hm7vVBrOD3FQUI1rrWpEdYENxddXDRyaM33Gtup4QZ9XVhY02T6-IQShEwDKw-b1A9SSllOjNQODuMlHltCYX_KHgpyBZmWS-51rsIPOS5g", 5);
            if (AppConstants.DEBUG) {
                System.out.println("GCM status for test: " + send);




            }
        } catch (IOException ex) {
            Logger.getLogger(GcmModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
