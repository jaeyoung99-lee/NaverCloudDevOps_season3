<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<body>
	<h5>JSP(Java Server Page) : 주석문</h5>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>

	<%
	// 자바 영역 표시, scriptlet(스크립트릿)
	// 변수 선언, 여기서 선언할 경우 서블릿 변환 시 메서드 내의 지역 변수로 들어감
	String name = "홍길동";
	int age = 23;
	// 브라우저로 출력
	// out : 내장객체(JSPWriter)
	out.print("이름 = " + name + "<br>");
	out.print("나이 = " + age + "세");
	%>

	<!-- jsp 표현식을 이용해서 java 영역의 변수를 출력 -->
	<h5>
		<b>이름 : <%=name%></b>
	</h5>
	<h6 style="color: red;">
		내 나이는
		<%=age%>세입니다
	</h6>

	<h6>선언문의 변수 출력하기</h6>
	<h6>주소 : <%=addr%></h6>
	<h6>현재 날짜와 시간 : <%=sdf.format(date)%></h6>

	<!-- 선언문으로 변수 선언 시, 서블릿에 멤버 변수로 등록되므로 위치 상관없이 사용 가능 -->
	<%!String addr = "강남구 역삼동";
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

	<h6>선언문의 변수 출력하기</h6>
	<h6>
		주소 :
		<%=addr%></h6>
	<h6>
		현재 날짜와 시간 :
		<%=sdf.format(date)%></h6>
</body>
</html>