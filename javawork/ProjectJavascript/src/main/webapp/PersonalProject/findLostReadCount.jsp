<%@page import="findLost.data.findLostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	int id = Integer.valueOf(request.getParameter("id"));

	findLostDao dao = new findLostDao();
	
	dao.updateReadcount(id);
	
	response.sendRedirect("./content.jsp?id=" + id);
%>