package com.bdd.bddscenario.model;

public class UserLogin {
	private String userName;
	private String password;
	private Boolean authentication;

	public String getUserName() {
		return userName;
	}

	public UserLogin(String userName, String password, Boolean authentication) {
		super();
		this.userName = userName;
		this.password = password;
		this.authentication = authentication;
	}

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Boolean authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "UserLogin [userName=" + userName + ", password=" + password + ", authentication=" + authentication
				+ "]";
	}

}
