package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//모든 클래스들은 Command 를 구현해줘야한다 : 기능 호출시 무조건process()메서드를 호출할 수 있도록 강제성 부여
	
	//추상메서드,상수만 입력 가능 
	//String : process 메서드내에 기능 모두 수행한 후 최종적으로 이동해야하는 페이지 경로 
	public String process(HttpServletRequest request,HttpServletResponse response);
	
	
}
