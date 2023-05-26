package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

//MyBatis DAO 정의 
//데이터베이스랑 연결 
public class WebMemberDAO {
	//SqlSessionFactory 생성 : DB 관련 기능을 직접 사용할 수 있는 세션을 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	//회원가입
	public int join(WebMember member) {
		//Factory 사용해서 Session 생성
		//true :  auto commit (자동 커밋) -> () -> 기본값이 False(자동커밋 안해줌)
		//		-> true로 지정해줘야 자동커밋 가능
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		int cnt =0;
		try {
			
		//insert(실제 실행할 sql-namespace.id 정의(xml) ,sql 실행할 때 넘겨줄 값 -> (달라져야 하면 (?)) -> 채워줄 값 )
		// 반환값 :  sql 실핼 성공 (삽입 성공 -> 1 /실패 ->0)
		cnt = sqlSession.insert("WebMemberDAO.insert",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); // 자원 반환 
		}
		return cnt;
		
	}
	
	//로그인
	
	public WebMember login(WebMember member) {
		//세션생성
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		WebMember loginMember =null;
		try {
			loginMember = sqlSession.selectOne("WebMemberDAO.login",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return loginMember;
	}

	public int update(WebMember updateMember) {
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		int cnt =0;
		try {
			cnt = sqlSession.update("WebMemberDAO.update",updateMember);
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}
	
	public List<WebMember>select (){
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		List<WebMember> list = null;
				
		try {
			list = sqlSession.selectList("WebMemberDAO.select"); //넘겨줘야하는값이 없으면 매개인자는 1개만 쓴다
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			sqlSession.close();
		}
		
		return list;
		
	}
	
	public int delete(String email) {
		
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		int cnt =0;
		try{
			cnt = sqlSession.delete("WebMemberDAO.delete",email);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	
	
	
	
	
	
}
