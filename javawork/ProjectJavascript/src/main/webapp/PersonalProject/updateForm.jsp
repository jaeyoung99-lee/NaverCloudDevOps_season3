<%@page import="findLost.data.findLostDto"%>
<%@page import="findLost.data.findLostDao"%>
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
		font-family: 'Single Day';
	}
	
	.uploadcamera {
		font-size: 25px;
		cursor: pointer;
	}
	
	.content-container {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        text-align: center;
        min-height: 100vh;
        margin: 0 auto;
        background-color: #FFFFE0;
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
			var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			var f = $(this)[0].files[0];//현재 선택한 파일

			if (!f.type.match(reg)) {
				alert("확장자가 이미지파일이 아닙니다");
				return;
			}
			if ($(this)[0].files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$("#showimg").attr("src", e.target.result).css("display", "block");
				}
				reader.readAsDataURL($(this)[0].files[0]);
			}
		});
	});
</script>
</head>
<%
	// id
	int id = Integer.parseInt(request.getParameter("id"));
	// dao
	findLostDao dao = new findLostDao();
	
	// dto
	findLostDto dto = dao.getData(Integer.valueOf(id));
%>
<body>
<!-- 이미지 출력할곳 -->
<div class="content-container">
 <img id="showimg" src="<%=dto.getPhoto() %>" 

 style="position: absolute; left: 1200px; display: block; max-width: 300px;" onerror="this.style.display='none';"> <!-- error가 발생하면 안보이게 처리(해당 파일이 없는 경우) -->
	<div style="margin: 30px 50px;">
		<form action="./updateAction.jsp" method="post" enctype="multipart/form-data">
			<!-- num은 hidden으로 전달 -->
			<input type="hidden" name="findLostId" value="<%=id %>">
			<table class="table table-bordered" style="width:500px;">
				<caption align="top" style="text-align: center; font-size: 30px;">분실물 정보 수정</caption>
				<tr>
					<th width="150">분실물명</th>
					<td>
						<input type="text" name="name" class="form-control" style="width: 300px;" autofocus="autofocus" required="required" value="<%=dto.getName()%>">
					</td>
				</tr>
				
				<tr>
					<th width="150">사진</th>
					<td class="input-group">
						<input type="text" name="subject" class="form-control" required="required" value="오른쪽 아이콘 클릭하여 사진 변경">
						<input type="file" name="upload" id="upload" style="display: none;">
						&nbsp;&nbsp;
						<!-- 카메라 아이콘 -->
						<i class = "bi bi-camera-fill uploadcamera"></i>
					</td>
				</tr>
				
				<tr>
					<th width="150">잃어버린 장소</th>
					<td>
						<input type="text" name="lostplace" class="form-control" style="width: 300px;" autofocus="autofocus" required="required" value="<%=dto.getLostplace()%>">
					</td>
				</tr>
				
				<tr>
					<th width="150">잃어버린 시간</th>
					<td>
						<input type="text" name="lostday" class="form-control" style="width: 300px;" autofocus="autofocus" required="required" value="<%=dto.getLostday()%>">
					</td>
				</tr>
				
				<tr>
					<th width="150">보상금</th>
					<td>
						<input type="text" name="money" class="form-control" style="width: 300px;" autofocus="autofocus" required="required" value="<%=dto.getMoney()%>">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success" style="width: 100px;">수정</button>
						<a href="./findLost_main.html" class="btn btn-outline-success" style="width: 100px;">홈</a>
			</table>
		</form>
	</div>
</div>
</body>
</html>