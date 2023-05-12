package com.smhrd.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String job = request.getParameter("job");
		String Gender = request.getParameter("Gender");
		//String hobby = request.getParameter("hobby");
		String[] hobby = request.getParameterValues("hobby"); // +values->배열타입 이용해서 여려값을 가져올수 있음		
		//getParameter -> 선택한것중 하나만 가져오는 특징있음 같은 name에서 여러개 가져올수 x
		
		System.out.println(job);
		System.out.println(Gender);
		System.out.println(Arrays.toString(hobby));
		
	}

}
