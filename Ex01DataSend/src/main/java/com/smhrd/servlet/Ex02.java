package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 데이터값 가져오기
		String number = request.getParameter("number");	
		System.out.println(number);
		
		//응답 데이터 인코딩 추가
		response.setCharacterEncoding("UTF-8");//
		
		//웹브라우저 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		//사용자가 입력한값 HTML문서로 응답
		PrintWriter out = response.getWriter();
		out.print("입력한 숫자는 "+"<b>"+number+"</b>"+" 입니다");
	
	}

}
