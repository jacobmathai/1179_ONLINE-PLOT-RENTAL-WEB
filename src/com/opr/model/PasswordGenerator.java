/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class PasswordGenerator {

    Connection con = null;

    public String getRandomNumber() throws ClassNotFoundException {
        boolean status = false;
        String number = "";
        do {
            Random random = new Random();
            number = "" + random.nextInt(900000);
            status = isPasswordExists(number);
        } while (status);
        return number;

    }

    private boolean isPasswordExists(String number) throws ClassNotFoundException {
       PreparedStatement statement = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            con = new DbConnection().getConnection();
            String query = "SELECT password FROM login_info WHERE password = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, number);
            rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PasswordGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PasswordGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
    
    public static void main(String[] args) {
		try {
			System.out.println(new PasswordGenerator().getRandomNumber());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
