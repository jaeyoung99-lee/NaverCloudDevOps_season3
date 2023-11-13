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
	<h3>폼 데이터 읽기</h3>
	<hr>
	<ol>
		<li>
			<a href="./form1">폼 데이터 읽기 - GET 방식</a>
		</li>	
		<li>
			<a href="./form2">폼 데이터 읽기 - POST 방식 -> 각각 읽기</a>
		</li>	
		<li>
			<a href="./form3">폼 데이터 읽기 - POST 방식 -> DTO로 읽기</a>
		</li>	
		<li>
			<a href="./form4">폼 데이터 읽기 - POST 방식 -> Map으로 읽기</a>
		</li>	
		<li>
			<a href="./uploadform1">파일 1개 업로드하기</a>
		</li>	
		<li>
			<a href="./uploadform2">파일 여러 개 업로드하기</a>
		</li>	
	</ol>
</body>
</html>
