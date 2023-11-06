<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 정보 추가</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body * {
		font-family: 'Jua';
	}
	
	.uploadcamera {
		font-size: 25px;
		cursor: pointer;
	}
	
	th {
		text-align: center;
	}
</style>
<script type="text/javascript">

	$(function() {
		// 카메라 이벤트
		$(".uploadcamera").click(function() {
			$("#upload").trigger("click"); // 이벤트 강제 발생
		});

		$("#upload").change(function() {
			console.log("1:" + $(this)[0].files.length);
			console.log("2:" + $(this)[0].files[0]);

			//정규표현식
			let reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			let f = $(this)[0].files[0];//현재 선택한 파일
			
			if (!f.type.match(reg)) {
				alert("확장자가 이미지파일이 아닙니다");
				return;
			}
			if ($(this)[0].files[0]) {
				let reader = new FileReader();
				reader.onload = function(e) {
					$("#showimg").attr("src", e.target.result);
				}
				reader.readAsDataURL($(this)[0].files[0]);
			}
		});
	});
</script>
</head>
<body>
<!-- 이미지 출력할곳 -->

 <img id="showimg" 

 style="position: absolute;left:600px;top:50px;max-width: 500px;">

	<div style="margin: 30px 50px;">
		<form action="./findLostAddAction.jsp" method="post" enctype="multipart/form-data">
			<table class="table table-bordered" style="width:450px;">
				<caption align="top">분실물 정보 입력</caption>
				<tr>
					<th width="150">분실물명</th>
					<td>
						<input type="text" name="name" class="form-control" style="width: 300px;" autofocus="autofocus" required="required">
					</td>
				</tr>
				
				<tr>
					<th width="150">사진</th>
					<td class="input-group">
						<input type="file" name="upload" id="upload" style="display: none;" required="required">
						&nbsp;&nbsp;
						<!-- 카메라 아이콘 -->
						<i class = "bi bi-camera-fill uploadcamera"></i>
					</td>
				</tr>
				
				<tr>
					<th width="150">잃어버린 장소</th>
					<td>
						<input type="text" name="lostplace" class="form-control" style="width: 300px;" autofocus="autofocus">
					</td>
				</tr>
				
				<tr>
					<th width="150">잃어버린 시간</th>
					<td>
						<input type="text" name="lostday" class="form-control" style="width: 300px;" autofocus="autofocus">
					</td>
				</tr>
				
				<tr>
					<th width="150">보상금</th>
					<td>
						<input type="text" name="money" class="form-control" style="width: 300px;" autofocus="autofocus" required="required">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success" style="width: 100px;">등록</button>
						<a href="./findLost_main.html" class="btn btn-outline-success" style="width: 100px;">홈</a>
			</table>
		</form>
	</div>
</body>
</html>