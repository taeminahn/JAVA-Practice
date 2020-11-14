package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	// 필드부
	private Student[] s = new Student[STUDENTMAXNUM];
	private Employee[] e = new Employee[EMPLOYEEMAXNUM];
	public static final int EMPLOYEEMAXNUM = 3;
	public static final int STUDENTMAXNUM = 3;
	public static int[] person = new int[2]; //인덱스 0 : 학생 / 1 : 종업원 
	// 생성자부
	// 메서드부
	public int[] personCount() {
		for(int i = 0; i < s.length; i++) {
			if(s[i] != null) {
				person[0] = i+1;
			}
		}
		for(int i = 0; i < e.length; i++) {
			if(e[i] != null) {
				person[1] = i+1;
			}
		}
		return person;
	}
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		s[person[0]] = new Student(name, age, height, weight, grade, major); 
		personCount();
	}
	public Student[] printStudent() {
		
		return s;
	}
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		e[person[1]] = new Employee(name, age, height, weight, salary, dept);
		personCount();
	}
	public Employee[] printEmployee() {
		
		return e;
	}
}
