<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%


MultipartRequest multipartRequest = null;

String realPath = getServletContext().getRealPath("/PersonalProject/Images");
System.out.println("path=" + realPath);
int uploadSize = 1024 * 1024 * 5; // 5MB
%>