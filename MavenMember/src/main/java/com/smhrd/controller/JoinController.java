package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMemberDAO;
import com.smhrd.model.WebMember;

public class JoinController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		try {
			//요청데이터 인코딩
			request.setCharacterEncoding("UTF-8");
			//파라미터 가져오기 
			String email = request.getParameter("email");
			String pw =request.getParameter("pw");
			String tel =request.getParameter("tel");
			String address =request.getParameter("address");
			//묶어서 보내주기
			WebMember member = new WebMember(email,pw,tel,address);
			
			WebMemberDAO dao = new WebMemberDAO(); //SqlSessionFactory 생성
			int cnt = dao.join(member);//회원가입 기능
			
			if(cnt > 0) { //회원가입 성공
				// 실제로 이동시켜주는거는 frontcontroller에서 하기위함 
				//request 영역에 회원가입 시 입력한 이메일 추가 저장
				
//				request.setAttribute("joinEmail", email);
				System.out.println("회원가입 성공");
				url ="joinSuccess.jsp";
			}else { //회원가입 실패
				System.out.println("회원가입 실패");
				url ="index.jsp";
				
			}	
			
		}catch(UnsupportedEncodingException e){
			System.out.println("인코딩 방식 잘못 지정함");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return url;
	}

}
