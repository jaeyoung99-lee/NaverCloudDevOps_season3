<%@page import="myshop.data.MyshopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// num
	String num = request.getParameter("num");
	
	// dao
	MyshopDao dao = new MyshopDao();
	
	// delete
	dao.deleteShop(num);
%>