package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

import com.kh.hw.member.model.vo.*;

public class MemberMenu {
	// �ʵ��
private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// �����ں�	
	public MemberMenu() {
		
	}
	
	// �޼ҵ��
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("�ִ� ��� ������ ȸ�� ���� "+mc.SIZE+"���Դϴ�.");
			System.out.println("���� ��� �� ȸ�� ���� "+mc.memberNum+"���Դϴ�.");
			if(mc.memberNum != mc.SIZE) {
				System.out.println("1. �� ȸ�� ���");
			}
			else {
				System.out.println("ȸ�� ���� ��� �� á�� ������ �Ϻ� �޴��� ���µ˴ϴ�.");
			}
			System.out.println("2. ȸ�� �˻�");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ��� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int select = sc.nextInt();
			switch(select) {
			case 1: insertMember();
				break;
			case 2: searchMember();
				break;
			case 3: updateMember();
				break;
			case 4: deleteMember();
				break;
			case 5: printAll();
				break;
			case 9: System.out.println("���α׷��� �����մϴ�.");
				return;
			default : System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			
		}
		
	}
	
	public void insertMember() {
		System.out.println("�� ȸ���� ����մϴ�.");
		System.out.print("���̵� : ");
		String id = sc.next();
		if(mc.memberNum > 0) {
			boolean check = mc.checkId(id);
			while(check == true) {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
				System.out.print("���̵� : ");
				id = sc.next();
				check = mc.checkId(id);
				if(check != true) {
					break;
				}
				
			}
		}
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		System.out.print("�̸��� : ");
		String email = sc.next();
		char gender = 'a';
		while(true) {
			System.out.print("����(M/F) : ");
			gender = sc.next().charAt(0);
			if(gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') {
				break;
			}
			else {
				System.out.println("������ �ٽ� �Է��ϼ���.");
			}
		}
		System.out.print("���� : ");
		int age = sc.nextInt();
		mc.insertMember(id, name, password, email, gender, age);
	}
	public void searchMember() {
		System.out.println("1. ���̵�� �˻��ϱ�");
		System.out.println("2. �̸����� �˻��ϱ�");
		System.out.println("3. �̸��Ϸ� �˻��ϱ�");
		System.out.println("9. �������� ���ư���");
		System.out.print("�޴� ��ȣ : ");
		int select = sc.nextInt();
		switch(select) {
		case 1: searchId();
			break;
		case 2: searchName();
			break;
		case 3: searchEmail();
			break;
		case 9: System.out.println("�������� ���ư��ϴ�.");
			return;
		default : System.out.println("�� �� �Է��ϼ̽��ϴ�.");
			return;
		}
	}
	public void searchId() {
		if(mc.memberNum > 0) {
			System.out.print("�˻��� ���̵� : ");
			String id = sc.next();
			id = mc.searchId(id);
			System.out.println("ã���� ȸ�� �˻� ����Դϴ�.");
			System.out.println(id);
		}
		else {
			System.out.println("���� ����� ���� ���̵� �˻��� �� �����ϴ�.");
		}
	}
	public void searchName() {
		if(mc.memberNum > 0) {
			System.out.print("�˻��� �̸� : ");
			String name = sc.next();
			Member[] mb = mc.searchName(name);
			System.out.println("ã���� ȸ�� �˻� ����Դϴ�.");
			int count = 0;
			for(int i = 0; i < mb.length; i++) {
				if(mb[i] == null) {
					continue;
				}
				else {
					System.out.println(mb[i].inform());
					count++;
				}
			}
			if(count == 0) {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		}
		else {
			System.out.println("���� ����� ���� ���̵� �˻��� �� �����ϴ�.");
		}
	}
	public void searchEmail() {
		if(mc.memberNum > 0) {
			System.out.print("�˻��� �̸��� : ");
			String email = sc.next();
			Member[] mb = mc.searchEmail(email);
			System.out.println("ã���� ȸ�� �˻� ����Դϴ�.");
			int count = 0;
			for(int i = 0; i < mb.length; i++) {
				if(mb[i] == null) {
					continue;
				}
				else {
					System.out.println(mb[i].inform());
					count++;
				}
			}
			if(count == 0) {
				System.out.println("�˻� ����� �����ϴ�.");
			}
			
		}
		else {
			System.out.println("���� ����� ���� ���̵� �˻��� �� �����ϴ�.");
		}
	}
	public void updateMember() {
		System.out.println("1. ��й�ȣ �����ϱ�");
		System.out.println("2. �̸� �����ϱ�");
		System.out.println("3. �̸��� �����ϱ�");
		System.out.println("9. �������� ���ư���");
		System.out.print("�޴� ��ȣ : ");
		int select = sc.nextInt();
		switch(select) {
		case 1: updatePassword();
			break;
		case 2: updateName();
			break;
		case 3: updateEmail();
			break;
		case 9: System.out.println("�������� ���ư��ϴ�.");
			return;
		default : System.out.println("�� �� �Է��ϼ̽��ϴ�.");
			return;
		}
	}
	public void updatePassword() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.next();
		System.out.print("������ ��й�ȣ : ");
		String password = sc.next();
		boolean checkId = mc.updatePassword(id, password);
		if(checkId == false) {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
		else {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		}
	}
	public void updateName() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.next();
		System.out.print("������ �̸� : ");
		String name = sc.next();
		boolean checkId = mc.updateName(id, name);
		if(checkId == false) {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
		else {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		}
	}
	public void updateEmail() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.next();
		System.out.print("������ �̸��� : ");
		String email = sc.next();
		boolean checkId = mc.updateEmail(id, email);
		if(checkId == false) {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
		else {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		}
	}
	public void deleteMember() {
		System.out.println("1. Ư�� ȸ�� �����ϱ�");
		System.out.println("2. ��� ȸ�� �����ϱ�");
		System.out.println("9. �������� ���ư���");
		System.out.print("�޴� ��ȣ : ");
		int select = sc.nextInt();
		switch(select) {
		case 1: deleteOne();
			break;
		case 2: deleteAll();
			break;
		case 9: System.out.println("�������� ���ư��ϴ�.");
			return;
		default : System.out.println("�� �� �Է��ϼ̽��ϴ�.");
			return;
		}
	}
	public void deleteOne() {
		System.out.print("������ ȸ���� ���̵� : ");
		String id = sc.next();
		char deleteSelect = ' ';
		while(true) {
			System.out.print("���� �����Ͻðڽ��ϱ�?(y/n) : ");
			deleteSelect = sc.next().charAt(0);
			if(deleteSelect == 'y' || deleteSelect == 'Y') {
				boolean checkId = mc.delete(id);
				if(checkId == false) {
					System.out.println("�������� �ʴ� ���̵��Դϴ�.");
				}
				else {
					System.out.println("���������� �����Ͽ����ϴ�.");
				}
				return;
			}
			else if(deleteSelect == 'n' || deleteSelect == 'N') {
				return;
			}
			else {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
	public void deleteAll() {
		char deleteSelect = ' ';
		while(true) {
			System.out.print("���� �����Ͻðڽ��ϱ�?(y/n) : ");
			deleteSelect = sc.next().charAt(0);
			if(deleteSelect == 'y' || deleteSelect == 'Y') {
				mc.delete();
				System.out.println("���������� �����Ͽ����ϴ�.");
				return;
			}
			else if(deleteSelect == 'n' || deleteSelect == 'N') {
				return;
			}
			else {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
	public void printAll() {
		Member[] mb = mc.printAll();
		if(mc.memberNum == 0) {
			System.out.println("����� ȸ���� �����ϴ�.");
		}
		else {
			for(int i = 0; i < mc.memberNum; i++) {
				System.out.println(mb[i].inform());
			}
		}
		
	}
}
