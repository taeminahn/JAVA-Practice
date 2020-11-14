package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	// 필드부
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController(); 
	// 생성자부
	// 메서드부
	public void mainMenu() {
		while(true) {
			System.out.println("학생은 최대 "+pc.STUDENTMAXNUM+"명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+pc.person[0]+"명 입니다.");
			System.out.println("사원은 최대 "+pc.EMPLOYEEMAXNUM+"명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+pc.person[1]+"명 입니다.");
			System.out.println("\n1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			switch(select) {
			case 1:	studentMenu();
				break;
			case 2:	employeeMenu();
				break;
			case 9: System.out.println("종료합니다.");
				return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	public void studentMenu() {
		while(true) {
			System.out.println("\n1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			if(pc.person[0] == pc.STUDENTMAXNUM) {
				System.out.print("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다\n");
			}
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			if(pc.person[0] == pc.STUDENTMAXNUM) {
				switch(select) {
				case 2:	printStudent();
					break;
				case 9: System.out.println("메인으로 돌아갑니다.\n");
					return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
			else {
				switch(select) {
				case 1:	insertStudent();
				if(pc.person[0] == pc.STUDENTMAXNUM) {
					break;
				}
					return;
				case 2:	printStudent();
					break;
				case 9: System.out.println("메인으로 돌아갑니다.\n");
					return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
			
		}
	}
	public void employeeMenu() {
		while(true) {
			System.out.println("\n1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			if(pc.person[1] == pc.EMPLOYEEMAXNUM) {
				System.out.print("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상 활성화 되지 않습니다\n");
			}
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			if(pc.person[1] == pc.EMPLOYEEMAXNUM) {
				switch(select) {
				case 2:	printEmployee();
					break;
				case 9: System.out.println("메인으로 돌아갑니다.\n");
					return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
			else {
				switch(select) {
				case 1:	insertEmployee();
				if(pc.person[1] == pc.STUDENTMAXNUM) {
					break;
				}
					return;
				case 2:	printEmployee();
					break;
				case 9: System.out.println("메인으로 돌아갑니다.\n");
					return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
			
		}
	}
	public void insertStudent() {
		System.out.println();
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.next();
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			System.out.print("학생 전공 : ");
			String major = sc.next();
			pc.insertStudent(name, age, height, weight, grade, major);
			if(pc.person[0] == pc.STUDENTMAXNUM) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생메뉴로 돌아갑니다");
				return;
			}
			System.out.print("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char select = sc.next().charAt(0);
			switch(select) {
				case 'n':
				case 'N':
					System.out.println();
					return;
				default :
					break;
			}
		}
	}
	public void printStudent() {
		System.out.println();
		Student[] st = pc.printStudent();
		for(int i = 0; i < pc.person[0]; i++) {
			System.out.println(st[i]);
		}
	}
	public void insertEmployee() {
		System.out.println();
		while(true) {
			System.out.print("사원 이름 : ");
			String name = sc.next();
			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			System.out.print("사원 키 : ");
			double height = sc.nextDouble();
			System.out.print("사원 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			System.out.print("사원 부서 : ");
			String dept = sc.next();
			pc.insertEmployee(name, age, height, weight, salary, dept);
			if(pc.person[1] == pc.EMPLOYEEMAXNUM) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원메뉴로 돌아갑니다");
				return;
			}
			System.out.print("그만 하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char select = sc.next().charAt(0);
			switch(select) {
				case 'n':
				case 'N':
					System.out.println();
					return;
				default :
					break;
			}
		}
	}
	public void printEmployee() {
		System.out.println();
		Employee[] st = pc.printEmployee();
		for(int i = 0; i < pc.person[1]; i++) {
			System.out.println(st[i]);
		}
	}
}
