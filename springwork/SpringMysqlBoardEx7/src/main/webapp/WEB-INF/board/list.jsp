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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
   body * {
       font-family: 'Jua';
   }  
</style>
</head>
<body>
	<div style="margin: 30px;">
		<h3 class="alert alert-danger">
		총 ${totalCount}개의 글이 있습니다.
		<button type="button" class="btn btn-outline-success" onclick="location.href='./writeform'" style="float: right;">글쓰기</button>
		</h3>
		<table class="table table-striped" style="margin-top: 30px; width: 600px; text-align: center;">
			<thead>
				<tr>
					<th width="50">번호</th>
					<th width="300">제목</th>
					<th width="80">작성자</th>
					<th width="100">작성일</th>
					<th width="50">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}" varStatus="n">
					<tr>
						<td>${totalCount - n.index}</td>
						<td>
							<a href="./content?num=${dto.num}" style="color: black; text-decoration: none;">
								${dto.subject}
								<c:if test="${dto.photo !=  'no photo'}">
									<i class="bi bi-image photoicon"></i>		
								</c:if>
							</a>
						</td>
						<td>${dto.writer}</td>
						<td>
							<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd."/>
						</td>
						<td>${dto.readcount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
