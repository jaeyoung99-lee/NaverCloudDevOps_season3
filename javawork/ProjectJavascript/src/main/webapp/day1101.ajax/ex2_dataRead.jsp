<?xml version="1.0" encoding="UTF-8"?>
<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyshopDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sangpum = request.getParameter("sangpum");
	String color = request.getParameter("color");
	String photo = request.getParameter("photo");
	String price = request.getParameter("price");
	
	// db에 저장
	MyshopDao dao = new MyshopDao();
	
	// dto에 담기
	MyShopDto dto = new MyShopDto();
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setPrice(Integer.parseInt(price));
	
	// db 저장
	dao.insertShop(dto);
	
	// 총 개수
	int total = dao.getAllSangpums().size();
%>

<data>
	<sangpum><%=sangpum %></sangpum>
	<photo><%=photo %></photo>
	<total><%=total %></total>
</data>