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
	<h2>여러 개의 사진 업로드 결과</h2>
	<h3>제목 : ${title}</h3>
	<hr>
	<c:forEach var="f" items="${files}">
		<figure style="float: left;">
			<img src="./res/upload/${f}" width="200" height="200" border="2" hspace="10">
			<figcaption>
				${f}
			</figcaption>
		</figure>
	</c:forEach>
</body>
</html>
