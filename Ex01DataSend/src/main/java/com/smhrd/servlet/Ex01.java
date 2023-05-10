package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url-mapping값 : /Es01
@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//요청 데이터 (name = date)값 가져오기
	//getParameter(String -> form의 name값) -> 요청 데이터 가져오기 -> 반환타입 : String	
	String data = request.getParameter("data");	
	System.out.println(data);
	
	//응답 데이터에 (한글은 깨져서 넘어옴-> 한글도 인식 가능하게)인코딩 설정 추가 - 응답 데이터를  UTF-8방식으로 한다는 의미
	response.setCharacterEncoding("UTF-8");// 데이터만 인코딩
	
	//웹브라우저가 한글 인코딩을 할 수 있도록 알려주는 코드를 추가해야함 
	//데이터만 인코딩 하는게 아니라 브라우저도 인코딩 해줘야함
	//-> 브라우저에게 응답데이터의 형식과 인코딩 방식 알려주는 코드
	response.setContentType("text/html; charset=UTF-8");// 브라우저에게 인코딩 방식 알려줌
	
	
	//사용자가 입력한 값 그대로 HTML 문서로 만들어서 응답하기]
	PrintWriter out = response.getWriter();//텍스트 출력 스트림 만들기
	out.print(data);


	
	}

}
