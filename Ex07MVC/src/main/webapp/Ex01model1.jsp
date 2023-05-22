
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.smhrd.model.fullStack"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- WEB MVC MODEL 1 :  비지니스로직 (Controller, 화면 표현 (View) -> JSP 로 작성  -->
	<!-- DB 연동 (JDBC) -->
	<!-- DB 라이브러리 WEB-INF 에 끌어 놓기 -->

	<%
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		fullStack fs =null;
		try{
			//오라클과 연결할 드라이버 가지고 오기 (동적로딩)
			Class.forName("oracle.jdbc.OracleDriver");
		
			// 저장한 데이터베이스와 연결하기 위한 객체 (Connection) 생성
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user ="service";
			String password ="12345";
		
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from fullstack where name = ?";
			//sql 쿼리문을 다루기 위한 객체 (prepareStatment)생성
			ps = conn.prepareStatement(sql); 
			System.out.print(1);
			//? 자리 채우기
					
			ps.setString(1,"선영표");
			System.out.print(2);
			//INSERT,DELETE,UPDATE -> executeUpdate()->int (몇개 행이 업데이드 되었는지)
			//SELECT (READ) -> executeQuery() -> ResultSet (읽어온 데이터,커서)
			//sql 실행
			rs = ps.executeQuery();
			System.out.print(3);
			if(rs.next()){// next() ->true(커서가 가리키고 있는 행에 데이터 있음)/ false (없음)
				String name = rs.getString("name");
				String major = rs.getString(2); // 테이블상 2번째 컬럼값 지정
				String phone = rs.getString("phone");
				
				System.out.print(name);
				fs =new fullStack(name,major,phone);
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
		
	%>
	
	이름 : <%=fs.getName() %><br>
	전공 : <%=fs.getMajor() %><br>
	전화번호 : <%=fs.getPhone() %>

</body>
</html>