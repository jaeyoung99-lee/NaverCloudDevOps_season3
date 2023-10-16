<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<h5>include : 다른 파일의 실행 결과를 가져옴</h5>
<h5>구구단</h5>
<jsp:include page="../day1013_jsp/ex3_gugudan.jsp"/>
<hr>
<h5>ShopList</h5>
<jsp:include page="../day1013_jsp/ex4_shopList.jsp"/>
</body>
</html>