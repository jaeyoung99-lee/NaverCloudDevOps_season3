package study.day1107;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello.do")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// request에 각종 정보를 저장
		
		// result1.jsp로 포워드
		// 포워드의 특징 
		// 1. url 주소 유지
		// 2. request, response 그대로 유지
		
		List<String> list = new ArrayList<String>();
		list.add("red");
		list.add("green");
		list.add("magenta");
		list.add("orange");
		list.add("blue");
		
		request.setAttribute("list", list);
		request.setAttribute("today", new Date());
		request.setAttribute("message", "Have a Good Day!!!");
		
		// result1.jsp로 포워드
		RequestDispatcher rd = request.getRequestDispatcher("./day1107/result1.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
