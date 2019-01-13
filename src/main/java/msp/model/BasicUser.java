package msp.model;

public class BasicUser {
	
	private String username;
	private String email;
	private String password;
	private String encode;
	
	public BasicUser() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEncode() {
		return this.encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}
	
	

}
