<%@page import="findLost.data.findLostDto"%>
<%@page import="findLost.data.findLostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String photo = request.getParameter("photo");
	String lostplace = request.getParameter("lostplace");
	String lostday = request.getParameter("lostday");
	String money = request.getParameter("money");
	
	findLostDao dao = new findLostDao();
	
	findLostDto dto = new findLostDto();
	dto.setName(name);
	dto.setPhoto(photo);
	dto.setLostplace(lostplace);
	dto.setLostday(lostday);
	dto.setMoney(money);
	
	dao.insertLost(dto);
%>