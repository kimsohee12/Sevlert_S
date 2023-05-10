package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청데이터 2개 (name = num1,num2)받기
		String num1 = request.getParameter("num1");
		
		//String ->int(정수형) 변환
		//Integer -> int(정수형)의 클래스 타입 -> 기능 (메서드)
		//parseInt(String) :  문자열 -> 정수형으로 변환(숫자 변환 가능한 문자열 입력 해야함)
		int int_num1 = Integer.parseInt(num1);
		
		int int_num2 = Integer.parseInt( request.getParameter("num2"));

		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(int_num1 + " + "+int_num2 + " = "+(int_num1+int_num2));
		
		
		
		
	}

}
