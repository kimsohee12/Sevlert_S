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
		//GET/POST 한글 인코딩 방식
		//1) : POST : 패킷의 body에 실어져서 전송됨
		//			-> 패킷이 넘어올때마다(요청이 들어올때마다) 인코딩 방식을 지정해줘야함
		
		request.setCharacterEncoding("UTF-8");// POST 방식 사용할떄는 꼭 써줘야 한글 가능
		//
		
		String name = request.getParameter("name");
		//request.setCharacterEncoding("UTF-8"); 사용 x 
		//-> parameter 를 받기 이전에 사용해줘야 실행 순서 맞게 실행 가능
		
		//GET : URL에 실어져서 전송
		//		-> URI를 인코등 해줘야함
		//		->server (Tomcat9) /(server.xml -> URIEncoding =UTF-8 지정
		
		System.out.println(name);
		
		response.setContentType("text/html; charset=UTF-8");//응답데이터 형식 (인코딩방식)지정
		
		PrintWriter out = response.getWriter();//텍스트 출력 스트링
		
		out.print(name); //스트림을 통해 텍스트 출력
		
		
	}

}
