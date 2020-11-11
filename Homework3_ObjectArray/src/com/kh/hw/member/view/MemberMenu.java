package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

import com.kh.hw.member.model.vo.*;

public class MemberMenu {
	// 필드부
private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// 생성자부	
	public MemberMenu() {
		
	}
	
	// 메소드부
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("최대 등록 가능한 회원 수는 "+mc.SIZE+"명입니다.");
			System.out.println("현재 등록 된 회원 수는 "+mc.memberNum+"명입니다.");
			if(mc.memberNum != mc.SIZE) {
				System.out.println("1. 새 회원 등록");
			}
			else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
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
			case 9: System.out.println("프로그램을 종료합니다.");
				return;
			default : System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
		
	}
	
	public void insertMember() {
		System.out.println("새 회원을 등록합니다.");
		System.out.print("아이디 : ");
		String id = sc.next();
		if(mc.memberNum > 0) {
			boolean check = mc.checkId(id);
			while(check == true) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
				System.out.print("아이디 : ");
				id = sc.next();
				check = mc.checkId(id);
				if(check != true) {
					break;
				}
				
			}
		}
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		char gender = 'a';
		while(true) {
			System.out.print("성별(M/F) : ");
			gender = sc.next().charAt(0);
			if(gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') {
				break;
			}
			else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}
		System.out.print("나이 : ");
		int age = sc.nextInt();
		mc.insertMember(id, name, password, email, gender, age);
	}
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		switch(select) {
		case 1: searchId();
			break;
		case 2: searchName();
			break;
		case 3: searchEmail();
			break;
		case 9: System.out.println("메인으로 돌아갑니다.");
			return;
		default : System.out.println("잘 못 입력하셨습니다.");
			return;
		}
	}
	public void searchId() {
		if(mc.memberNum > 0) {
			System.out.print("검색할 아이디 : ");
			String id = sc.next();
			id = mc.searchId(id);
			System.out.println("찾으신 회원 검색 결과입니다.");
			System.out.println(id);
		}
		else {
			System.out.println("현재 멤버가 없어 아이디를 검색할 수 없습니다.");
		}
	}
	public void searchName() {
		if(mc.memberNum > 0) {
			System.out.print("검색할 이름 : ");
			String name = sc.next();
			Member[] mb = mc.searchName(name);
			System.out.println("찾으신 회원 검색 결과입니다.");
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
				System.out.println("검색 결과가 없습니다.");
			}
		}
		else {
			System.out.println("현재 멤버가 없어 아이디를 검색할 수 없습니다.");
		}
	}
	public void searchEmail() {
		if(mc.memberNum > 0) {
			System.out.print("검색할 이메일 : ");
			String email = sc.next();
			Member[] mb = mc.searchEmail(email);
			System.out.println("찾으신 회원 검색 결과입니다.");
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
				System.out.println("검색 결과가 없습니다.");
			}
			
		}
		else {
			System.out.println("현재 멤버가 없어 아이디를 검색할 수 없습니다.");
		}
	}
	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		switch(select) {
		case 1: updatePassword();
			break;
		case 2: updateName();
			break;
		case 3: updateEmail();
			break;
		case 9: System.out.println("메인으로 돌아갑니다.");
			return;
		default : System.out.println("잘 못 입력하셨습니다.");
			return;
		}
	}
	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.next();
		boolean checkId = mc.updatePassword(id, password);
		if(checkId == false) {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		else {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
	}
	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		boolean checkId = mc.updateName(id, name);
		if(checkId == false) {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		else {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
	}
	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 이메일 : ");
		String email = sc.next();
		boolean checkId = mc.updateEmail(id, email);
		if(checkId == false) {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		else {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
	}
	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		switch(select) {
		case 1: deleteOne();
			break;
		case 2: deleteAll();
			break;
		case 9: System.out.println("메인으로 돌아갑니다.");
			return;
		default : System.out.println("잘 못 입력하셨습니다.");
			return;
		}
	}
	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String id = sc.next();
		char deleteSelect = ' ';
		while(true) {
			System.out.print("정말 삭제하시겠습니까?(y/n) : ");
			deleteSelect = sc.next().charAt(0);
			if(deleteSelect == 'y' || deleteSelect == 'Y') {
				boolean checkId = mc.delete(id);
				if(checkId == false) {
					System.out.println("존재하지 않는 아이디입니다.");
				}
				else {
					System.out.println("성공적으로 삭제하였습니다.");
				}
				return;
			}
			else if(deleteSelect == 'n' || deleteSelect == 'N') {
				return;
			}
			else {
				System.out.println("다시 입력하세요.");
			}
		}
	}
	public void deleteAll() {
		char deleteSelect = ' ';
		while(true) {
			System.out.print("정말 삭제하시겠습니까?(y/n) : ");
			deleteSelect = sc.next().charAt(0);
			if(deleteSelect == 'y' || deleteSelect == 'Y') {
				mc.delete();
				System.out.println("성공적으로 삭제하였습니다.");
				return;
			}
			else if(deleteSelect == 'n' || deleteSelect == 'N') {
				return;
			}
			else {
				System.out.println("다시 입력하세요.");
			}
		}
	}
	public void printAll() {
		Member[] mb = mc.printAll();
		if(mc.memberNum == 0) {
			System.out.println("저장된 회원이 없습니다.");
		}
		else {
			for(int i = 0; i < mc.memberNum; i++) {
				System.out.println(mb[i].inform());
			}
		}
		
	}
}
