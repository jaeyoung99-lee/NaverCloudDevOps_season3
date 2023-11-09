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
   
   ul.menu {
   	list-style: none;
   }
   
   ul.menu li {
   	float: left;
   	width: 150px;
   	height: 80px;
   	line-height: 80px;
   	border: 1px solid gray;
   	margin-right: 10px;
   	cursor: pointer;
   	text-align: center;
   	font-size: 30px;
   }
   
   ul.menu li a {
   	text-decoration: none;
   	color: green;
   }
</style>
</head>
<body>
<h1 class="alert alert-danger">여성 의류 매장</h1>
	<div style="margin: 30px;">
		<ul class="menu">
			<li>
				<a href="./shop/list1">원피스</a>
			</li>
			<li>
				<a href="./shop/list2">슈즈</a>
			</li>
			<li>
				<a href="./shop/list3">악세서리</a>
			</li>
			<li>
				<a href="./food/morning/brunch">브런치</a>
			</li>
			<li>
				<a href="./food/photo/detail">식사 사진</a>
			</li>
		</ul>
	</div>
</body>
</html>
