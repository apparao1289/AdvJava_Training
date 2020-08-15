package com.test.bean;

import java.io.Serializable;

public class Student implements Serializable {

	private String name;

	private String age;

	private String address;

	private String stand;
	
	public Student() {
		System.out.println("Student constuructor invoking...");
	}

	public String getName() {
		System.out.println("getting name::"+name);
		return name;
	}

	public void setName(String name) {
		System.out.println("setting name::"+name);
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

}
