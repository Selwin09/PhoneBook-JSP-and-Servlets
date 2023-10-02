package com.entity;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String phno;
	private int userId;
	public Contact() {
		super();
	}
	public Contact(String name, String email, String phno, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	



}
