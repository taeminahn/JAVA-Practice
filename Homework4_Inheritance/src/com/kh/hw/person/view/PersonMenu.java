package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	// �ʵ��
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController(); 
	// �����ں�
	// �޼����
	public void mainMenu() {
		while(true) {
			System.out.println("�л��� �ִ� "+pc.STUDENTMAXNUM+"����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� �л��� "+pc.person[0]+"�� �Դϴ�.");
			System.out.println("����� �ִ� "+pc.EMPLOYEEMAXNUM+"����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� ����� "+pc.person[1]+"�� �Դϴ�.");
			System.out.println("\n1. �л� �޴�");
			System.out.println("2. ��� �޴�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int select = sc.nextInt();
			switch(select) {
			case 1:	studentMenu();
				break;
			case 2:	employeeMenu();
				break;
			case 9: System.out.println("�����մϴ�.");
				return;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}
	public void studentMenu() {
		while(true) {
			System.out.println("\n1. �л� �߰�");
			System.out.println("2. �л� ����");
			System.out.println("9. ��������");
			if(pc.person[0] == pc.STUDENTMAXNUM) {
				System.out.print("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰� �޴��� �� �̻� Ȱ��ȭ ���� �ʽ��ϴ�\n");
			}
			System.out.print("�޴� ��ȣ : ");
			int select = sc.nextInt();
			if(pc.person[0] == pc.STUDENTMAXNUM) {
				switch(select) {
				case 2:	printStudent();
					break;
				case 9: System.out.println("�������� ���ư��ϴ�.\n");
					return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
				case 9: System.out.println("�������� ���ư��ϴ�.\n");
					return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				}
			}
			
		}
	}
	public void employeeMenu() {
		while(true) {
			System.out.println("\n1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("9. ��������");
			if(pc.person[1] == pc.EMPLOYEEMAXNUM) {
				System.out.print("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰� �޴��� �� �̻� Ȱ��ȭ ���� �ʽ��ϴ�\n");
			}
			System.out.print("�޴� ��ȣ : ");
			int select = sc.nextInt();
			if(pc.person[1] == pc.EMPLOYEEMAXNUM) {
				switch(select) {
				case 2:	printEmployee();
					break;
				case 9: System.out.println("�������� ���ư��ϴ�.\n");
					return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
				case 9: System.out.println("�������� ���ư��ϴ�.\n");
					return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				}
			}
			
		}
	}
	public void insertStudent() {
		System.out.println();
		while(true) {
			System.out.print("�л� �̸� : ");
			String name = sc.next();
			System.out.print("�л� ���� : ");
			int age = sc.nextInt();
			System.out.print("�л� Ű : ");
			double height = sc.nextDouble();
			System.out.print("�л� ������ : ");
			double weight = sc.nextDouble();
			System.out.print("�л� �г� : ");
			int grade = sc.nextInt();
			System.out.print("�л� ���� : ");
			String major = sc.next();
			pc.insertStudent(name, age, height, weight, grade, major);
			if(pc.person[0] == pc.STUDENTMAXNUM) {
				System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰��� �����ϰ� �л��޴��� ���ư��ϴ�");
				return;
			}
			System.out.print("�׸� �Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
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
			System.out.print("��� �̸� : ");
			String name = sc.next();
			System.out.print("��� ���� : ");
			int age = sc.nextInt();
			System.out.print("��� Ű : ");
			double height = sc.nextDouble();
			System.out.print("��� ������ : ");
			double weight = sc.nextDouble();
			System.out.print("��� �޿� : ");
			int salary = sc.nextInt();
			System.out.print("��� �μ� : ");
			String dept = sc.next();
			pc.insertEmployee(name, age, height, weight, salary, dept);
			if(pc.person[1] == pc.EMPLOYEEMAXNUM) {
				System.out.println("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰��� �����ϰ� ����޴��� ���ư��ϴ�");
				return;
			}
			System.out.print("�׸� �Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
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
