<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h2>서블릿으로부터 전달받은 데이터 출력</h2>
	<h4>메시지 : ${message}, ${requestScope.message}</h4>
	<h4>날짜 : ${today}</h4>
	<h4>날짜 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></h4>
	<h4>날짜 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd EEEE a hh:mm"></fmt:formatDate></h4>
	<h4>날짜 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd EEE HH:mm:ss"></fmt:formatDate></h4>
	<h4>날짜 : <fmt:formatDate value="${today}" type="date" dateStyle="short"></fmt:formatDate></h4>
	<h4>날짜 : <fmt:formatDate value="${today}" type="both" dateStyle="long"></fmt:formatDate></h4>
	
	<hr>
	
	<table class="table table-bordered" style="width: 400px;">
		<caption align="top">[전체출력 #1]</caption>
		<tr>
			<th>count</th>
			<th>index</th>
			<th>color</th>
		</tr>
		<c:forEach var="s" items="${list}" varStatus="n">
			<tr>
				<td>${n.count}</td>
				<td>${n.index}</td>
				<td style="color:${s}">${s}</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<table class="table table-bordered" style="width: 400px;">
		<caption align="top">[부분출력 #2]</caption>
		<tr>
			<th>count</th>
			<th>index</th>
			<th>color</th>
		</tr>
		<c:forEach var="s" items="${list}" begin="2" end="4" varStatus="n">
			<tr>
				<td>${n.count}</td>
				<td>${n.index}</td>
				<td style="color:${s}">${s}</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<h3>0~100까지 10단위로 출력</h3>
	<c:forEach var="n" begin="0" end="100" step="10">
		<b>${n}</b>&nbsp;
	</c:forEach>
</body>
</html>