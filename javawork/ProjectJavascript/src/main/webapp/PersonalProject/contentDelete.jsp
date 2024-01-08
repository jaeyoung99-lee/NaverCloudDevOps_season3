<%@page import="findLost.data.findLostDao"%>
<%@page import="simpleboard.data.simpleBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// id
	String id = String.valueOf(request.getParameter("id"));
	
	// dao 선언
	findLostDao dao = new findLostDao();
	
	// delete 메서드 호출
	dao.deleteLost(id);
	
	// findLost_main.html로 이동
	response.sendRedirect("findLost_main.html");
%>