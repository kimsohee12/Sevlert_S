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
		//page 영역 (scope) 에 저장된 값은 해당 페이지 안에서만 지역변수처럼 사용 
		//page 영역에 저장된 값-> el(expression language)표기법(자바 변수는 불가능)
		//.setAttribute (name(String),value(object))
		pageContext.setAttribute ("nickname","풀스택");
		//pageContext (object 타입)-> 업 캐스팅 되서 들어가기때문에 다운캐스팅해야 사용 가능)
		String nick = (String)pageContext.getAttribute("nickname");
	%>
	<%=nick %><br>
	${nickname} <!--  page 영역안에 저장된 name 값 지정  -->
	${pageScope.nickname } 
	
	<a href ="Ex01page2.jsp">2로 이동</a>

</body>
</html>