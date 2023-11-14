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
	<form action="./upload3" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name"><br>
		사진1 : <input type="file" name="upload"><br>
		사진2 : <input type="file" name="upload2"><br>
		핸드폰 : <input type="text" name="hp"><br>
		주소 : <input type="text" name="addr"><br>
		<button type="submit">서버 전송 #3</button>
	</form>
</body>
</html>
