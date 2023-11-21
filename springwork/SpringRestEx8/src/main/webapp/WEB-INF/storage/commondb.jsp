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
   
   div.list .box {
   	   width: 400px;
   	   height: 100px;
   	   margin-bottom: 10px;
   	   border: 2px solid gray;
   	   border-radius: 30px;
   	   box-shadow: 3px 3px 3px gray;
   	   padding : 10px;
   }
</style>
<script type="text/javascript">
	$(function(){
		list();
	
		$("#upload").change(function(){
			let form = new FormData();
			form.append("upload", $("#upload")[0].files[0]); // 선택한 1개의 파일만 추가(여러 사진일 경우 files 부분을 반복문으로 돌리면 됨)
			
			/*
			processData : false : 서버에 전달하는 데이터는 query string이라는 형태로 전달됨
			파일전송의 경우 이를 하지 않아야 하는데 그 설정이 false
			contentType : false : enctype이 원래 기본값이 application/x-www..... 이거인데 multipart/form-data로 변경
			*/
			
			$.ajax({
				type: "post",
				dataType: "text",
				url: "./addphoto",
				processData: false,
				contentType: false,
				data: form,
				success: function (res) {
					// alert(res); // 랜덤 파일명 확인 후 이미지 출력
					$(".photo80").attr("src", res);
				},
				statusCode: {
					404: function () {
						alert("Can't find json file!");
					},
					500: function () {
						alert("server error. one more view your code.");
					}
				}
			});
		});
		
		$("#btnsend").click(function(){
			let title = $("#title").val();
			if(title.length == 0){
				alert("제목을 입력해주세요");
				return;
			}
			$.ajax({
				type: "post",
				dataType: "text",
				url: "./adddb",
				data: {"title":title},
				success: function (res) {
					list(); // 목록 다시 출력
					
					// 제목 지우기
					$("#title").val("");
				},
			});
		});
		
		// photo150 이벤트
		$(document).on("mouseover", ".photo150", function(){
			$(this).next().css("display", "block");
		});
		$(document).on("mouseout", ".photo150", function(){
			$(this).next().css("display", "none");
		});
		
		// photo_original 이벤트
		$(document).on("mouseover", ".photo_original", function(){
			$(this).next().css("display", "block");
		});
		$(document).on("mouseout", ".photo_original", function(){
			$(this).next().css("display", "none");
		});
		
		// 삭제
		$(document).on("click", ".photodel", function(){
			let num = $(this).attr("num");
			$.ajax({
				type: "get",
				dataType: "text",
				url: "./delete",
				data: {"num":num},
				success: function (res) {
					list(); // 삭제 후 목록 다시 출력
				},
				statusCode: {
					404: function () {
						alert("Can't find json file!");
					},
					500: function () {
						alert("server error. one more view your code.");
					}
				}
			});
		});
	});
	
	function list(){
		$.ajax({
			type: "get",
			dataType: "json",
			url: "./list",
			success: function (res) {
				let s = "";
				$.each(res, function(idx, item){
					s += 
						// jsp이므로 $ 앞에 역슬래시를 붙임	
						`
						<div class="box">
							<img src="\${item.photo80}" onerror="this.src='../res/upload/noimage.jpg'; this.width=80; this.height=80;" align="left" hspace="10">
							<span>\${item.title}</span>
							<span style="margin-left: 20px; cursor: pointer; color: red;" class="photodel" num="\${item.num}">삭제</span>
							<br>
							<div class="photo150" style="cursor: pointer;">150 사진 확인</div>
							<div class="photo1" style="display: none;">
								<img src="\${item.photo150}">
							</div>
							<div class="photo_original" style="cursor: pointer;">원본 사진 확인</div>
							<div class="photo2" style="display: none;">
								<img src="\${item.photo}">
							</div>
						</div>
						`;
				});
			$("div.list").html(s);
			}
		});
	}
</script>
</head>
<body>
	<h4>스토리지에 사진 올리기</h4>
	<div class="input-group" style="width: 600px;">
		<input type="text" id="title" style="width: 200px;" class="form-control" placeholder="제목 넣기">
		<input type="file" id="upload" style="width: 200px;" class="form-control">
		<button type="button" id="btnsend">서버 전송</button>
	</div>
	80 x 80 사진 확인 : <img src="" class="photo80">
	<div class="list" style="margin: 20px;">목록</div>
</body>
</html>
