package com.smhrd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.fullStack;


@WebServlet("/Model2")
public class Model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model2로 요청 먼저
		//1.DB 연동
		//2. SQL 실행 (FullStack 테이블 안에 모든 값)
		//3. 3명의 학생정보 -> 세션저장 
		// -> Ex02model2.jsp 로 이동
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		fullStack fs =null;
		//List (인터페이스)-> 모든 리스트 타입의 상위 타입 -> ArrayList 타입을 업캐스팅해서 사용
		 //ArrayList : 데이터 검색이 용이 (인덱스 번호를 가지고있기 때문)
		//LinkedList : 중간 데이터 삭제, 추가 용이 
		List<fullStack>list = new ArrayList<fullStack>();
		
		try{
			//오라클과 연결할 드라이버 가지고 오기 (동적로딩)
			Class.forName("oracle.jdbc.OracleDriver");
		
			// 저장한 데이터베이스와 연결하기 위한 객체 (Connection) 생성
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user ="service";
			String password ="12345";
		
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from fullstack";
			//sql 쿼리문을 다루기 위한 객체 (prepareStatment)생성
			ps = conn.prepareStatement(sql); 
			
					
			//INSERT,DELETE,UPDATE -> executeUpdate()->int (몇개 행이 업데이드 되었는지)
			//SELECT (READ) -> executeQuery() -> ResultSet (읽어온 데이터,커서)
			//sql 실행
			rs = ps.executeQuery();
			while(rs.next()){// next() ->true(커서가 가리키고 있는 행에 데이터 있음)/ false (없음)
				String name = rs.getString("name");
				String major = rs.getString(2); // 테이블상 2번째 컬럼값 지정
				String phone = rs.getString("phone");
				
				//학생 한명의 정보만 가지고있음
				fs=new fullStack(name,major,phone);
				//한명 한명 list에 넣어주기
				list.add(fs);
			}
			
		}catch(ClassNotFoundException e){
			System.out.print ("클래스 못찾음");
		}catch(SQLException e){
			System.out.print ("SQL 예외 발생");
			
		}catch(Exception e){
			System.out.print ("다른 예외 발생");
			e.printStackTrace();
			
		}finally{ // 예외 상황 발생하던지. 하지 않던지 간에 무조건 실행
			try{
				rs.close();
				ps.close();
				conn.close();
			
			}catch(Exception e){
				System.out.print ("finally에서 예외 발생");
				e.printStackTrace();
			}
			
		}
		
		//list -> session 에 저장 
		//jsp 에서는 ssession이 내장 객체로 바로 불러올수 있지만 서블릿에서는 내장객체가 아니기 때문에 
		// HttpSession session=request.getSession(); -> 불러와서 사용해야함 
		HttpSession session=request.getSession();
		session.setAttribute("list",list);
		response.sendRedirect("Ex02model2.jsp");
		
	}

	
}
