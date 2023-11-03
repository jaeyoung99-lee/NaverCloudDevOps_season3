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
	Cookie[] cookies = request.getCookies(); // 배열로 반환됨
	boolean find = false;
	if(cookies != null){
		for(Cookie ck : cookies){
			// 저장된 쿠키 이름을 얻기
			String name = ck.getName();
			if(name.equals("loginok")){
				find = true; // 해당 쿠키가 존재하면 true
			}
		}
	}
%>
<body>
	<div style="margin: 30px;">
		<%
			if(find){%>
			<!-- find가 true일 경우 이미 로그인 했다는 의미를 나타내므로 로그아웃폼을 나타냄 -->
				<jsp:include page="logoutForm.jsp"></jsp:include>			
			<%}else{ %>
				<jsp:include page="loginForm.jsp"></jsp:include>
			<%}
		%>
		<hr width="600" style="height: 5px; background-color: gray;">
		<!-- 뉴스 기사 include -->
		<jsp:include page="paper.jsp"></jsp:include>
	</div>
</body>
</html>