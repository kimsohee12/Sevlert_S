

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01Hello")
public class Ex01Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//요청을 처리하고 응답을 해줌
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 클라이언트에서 EX01Hello 경로로 요청
	//서버 주소/localhost:8081/context-root(path)/Ex00
	//localhost:8081/Ex00/Ex01Hello
		
	// 서버-> 정적리소스(HTML) : "Hello Servlet" 문자가 출력 -> 클라이언트	
	//화면에 Hello Servelt이라고 출력
	//-> 서버가 클라이언트한테 응답해주는 문서가 문자열이 작성되어있는 HTML묹서
		// response :서버 -> 클라이언트
		//getWrite() : 서버로부터 클라이언트코 데이터를 보내기위한 통로(스트링->printWr) 생성해주는 역할
	
	PrintWriter out = response.getWriter();	
	//printWriter :  데이터(텍스트)를 보내기위한 통로
	
	out.print("<b>Hello Servlet</b>"); //응답할 HTML 문서 만드는 작업 
		
	}

}
