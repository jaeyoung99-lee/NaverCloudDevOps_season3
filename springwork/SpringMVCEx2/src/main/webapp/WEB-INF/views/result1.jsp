<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }  
</style>
</head>
<body>
	<h2 class="alert alert-info">TestController로부터 포워드 됨</h2>
	
	<h4>오늘의 메시지 : ${message}</h4>
	<h5>현재 시간 : ${today}</h5>
	<h5>현재 날짜와 시간 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm"/></h5>
	
	<hr>
	
	<h4>매핑 주소 테스트</h4>
	<ol>
		<li>
			<a href="./shop/list">/shop/list</a>
		</li>
		<li>
			<a href="./shop/insert">/shop/insert</a>
		</li>
		<li>
			<a href="./shop/delete">/shop/delete</a>
		</li>
		<li>
			<a href="./shop/list.do">/shop/list.do</a>
		</li>
		<li>
			<a href="./shop/list.nhn">/shop/list.nhn</a>
		</li>
		<li>
			<a href="./board/update">/board/update</a>
		</li>
		<li>
			<a href="./stu/form/test1">/stu/form/test1</a>
		</li>
	</ol>
</body>
</html>
