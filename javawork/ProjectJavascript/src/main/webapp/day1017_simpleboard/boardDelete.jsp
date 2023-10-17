<%@page import="simpleboard.data.simpleBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// num
	String num = request.getParameter("num");
	
	// dao 선언
	simpleBoardDAO dao = new simpleBoardDAO();
	
	// delete 메서드 호출
	dao.deleteBoard(num);
	
	// list.jsp로 이동
	response.sendRedirect("list.jsp");
%>