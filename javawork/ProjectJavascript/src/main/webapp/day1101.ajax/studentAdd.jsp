<%@page import="student.data.StudentDto"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String blood = request.getParameter("blood");
	String phone = request.getParameter("phone");
	
	StudentDao dao = new StudentDao();
	
	StudentDto dto = new StudentDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);
	
	dao.insertStudent(dto);
%>