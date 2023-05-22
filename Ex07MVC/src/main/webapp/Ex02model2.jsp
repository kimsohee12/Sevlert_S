
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<!-- 세션 안에 저장되어 있는 학생정보 (3명) 테이블 출력  -->

<%

	List<fullStack> list = (List<fullStack>)session.getAttribute("list");
	

%>


<table border =1>
	<tr>
		<th>이름</th>
		<th>전공</th>
		<th>번호</th>
	</tr>
	<% for(fullStack fs : list) {
	%>
	<tr>
		<th><%=fs.getName() %></th>
		<th><%=fs.getMajor() %></th>
		<th><%=fs.getPhone() %></th>
	</tr>
	
	<%}
	 %>

</table>


</body>
</html>