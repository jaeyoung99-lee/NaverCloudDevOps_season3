<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// loginok 세션 제거
	session.removeAttribute("loginok");
	
	// 메인페이지로 이동
	response.sendRedirect("loginMain.jsp");
%>