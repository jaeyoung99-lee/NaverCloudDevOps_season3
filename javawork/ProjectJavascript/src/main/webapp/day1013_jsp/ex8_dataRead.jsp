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
<%
	request.setCharacterEncoding("utf-8");

	String nickname = request.getParameter("nickname");
	String java = request.getParameter("java");
	String jsp = request.getParameter("jsp");
	String spring = request.getParameter("spring");
	String phoneNumber1 = request.getParameter("hp1");
	String phoneNumber2 = request.getParameter("hp2");
	String tcolor = request.getParameter("tcolor");
	String bcolor = request.getParameter("bcolor");
%>
<body>
	<div style="font-size: 22px; background-color: <%=bcolor%>; color: <%=tcolor %>; width: 300px;">
		이름 : <%=nickname %>
		<br>
		java 점수 : <%=java %>점
		<br>
		jsp 점수 : <%=jsp %>점
		<br>
		spring 점수 : <%=spring %>점
		<br>
		총점 : <%=Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring) %>점
		<br>
		평균 : <%=String.format("%.1f", (Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring)) / 3.0)%>점
		<br>
		핸드폰 번호 : <%=phoneNumber1 + "-" + phoneNumber2 %>
	</div>
</body>
</html>