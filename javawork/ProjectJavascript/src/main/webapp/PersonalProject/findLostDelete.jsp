<%@page import="findLost.data.findLostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");

	findLostDao dao = new findLostDao();
	
	dao.deleteLost(num);
%>