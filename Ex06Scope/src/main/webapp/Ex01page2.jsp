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
		String nick=(String)pageContext.getAttribute("nickname");
		
	%>		
		
		<%=nick %> <!--  값이 없으면 null 출력 -->
		${nickname} <!--  값이 없으면 아예 출력 안해줌 el표기법 -->
		
	
</body>
</html>