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
	
	.photo {
		width: 200px;
		height: 320px;
		padding: 10px;
		border: 20px solid gray;
		border-radius: 30px;
		box-shadow: 3px 3px 3px gray;
		float: left;
		margin: 10px;
	}
	
	.photo img {
		width: 140px;
		height: 180px;
		border-radius: 30px;
	}
</style>
</head>
<body>
<h3 class="alert alert-success">MyShop List</h3>
<h5>총 ${total} 개의 상품이 있습니다</h5>
<h6>방송 날짜 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm EEEE"/></h6>
<hr>
<c:forEach var="dto" items="${list}" varStatus="n">
	<div class="photo">
		<figure>
			<img src="../../shop/${dto.photo}">
		</figure>
		<span>
			상품번호 : ${dto.num}<br>
			가격 : <fmt:formatNumber value="${dto.price}" type="currency" currencySymbol="￦" maxFractionDigits="0"/><br>
			색상 : <b style="background-color: ${dto.color}">${dto.color}</b>
		</span>
	</div>
</c:forEach>
</body>
</html>