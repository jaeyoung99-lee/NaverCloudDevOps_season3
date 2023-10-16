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
<%
	// jsp:param으로 한글을 전달 시, 현재 페이지에서 인코딩 해줘야 함
	request.setCharacterEncoding("utf-8");
%>
<jsp:forward page="ex4_forward.jsp">
	<jsp:param value="../image/C7.png" name="photo"/>
	<jsp:param value="Hello!!안녕" name="msg"/>
</jsp:forward>	
</body>
</html>