package io.lrx.user.domain;

/**
 * @author lrx
 * @time 2016-10-30ÏÂÎç10:05:24
 */
public class User {
	private String username;
	private String password;
	private String verifycode;

	public String getVerifyCode() {
		return verifycode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifycode = verifyCode;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", verifyCode=" + verifycode + "]";
	}

}
