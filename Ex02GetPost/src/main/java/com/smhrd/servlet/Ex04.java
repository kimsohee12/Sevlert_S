package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 인코딩 추가
		request.setCharacterEncoding("UTF-8");
		//요청 데이터값 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwCheck = request.getParameter("pwCheck");
		String Gender = request.getParameter("Gender");
		String blood = request.getParameter("blood");
		String date = request.getParameter("date");
		String[] hobby = request.getParameterValues("hobby"); 
		String color = request.getParameter("color");
		String text = request.getParameter("text");
		//브라우저 인코딩 추가
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();//텍스트 출력 스트링
		
		//출력
		out.print("아이디 : "+id + "<br>");
		out.print("비밀번호 : " + pw+ "<br>");
		//비밀번호 확인
		if(pw.equals(pwCheck)) {
			out.print("비밀번호가 일치합니다 "+ "<br>");
		}else {
			out.print("비밀번호가 일치하지 않습니다 "+ "<br>");
		}
		out.print("성별 : " + Gender+ "<br>");
		out.print("혈액형 : " + blood+ "<br>");
		out.print("생일 : " + date+ "<br>");
		out.print("취미 : " + Arrays.toString(hobby)+ "<br>");
		out.print("좋아하는 색 : " + color+ "<br>");
	
		out.print("남기고 싶은 말 : " + text+ "<br>");
	
		
		
		
		
		
	}

}
