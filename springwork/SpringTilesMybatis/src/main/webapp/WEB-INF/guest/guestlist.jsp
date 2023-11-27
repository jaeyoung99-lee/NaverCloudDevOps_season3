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
	<div>
		<form action="./insert" method="post" enctype="multipart/form-data">
			<b>사진 1장 필수 : </b>
			<input type="file" name="upload" required>
			<br>
			<b>닉네임 : </b>
			<input type="text" name="guest_nickname" required>
			<br>
			<textarea style="width: 300px; height: 100px;", name="guest_content" required></textarea>
			<br>
			<button type="submit">방명록 저장</button>
		</form>
	</div>
	<hr>
	<div>
		<h5>총 ${totalCount}개의 방명록 글이 있습니다.</h5>
	</div>
</body>
</html>
