package com.leodsc.blog.model;

public class UsuarioLogin {

	private Long id;

	private String username;

	private String password;

	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password= password;
	}
	
}
