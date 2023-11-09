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
<c:set var="num1" value="7" /> <!-- var: 변수명, value: 값 -->
<c:set var="num2" value="4" />
<h4>num1: ${num1}, num2: ${num2}</h4>
<table class="table table-bordered" style="width: 300px;">
	<tr>
		<th>연산식</th>
		<th>결과</th>
	</tr>
	<tr>
		<td>\${num1 + num2}</td>
		<td>${num1 + num2}</td>
	</tr>
	<tr>
		<td>\${num1 - num2}</td>
		<td>${num1 - num2}</td>
	</tr>
	<tr>
		<td>\${num1 * num2}</td>
		<td>${num1 * num2}</td>
	</tr>
	<tr>
		<td>\${num1 / num2}</td>
		<td>${num1 / num2}</td>
	</tr>
	<tr>
		<td>\${num1 div num2}</td>
		<td>${num1 div num2}</td>
	</tr>
	<tr>
		<td>\${num1 % num2}</td>
		<td>${num1 % num2}</td>
	</tr>
	<tr>
		<td>\${num1 mod num2}</td>
		<td>${num1 mod num2}</td>
	</tr>
	<tr>
		<td>num1 1 증가</td>
		<td>
			<c:set var="num1" value="${num1+1}"/>
			${num1}
		</td>
	</tr>
</table>
<hr>
<c:set var="money" value="5678900"/>
<c:set var="avg" value="78.93678"/>
<c:set var="num3" value="0.5645678"/>
${money}<br>
${avg}<br>
<fmt:formatNumber value="${money}" type="number"/><br>
<fmt:formatNumber value="${money}" type="currency" currencySymbol="$"/><br>
<fmt:formatNumber value="${money}" type="currency" currencySymbol="￦"/><br>
<fmt:formatNumber value="${num3}" type="percent"/><br>
<fmt:formatNumber value="${num3}" type="percent" maxFractionDigits="2"/><br>
</body>
</html>