package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	// 필드부
	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	public static int memberNum = 0;
	// 생성자부
	
	// 메서드부
	public int existMemberNum() {
		memberNum += 1;
		return memberNum;
	}
	public Boolean checkId(String inputId) {
		boolean check = false;
		for(int i = 0; i < memberNum; i++) {
			String id = m[i].getId();
			if(id.equals(inputId)) {
				check = true;
				break;
			}
		}
		return check;
	}
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		m[memberNum] = new Member(id,name,password,email,gender,age);
		existMemberNum();
	}
	public String searchId(String id) {
		String searchId = "";
		for(int i = 0; i < memberNum; i++) {
			searchId = m[i].getId();
			if(id.equals(searchId)) {
				searchId = m[i].inform();
				break;
			}
			else {
				searchId = "검색 결과가 없습니다.";
			}
		}
		return searchId;
	}
	public Member[] searchName(String name) {
		Member[] mArr = new Member[memberNum];
		int count = 0;
		for(int i = 0; i < memberNum; i++) {
			if(name.equals(m[i].getName())) {
				mArr[count] = m[i];
				count++;
			}
		}
		return mArr;
	}

	public Member[] searchEmail(String email) {
		Member[] mArr = new Member[memberNum];
		int count = 0;
		for(int i = 0; i < memberNum; i++) {
			if(email.equals(m[i].getEmail())) {
				mArr[count] = m[i];
				count++;
			}
		}
		return mArr;
	}
	public Boolean updatePassword(String id, String password) {
		boolean checkId = false;
		for(int i = 0; i < memberNum; i++) {
			if(id.equals(m[i].getId())) {
				m[i].setPassword(password);
				checkId = true;
				break;
			}
		}
		return checkId;
	}
	public Boolean updateName(String id, String name) {
		boolean checkId = false;
		for(int i = 0; i < memberNum; i++) {
			if(id.equals(m[i].getId())) {
				m[i].setName(name);
				checkId = true;
				break;
			}
		}
		return checkId;
	}
	public Boolean updateEmail(String id, String email) {
		boolean checkId = false;
		for(int i = 0; i < memberNum; i++) {
			if(id.equals(m[i].getId())) {
				m[i].setEmail(email);
				checkId = true;
				break;
			}
		}
		return checkId;
	}
	public Boolean delete(String id) {
		boolean checkId = false;
		for(int i = 0; i < memberNum; i++) {
			if(id.equals(m[i].getId())) {
				memberNum--;
				Member[] mClone = new Member[memberNum]; 
				for(int j = 0; j < memberNum; j++) {
					if(j == i) {
						i++;
						mClone[j] = m[i];
						m[i] = null;
					}
					else {
						mClone[j] = m[j];
						m[j] = null;
					}
				}
//				Member[] m = new Member[SIZE];
//				for(int j = 0; j < memberNum; j++) {
//					m[j] = mClone[j];
//				}
				m = mClone.clone();
				checkId = true;
				break;
			}
			else {
				continue;
			}
		}
		return checkId;
	}
	public void delete() {
		for(int i = 0; i < memberNum; i++) {
			m[i] = null;
		}
		memberNum = 0;
	}
	public Member[] printAll() {
		
		return m;
	}
	
}
