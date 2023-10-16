<%@page import="data.ShopDto"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
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
<!-- 
	jsp에서 페이지 이동하는 방법
	1. forward : url 주소 안 바뀜, request, response 등이 그대로 전달 됨
	2. redirect : url 주소 바뀜, request, response 등이 새로 생성되므로 전달 안됨
 -->
 
 <h3>forward를 이용해서 페이지 이동하기</h3>
 <%
 	// request에 데이터 저장
 	String msg = "Happy Day!!!";
 	List<ShopDto> list = new Vector();
 	list.add(new ShopDto("플렛슈즈", "14", 23000, "green"));
	list.add(new ShopDto("머리끈", "26", 8000, "yellow"));
	list.add(new ShopDto("보석머리띠", "30", 15000, "purple"));
	list.add(new ShopDto("뿌띠스카프", "10", 59000, "magenta"));
	list.add(new ShopDto("화이트자켓", "31", 23000, "white"));
	
	request.setAttribute("msg", msg);
	request.setAttribute("list", list);
 %>
 <jsp:forward page="ex2_forward.jsp"/>
</body>
</html>