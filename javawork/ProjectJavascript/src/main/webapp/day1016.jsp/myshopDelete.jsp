<%@page import="myshop.data.MyshopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// num 읽기
	String num = request.getParameter("num");
	
	// dao 선언
	MyshopDao dao = new MyshopDao();
	
	// delete 메서드 호출
	dao.deleteShop(num);
	
	// myshop.jsp로 리다이렉트로 이동
	response.sendRedirect("myshop.jsp");
%>