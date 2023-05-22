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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		session.setAttribute("id", id);
		
		String forwardPage = null;
		
		/* String id = (String)session.getAttribute("id"); */
		if(id.equals(id)&&pw.equals(pw)){
		//id 값을 보내는 방법
		//1) url 에 데이터를 추가해서 요청하는 방법 => 쿼리스트링 (Query String)
		//쿼리스트링 -> url?name1=value1&&name2=value2
		
		//response.sendRedirect("Ex04LoginSuccess.jsp?id="+id);=>Redirectiong(리다이렉팅)(요청도 응답도 2번 생김)
		
		//2) request 객체를 다음 페이지로 넘겨주는 방법(공유하는 방법)=> forwarding(포워딩)(요청, 응답 1번)
		//RequestDispatcher : 클라이언트로부터 최초에 들어온 요청(request)를 원하는 자원으로 넘기는 등의 메서드를 가지고있는 객체
		//(가지고 있는 요청을 원하는곳으로 보내는)
		RequestDispatcher rd = request.getRequestDispatcher("Ex04LoginSuccess.jsp");
		//지정한 자원으로 request 객체 (,response 객체)넘기기
		rd.forward(request, response);
		
	}else {
		response.sendRedirect("Ex04LoginFail.jsp");
	}
		/* request.setAttribute("id", id); */
	%>
	
	<%-- <jsp:forward page="<%=forwardPage %>">
		<jsp:param value="<%=id %>" name="user"/>
	</jsp:forward> --%>
</body>
</html>

