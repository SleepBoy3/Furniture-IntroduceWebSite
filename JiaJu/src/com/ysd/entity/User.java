package com.ysd.entity;

public class User {
	private int aid;
	private String name;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int aid, String name, String password) {
		super();
		this.aid = aid;
		this.name = name;
		this.password = password;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
