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
	<form action="./addshop" method="post" enctype="multipart/form-data">
		상품명 : <input type="text" name="sangpum"><br>
		색상 : <input type="color" name="color" value="#ffccff"><br>
		가격 : <input type="number" name="price"><br>
		입고일 : <input type="date" name="ipgoday" value="2023-12-12"><br>
		사진 : <input type="file" name="photo"><br>
		<button type="submit">서버에 전송</button>
	</form>
</body>
</html>
