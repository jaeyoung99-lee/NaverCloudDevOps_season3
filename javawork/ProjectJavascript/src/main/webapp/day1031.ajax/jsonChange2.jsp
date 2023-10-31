<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name="마이클";
	int age=34;
	
	JSONObject jo=new JSONObject();
	jo.put("name",name);
	jo.put("age",age);
%>
<%=jo.toString()%>