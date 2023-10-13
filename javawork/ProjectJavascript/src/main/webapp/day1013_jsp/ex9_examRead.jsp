<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
</style>
</head>
<%
	request.setCharacterEncoding("utf-8");

	String line = request.getParameter("line");
	String today = request.getParameter("today");
	String photo = request.getParameter("photo");
%>
<body>
	<div>
		날짜 :
		<%=today %>
		<br>
		<img src="<%=photo %>" style="border:<%=line %>">
	</div>
</body>
</html>