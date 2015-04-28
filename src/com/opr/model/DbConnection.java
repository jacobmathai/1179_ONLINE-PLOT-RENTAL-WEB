package com.opr.model;

import com.opr.utils.AppConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

	Connection con = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

			if (con == null) {
				con = createConnection();
			}
			return con;
		
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
			Class.forName(AppConstants.DRIVER_URL);
			connection = DriverManager.getConnection(AppConstants.DB_URL,
					AppConstants.USERNAME, AppConstants.PASSWORD);
		
		return connection;

	}
}
