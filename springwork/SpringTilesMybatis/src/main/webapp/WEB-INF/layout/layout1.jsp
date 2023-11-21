<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
   body * {
       font-family: 'Jua';
   }  
   
   a:link, a:visited {
   	   color: black;
   	   text-decoration: none;
   }
   
   a:hover {
   	   color: #FFCE7B;
   }
   
   div.main_container>div {
   	   border: 0px solid gray;
   }
   
   div.main_container div.header {
   	   width: 100%;
   	   height: 100px;
   	   line-height: 100px;
   	   text-align: center;
   	   font-size: 30px;
   	   font-weight: bold;
   }
   
   div.main_container div.menu {
   	   width: 100%;
   	   height: 100px;
   	   line-height: 100px;
   	   text-align: center;
   	   display: flex;
       justify-content: center;
   }
   
   div.main_container div.info {
   	   position: absolute;
   	   left: 30px;
   	   top: 250px;
   	   width: 150px;
   	   height: 200px;
   }
   
   div.main_container div.home {
       position: absolute;
       left: 50%;
       top: 50%;
       transform: translate(-50%, -50%);
       width: 700px;
       height: 550px;
   }
   
   div.main_container div.footer {
   	   position: absolute;
   	   left: 0px;
   	   top: 950px;
   	   width: 100%;
   	   height: 100px;
   	   line-height: 100px;
   	   text-align: center;
   }
</style>
</head>
<body>
	<div class="main_container">
		<div class="header">
			<tiles:insertAttribute name="header"/>
		</div>
		<div class="info">
			<tiles:insertAttribute name="info"/>
		</div>
		<div class="menu">
			<tiles:insertAttribute name="menu"/>
		</div>
		<div class="home">
			<tiles:insertAttribute name="home"/>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
		
	</div>
</body>
</html>
