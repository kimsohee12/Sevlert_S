

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("Id");
		String pw = request.getParameter("Pw");
		
		
		
		if(id.equals("test")&& pw.equals("12345")) {
			//세션 객체 생성
			HttpSession session=request.getSession();
			//세션 값 저장
			session.setAttribute("id",id);
			
			// -forwarding : 데이터를 포함해서 이동할 때
			//-Redirecting :이동만 할 때  -> 세션에 값을 저장해놔서 이동만 해도 됨
			response.sendRedirect("Ex08Main.jsp");
		}else {
			response.sendRedirect("Ex08LoginForm.html");
			
		}
				
		
		
		
		

	}

	
	
	
}

