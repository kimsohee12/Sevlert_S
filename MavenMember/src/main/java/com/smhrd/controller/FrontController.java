package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//~.do 요청을 모두 받아줄 컨트롤러 (프론트 컨트롤러)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String,Command> list = null;
	
	
	public void init(ServletConfig config) throws ServletException {
		//Map 함수 사용해서 요청이 들어오면 어떤 컨트롤러를 쓸것인지 지정 
		list =new HashMap<>();
		list.put("/join.do",new JoinController());
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
		list.put("/update.do", new UpdateController());
		list.put("/delete.do", new DeleteController());
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 구분해서 컨트롤러 사용할수 있도록 
		String reqUrl =request.getRequestURI(); //요청경로
		String ContextPath =request.getContextPath();//ContextPath :  서버에서 프로젝트를 구별하기 위해 쓰는 경로
		String key = reqUrl.substring(ContextPath.length());// /join.do /login.do
		
		Command controller = list.get(key);
		String des = controller.process(request, response);
		System.out.println(des);
		  if(des.equals("joinSuccess.jsp")) {
		         //forwarding
		         RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
		         rd.forward(request,response);
		      }else {
		         //redirecting
		    	  response.sendRedirect(des);
		       
		      }
		
	}
	
	

}
