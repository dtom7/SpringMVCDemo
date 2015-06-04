package com.example.springmvc.domain;

public class LoginService {
	private String userId;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isValid() {
		return getUserId().equals(getUserId());
	}
}
