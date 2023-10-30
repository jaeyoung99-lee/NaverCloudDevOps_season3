<%@page import="simpleboard.data.AnswerBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// idx, num 읽기
	String idx = request.getParameter("idx");
	String num = request.getParameter("num");
	
	// adao 선언
	AnswerBoardDao adao = new AnswerBoardDao(); 
	
	// 삭제 메서드 호출
	adao.deleteAnswer(idx);
	
	// content로 이동(num 필요함)
	response.sendRedirect("content.jsp?num=" + num);
	
%>