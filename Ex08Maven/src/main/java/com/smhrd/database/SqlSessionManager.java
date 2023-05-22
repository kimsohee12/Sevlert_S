package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//데이터베이스와 연결, sql문 실행 등의 역할을 함 
public class SqlSessionManager {
	
	//실제 연결, 실행 등에 역할을 수행할 session 
	//(데이터베이스 연결부터 실행 ,연결끊기 등의 일렬의 작업을 session이라 부름) 생성 해주는 factory
	public static SqlSessionFactory sqlSessionFactory;
	
	   //클래스 초기화 블럭 : 클래스가 처음 로딩될 때 딱 **한번만 수행**
	   static { // 실행이 되자마자 바로 코드 실행 
		   
	      //설정정보 가지고 오기위한 mybatis-config.xml 경로 작성
	      String resource = "com/smhrd/database/mybatis-config.xml";

	      Reader reader;
	      //경로가 작성되어 있는데 경로가 올바르지 않을 때-> try-catch문 작성
	      try {
	         //문자열 경로로 파일읽기
	         reader = Resources.getResourceAsReader(resource);
	         //읽은 정보를 토대로 DB 관련 기능을 가진 SqlSessionFactory 생성
	         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	      }catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   //static 초기화 블럭에서 생성된 factory 반환 
	   public static SqlSessionFactory getSqlSessionFactory() {
		   return sqlSessionFactory;
	   }
	   
	   
}
