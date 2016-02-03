package com.barban.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JTableUser {

	
	private int id;
	private String name;
	private String login;
	private String email;
	private String password;
	
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "JTableUser [id=" + id + ", name=" + name + ", login=" + login + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}

//wget -q -O - http://pkg.jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -vi /etc/apt/sources
