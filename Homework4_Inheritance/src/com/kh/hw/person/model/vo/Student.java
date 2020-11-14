package com.kh.hw.person.model.vo;

public class Student extends Person{
	// 필드부
	private int grade;
	private String major;
	// 생성자부
	public Student() {
		
	}
	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(name, age, height, weight);
//		setName(name);
//		setAge(age);
//		setHeight(height);
//		setWeight(weight);
		this.grade = grade;
		this.major = major;
	}
	// 메서드부
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String toString() {
		return super.toString()+", "+grade+", "+major;
	}
}
