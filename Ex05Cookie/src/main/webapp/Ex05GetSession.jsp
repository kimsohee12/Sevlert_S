<%@page import="java.util.ArrayList"%>
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
		//세션값 가져오기
		//getAttribute(String(name))
		//업캐스팅 되어 object 타입을 다운캐이스팅으로 원래 타입으로 돌림
		String id = (String)session.getAttribute("id");
		Integer age = (Integer)session.getAttribute("age");
		ArrayList<String> al =(ArrayList<String>)session.getAttribute("list");
	
	%>
	
	id : <%=id %><br>
	age : <%=age %><br>
	list : <%=al %>
	<a href ="Ex07Invalidate.jsp">세션전부삭제</a>
	<a href ="Ex06RemoveSession.jsp">세션삭제</a>
</body>
</html>