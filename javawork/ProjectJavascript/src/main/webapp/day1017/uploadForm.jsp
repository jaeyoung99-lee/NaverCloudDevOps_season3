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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body * {
		font-family: 'Jua';
	}
</style>
<script type="text/javascript">
	$(function(){
		// file 태그는 안보이게 처리
		$("#upload").hide();
		
		// 카메라 아이콘을 클릭 시 파일 태그 클릭 효과 주기
		$(".uploadcamera").click(function(){
			$("#upload").trigger("click"); // trigger() : 강제 이벤트 발생
		});
	});
</script>
</head>
<body>
	<h3>파일 업로드 연습</h3>
	<form action="./uploadAction.jsp" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		파일 : <input type="file" name="upload" id="upload">
		<i class="bi bi-camera-fill uploadcamera"></i><br>
		<button type="submit">서버 전송</button>
	</form>
</body>
</html>