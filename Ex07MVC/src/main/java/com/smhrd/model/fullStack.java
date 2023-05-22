package com.smhrd.model;

// full Stack 데이틀에서 가지고온 학생 데이터를 하나로 묶어 주는 작업
// 갹체 - 학생 한명의 데이터를 의미 ->VO (value object)
//VO : 필드 (테이블 컬럼과 일치,생성자
	public class fullStack {
		
	private String name;
	private String major;
	private String phone;
	
	
	public fullStack(String name, String major, String phone) { 
		
		//생성된 fullStack 객체의 필드롤 DB에서 가지고온 값으로 초기화
		this.name = name;
		this. major = major;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhon(String phone) {
		this.phone = phone;
	}
	}
	