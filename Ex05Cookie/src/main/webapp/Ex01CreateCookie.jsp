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
		//--쿠기생성
		//1. 쿠키 객체 생성 Cookie(String("name"),String("value"));
		Cookie cookie = new Cookie("test","testCookie");
		//2. 생성된 쿠키의 만료날짜 (초단위)
		cookie.setMaxAge(60*60*24*365);//1시간 *24 -> 하루 *365 -> 1년
		//위에 내용까지는 서버가 할일 
		//3.서버에서 생성된 쿠키 -> 클라이언트에 보냄 (response)
		response.addCookie(cookie);
		response.addCookie(new Cookie("name","강예진"));//만료날짜 안정하고 바로 생성후 보냄 
	%>
	
	<a href ="Ex02GetCookie.jsp">쿠키확인</a>

</body>
</html>