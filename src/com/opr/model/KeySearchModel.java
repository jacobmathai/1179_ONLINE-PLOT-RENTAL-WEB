package com.opr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opr.utils.AppConstants;
import com.opr.utils.SupportMethods;

public class KeySearchModel {
	Connection con = null;



//	// getting userId from task_info table
//	public String getUserId(int taskId) {
//		PreparedStatement statement = null;
//		ResultSet recordSet = null;
//		String userId = "";
//		try {
//			String query = "SELECT user_id FROM task_info WHERE task_id = ?";
//			con = new DbConnection().getConnection();
//			statement = con.prepareStatement(query);
//			statement.setInt(1, taskId);
//			recordSet = statement.executeQuery();
//			if (recordSet.next()) {
//				userId = recordSet.getString("user_id");
//			}
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			SupportMethods.CloseInstance(con, recordSet, statement);
//		}
//		return userId;
//	}
	// getting gcm from user_info table
	public String getGcmKey(String userId) throws ClassNotFoundException {
		PreparedStatement statement = null;
		ResultSet recordSet = null;
		String gcmKey = "";
		try {
			String query = "SELECT gcm_key FROM user_info WHERE user_id = ?";
			con = new DbConnection().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, userId);
			recordSet = statement.executeQuery();
			if (recordSet.next()) {
				gcmKey = recordSet.getString("gcm_key");
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			SupportMethods.CloseInstance(con, recordSet, statement);
		}
		return gcmKey;
	}
//
//	// getting taskId from task_info table
//	public int getTaskId(String userId) {
//		PreparedStatement statement = null;
//		ResultSet recordSet = null;
//		int taskId = 0;
//		try {
//			String query = "SELECT task_id FROM task_info WHERE user_id = ?";
//			con = new DbConnection().getConnection();
//			statement = con.prepareStatement(query);
//			statement.setString(1, userId);
//			recordSet = statement.executeQuery();
//			if (recordSet.next()) {
//				taskId = recordSet.getInt("task_id");
//			}
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			SupportMethods.CloseInstance(con, recordSet, statement);
//		}
//		return taskId;
//	}
//
//	// getting det_id from sim_detect_info table
//	public ArrayList<Integer> getDetectionId() {
//		PreparedStatement statement = null;
//		ResultSet recordSet = null;
//		ArrayList<Integer> detectionList = new ArrayList<>();
//		try {
//			String query = "SELECT det_id FROM sim_detect_info WHERE status = ?";
//			con = new DbConnection().getConnection();
//			statement = con.prepareStatement(query);
//			statement.setString(1, AppConstants.UN_CHECKED);
//			recordSet = statement.executeQuery();
//			while (recordSet.next()) {
//				detectionList.add(recordSet.getInt("det_id"));
//			}
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			SupportMethods.CloseInstance(con, recordSet, statement);
//		}
//		return detectionList;
//	}

}
