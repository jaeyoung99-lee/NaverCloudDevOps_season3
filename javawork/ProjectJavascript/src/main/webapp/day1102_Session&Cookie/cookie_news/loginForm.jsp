<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="loginAction.jsp" method="post">
		<div class="input-group" style="width: 300px; margin-top: 10px;">
			<b>암호 입력</b>
			<input type="password" class="form-control" style="width:100px; margin-left: 10px;" name="pass" autofocus required>
			<button type="submit" class="btn btn-sm btn-danger">로그인</button>
		</div>
	</form>
</body>
</html>