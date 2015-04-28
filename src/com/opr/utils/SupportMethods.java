
package com.opr.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sujith
 */
public class SupportMethods {

   
    public static void CloseInstance(Connection con, PreparedStatement statement) {
        try {

            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void CloseInstance(Connection con, ResultSet resultSet, PreparedStatement statement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getSystemDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_FORMAT);
        String date = sdf.format(new Date());
        return date;
    }

    public static String getSystemTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.TIME_FORMAT);
        String time = sdf.format(new Date().getTime());
        return time;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.TIME_FORMAT);
        String time = sdf.format(new Date().getTime());
        System.out.println("Time :" + time);
    }
}
