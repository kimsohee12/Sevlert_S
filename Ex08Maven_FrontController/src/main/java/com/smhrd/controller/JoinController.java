package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MyMember;
import com.smhrd.model.MyMemberDAO;

public class JoinController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		//요청 데이터 인코딩 방식 지정
		//UnsupportedEncodingException
		String url = "";
				try {
					request.setCharacterEncoding("UTF-8");
					//id , pw , nick -> DB랑 타입 맞춰넣으면 됨
					String id = request.getParameter("id");
					String pw = request.getParameter("pw");
					String nick = request.getParameter("nick");
					
					//MaBstis -> 따로따로 가져오면 x 하나로 묶어서 가져와야 함
					
					MyMember member = new MyMember(id,pw,nick);
					
					//데이터베이스 연동 -> 값 넣어주기! (MyBatis 활용)
					MyMemberDAO dao = new MyMemberDAO(); //SqlSessionFactory 생성
					int cnt = dao.join(member);//회원가입 기능
					
					if(cnt > 0) { //회원가입 성공
						System.out.println("회원가입 성공");
						url ="index.jsp";
					}else { //회원가입 실패
						System.out.println("회원가입 실패");
						url ="join.html";
						
					}
				}catch(UnsupportedEncodingException e){
					System.out.println("인코딩 방식 잘못지정함");
					
					
				}catch(IOException e) {
					System.out.println("redirect 경로 잘못지정함");
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				return url;
	}

}
