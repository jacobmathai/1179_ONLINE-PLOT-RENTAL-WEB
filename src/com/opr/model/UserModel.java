package com.opr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opr.bean.UserBean;
import com.opr.utils.AppConstants;
import com.opr.utils.SupportMethods;

public class UserModel {
	Connection con = null;

	@SuppressWarnings("resource")
	public String doRegister(UserBean bean) throws SQLException, ClassNotFoundException  {
		String logQuery = "INSERT INTO login_info(username, password, user_type) VALUES(?,?,?)";
		String regQuery = "INSERT INTO user_info(username, name, phone, email, city) VALUES(?,?,?,?,?)";
		PreparedStatement statement =  null;
		try {
		con = new DbConnection().getConnection();
		statement =  con.prepareStatement(logQuery);
		statement.setString(1, bean.getUsername());
		statement.setString(2, bean.getPassword());
		statement.setString(3,AppConstants.TYPE_USER);
		int logUpdate = statement.executeUpdate();
		if(logUpdate > 0){
			con = new DbConnection().getConnection();
			 statement =  con.prepareStatement(regQuery);
			 statement.setString(1, bean.getUsername());
			 statement.setString(2, bean.getName());
			 statement.setString(3, bean.getPhone());
			 statement.setString(4, bean.getEmail());
			 statement.setString(5, bean.getCity());
			 int regUpdate = statement.executeUpdate();
			 if(regUpdate > 0){
				 return AppConstants.TRUE;
			 }
		}
		
		return AppConstants.FALSE;
		} finally {
			SupportMethods.CloseInstance(con, statement);
		}
	}

	public String removeClientAccount(String userId) throws ClassNotFoundException, SQLException {
		PreparedStatement statement = null;
		try {
			String query = "DELETE FROM login_info WHERE username = ?";
			con = new DbConnection().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, userId);
			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				return AppConstants.TRUE;
			}
		} finally {
			SupportMethods.CloseInstance(con, statement);
		}
		return AppConstants.FALSE;
	}

	public String removeTask(String taskId) throws ClassNotFoundException {
		PreparedStatement statement = null;
		String status = "false";
		try {
			String query = "DELETE FROM task_info WHERE task_id = ?";
			con = new DbConnection().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, taskId);

			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				status = "true";
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			SupportMethods.CloseInstance(con, statement);
		}
		return status;
	}

	public boolean setGmcKey(String username, String key) throws ClassNotFoundException {
		PreparedStatement statement = null;
		boolean status = false;
		try {
			String query = "UPDATE user_info SET gcm_key = ? WHERE user_id = ?";
			con = new DbConnection().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, key);
			statement.setString(2, username);
			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				status = true;
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			SupportMethods.CloseInstance(con, statement);
		}
		return status;
	}
}
