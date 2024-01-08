<%@page import="findLost.data.answerfindLostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// idx, findLostId 읽기
	String id = request.getParameter("id");
	String findLostId = request.getParameter("findLostId");
	
	// adao 선언
	answerfindLostDao adao = new answerfindLostDao(); 
	
	// 삭제 메서드 호출
	adao.deleteAnswer(Integer.valueOf(id));
	
	// content로 이동(findLostId 필요함)
	response.sendRedirect("content.jsp?id=" + findLostId);
	
%>