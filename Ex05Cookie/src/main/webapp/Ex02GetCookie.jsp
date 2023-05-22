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
		//--저장된 쿠키 가져오기
		//클라이언트에 저장된 쿠기-> 서버로 보내기(요청) (request) 
		Cookie[] cookies =request.getCookies();//생성된 쿠키를 전부 묶어서 한번에 보내는 역할
		
		for(Cookie c:cookies){
			//쿠키의 name, value 를 화면에 출력
			out.print(c.getName() + " : " + c.getValue() + "<br>");
			
		}
		
		
	%>
	
	<a href ="Ex03removeCookie.jsp">쿠키 삭제</a>
	
	
</body>
</html>