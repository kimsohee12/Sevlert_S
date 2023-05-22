<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// 쿠키삭제
		
		//1. 쿠키 생성 () 삭제 하고 싶은 쿠키의 name과 같은 name 가진 쿠키 생성 
		// ->value는 달라도 됨 
		
		Cookie cookie = new Cookie ("name","");
		
		//2. 만료기간 설정(0초)
		
		cookie.setMaxAge(0);
		//3. 서버에서 생성된 쿠키를 클라이언트로 전송
		response.addCookie(cookie);
		
	%>

	<a href="Ex02GetCookie.jsp">쿠키확인</a>
	
	
</body>
</html>