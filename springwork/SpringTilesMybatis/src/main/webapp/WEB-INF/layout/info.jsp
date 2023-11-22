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
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<div>
		<h1>Info</h1>
		<h3>Manager : Chunsik</h3>
		<h5><i class="bi bi-telephone-fill"></i>&nbsp;&nbsp;010 - 5431 - 7193</h5>
		<img src="${root}/res/photo/꾸벅인사.gif" width="170">
		<br><br>
		<audio controls autoplay style="width: 250px;">
			<source src="" type="audio/mp3">
		</audio>
	</div>
</body>
</html>
