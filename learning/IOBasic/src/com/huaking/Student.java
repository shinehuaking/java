package com.huaking;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int age;
	private int sex;
	
	public Student(String name, int age, int sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return this.name + "," + this.age + "," + this.sex;
	}
	
	
}
