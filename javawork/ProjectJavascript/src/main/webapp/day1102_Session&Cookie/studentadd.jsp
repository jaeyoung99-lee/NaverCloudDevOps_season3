<%@page import="student.data.StudentDto"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	String phone=request.getParameter("phone");
	//dao
	StudentDao dao=new StudentDao();
	//dto
	StudentDto dto=new StudentDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);
	
	//insert
	dao.insertStudent(dto);
%>