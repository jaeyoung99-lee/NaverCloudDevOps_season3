<%@page import="data.ShopDto"%>
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
 <h3 class='alert alert-danger'>ex2_forward 파일입니다</h3>
 
 <%
 	// ex1에서 request에 저장해 둔 데이터 꺼내기
 	String msg = (String)request.getAttribute("msg");
 	List<ShopDto> list = (List<ShopDto>)request.getAttribute("list");
 %>
 
 <h2>ex1에서 저장해 둔 msg : <%=msg %></h2>
 <h2>ex1에서 저장해 둔 ShopDto List</h2>
 <%
 	for(ShopDto dto : list){%>
 		<h4>상품명 : <%=dto.getSangpum() %></h4>
 		<h4>가  격 : <%=dto.getPrice() %></h4>
 		<hr>
 	<%}
 %>
</body>
</html>