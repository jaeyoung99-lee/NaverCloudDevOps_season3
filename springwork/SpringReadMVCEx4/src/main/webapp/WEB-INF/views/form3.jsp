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
	<form action="./process3" method="post">
		상품명 : <input type="text" name="sang">
		<br>
		사진 :
		<select name="photo">
			<option>C1.png</option>
			<option>C2.png</option>
			<option>C3.png</option>
		</select>
		<br>
		수량 : <input type="text" name="su">
		<br>
		단가 : <input type="text" name="dan">
		<br>
		색상 : <input type="color" name="color" value="#ccffcc">
		<br>
		날짜 : <input type="date" name="today" value="2023-12-25">
		<br>
		<button type="submit">전송 #3</button>
	</form>
</body>
</html>
