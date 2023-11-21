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
   
	ul.menu,ul.menu li {
		margin:0;
		padding: 0;
	}	
	
	
	ul.menu {
		list-style: none;
		height: 80px;
		margin: 0 auto;
	}
	
	ul.menu li {
		float: left;
		width: 100px;
		height:60px;
		line-height: 60px;
		font-size: 20px;
		border: 2px solid gray;
		border-radius: 30px;
		box-shadow: 3px 3px 3px gray;
		margin-right: 10px;
	}
	
	ul.menu li:hover {
		background-color: pink;
	}
	
	ul.menu li a {
		cursor: pointer;
	}
	
	ul.menu li a:hover {
		color: blue;
	}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<body>
	<ul class="menu">
		<li>
			<a href="${root}/">Home</a>
		</li>
		<li>
			<a href="${root}/member/form">회원가입</a>
		</li>
		<li>
			<a href="${root}/login/main">로그인</a>
		</li>
		<li>
			<a href="${root}/board/list">게시판</a>
		</li>
		<li>
			<a href="${root}/guest/list">방명록</a>
		</li>
		<li>
			<a href="${root}/map">오시는 길</a>
		</li>
	</ul>	
</body>
</html>
