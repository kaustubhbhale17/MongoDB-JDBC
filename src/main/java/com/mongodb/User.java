package com.mongodb;

public class User {
	private String id;
	private String fname;
	private int age;
	private String city;
	
	public User(String fname, int age, String city) {
		super();
		
		this.fname = fname;
		this.age = age;
		this.city = city;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
