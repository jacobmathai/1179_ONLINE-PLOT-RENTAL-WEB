package com.opr.bean;

public class LoginBean {
	private String username = "";
	private String password = "";
	private String userType = "";
	private String gcmKey = "";
	

	public String getGcmKey() {
		return gcmKey;
	}

	public void setGcmKey(String gcmKey) {
		this.gcmKey = gcmKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
