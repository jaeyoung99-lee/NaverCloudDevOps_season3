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
		// POST 방식의 한글 인코딩
		request.setCharacterEncoding("utf-8"); // 데이터 읽기 전 첫 줄에 기입
		// post 방식의 폼데이터 읽기
		String nickname = request.getParameter("nickname");
		String license = request.getParameter("license"); // 체크 시 on, 체크 안할 시 null
		String gender = request.getParameter("gender"); // radio는 같은 그룹일 경우(name이 같은 경우) 선택된 value 값을 읽음
		String home = request.getParameter("home");
	%>
<body>
<pre style="font-size: 2em;">
이름 : <%=nickname %>
운전 면허 : <%=license == null ? "없음" : "있음"%>
성별 :  <%=gender %>
주거지 : <%=home %>
</pre>
</body>
</html>