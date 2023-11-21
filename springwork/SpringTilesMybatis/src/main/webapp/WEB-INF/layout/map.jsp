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
   
   iframe {
       width: 100%; 
       margin: 0 auto;
   }
</style>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<h2><img src="${root}/res/photo/인사.gif" width="150"><img src="${root}/res/photo/말풍선.png" width="200" style="margin-bottom: 100px;"></h2>
	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3165.300889131211!2d127.02321567658994!3d37.50082097205572!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca158e3eb7817%3A0x9477be46958f3844!2z7Lm07Lm07Jik7ZSE66CM7KaIIOqwleuCqCDtlIzrnpjqt7jsi60g7Iqk7Yag7Ja0!5e0!3m2!1sko!2skr!4v1700467897513!5m2!1sko!2skr" width="700" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</body>
</html>
