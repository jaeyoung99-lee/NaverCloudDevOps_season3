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
   
   .memoform {
   	   position: absolute;
   	   top: 150px;
   	   left: 50px;
   }
   
   .memolist {
   	   position: absolute;
   	   top: 150px;
   	   left: 400px;
   }
   
   .photo, .photo2 {
   	   width: 120px;
   	   height: 120px;
   	   border: 1px solid gray;
   	   border-radius: 30px;
   	   box-shadow: 5px 5px 5px gray;
   }
   
   .cameraupload {
   	   font-size: 30px;
   	   cursor: pointer;
   }
   
   div.box {
   	   width: 500px;
   	   height: 150px;
   	   padding: 10px;
   	   border: 2px solid gray;
   	   box-shadow: 3px 3px 3px gray;
   	   margin-bottom: 10px;
   	   border-radius: 20px;
   }
</style>
<script type="text/javascript">
	$(function(){
		list(); // 처음 로딩 시 기존 메모들 출력
		
		$(".cameraupload").click(function(){
			$("#upload").trigger("click");
		});
		
		// 파일 선택 시 이벤트
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
				url: "./upload",
				processData: false,
				contentType: false,
				data: form,
				success: function (res) {
					// alert(res); // 랜덤 파일명 확인 후 이미지 출력
					$(".photo").attr("src", `../res/upload/\${res}`);
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
		
		$("#btnmemoadd").click(function(){
			let nick=$("#nickname").val();
			let memo=$("#memo").val();
			
			if(nick.length == 0){
				alert("닉네임 입력하시오.");
				return;
			}
			
			if(memo.length == 0){
				alert("메모 입력하시오.");
				return;
			}
			
			$.ajax({
				type: "get",
				dataType: "text",
				url: "./add",
				data: {"nickname":nick, "memo":memo},
				success: function (res) {
					// 다시 메모 전체 출력
					list();
					
					// 입력값들 지우기
					$("#nickname").val("");
					$("#memo").val("");
					$(".photo").attr("src", "../res/upload/noimage.jpg");
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
		
		// 메모 삭제
		$(document).on("click", ".memodel", function(){
			let num = $(this).attr("num");
			let a = confirm("삭제하려면 확인");
			if(a){
				$.ajax({
					type: "get",
					dataType: "text",
					url: "./delete",
					data: {"num":num},
					success: function (res) {
						// 삭제 후 목록 다시 출력
						list();
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
			}
		});
		
		// 좋아요 수 증가하기
		$(document).on("click", ".increlikes", function(){
			let num = $(this).attr("num");
			let $prev = $(this).prev();
			$.ajax({
				type: "get",
				dataType: "json",
				url: "./likes",
				data: {"num":num},
				success: function (res) {
					$prev.text(res.likes);
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
		
	}); // function close
	
	function list(){
		// 전체 메모 출력해주는 함수
		$.ajax({
			type: "get",
			dataType: "json",
			url: "./view",
			success: function (res) {
				let s = "";
				$.each(res, function(idx, item){
					s+=
						`
						<div class="box">
							<img src="../res/upload/\${item.photo}" class="photo2" align="left" hspace="20">
							
							닉네임 : \${item.nickname}<br>
							메모 : \${item.memo}<br>
							작성일 : \${item.writeday}<br>
							추천수 : \<span>\${item.likes}</span><i class="bi bi-suit-heart increlikes" style="cursor: pointer; color: red; margin-left: 5px;" num="\${item.num}"></i><br>
							<a href="#" class="memodel" num="\${item.num}" style="cursor: pointer; color: blue;">삭제</a>
						</div>
						`;
				});
				$(".memolist").html(s);
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
	}
</script>
</head>
<body>
	<h3 class="alert alert-success">간단한 메모를 남겨봅시다</h3>
	<div class="memoform">
		<i class="bi bi-camera-fill cameraupload"></i>
		<input type="file" name="upload" id="upload" style="display: none;">
		<br>
		<img src="../res/upload/noimage.jpg" class="photo">
		<br><br>
		<input type="text" id="nickname" class="form-control" style="width: 200px;" placeholder="닉네임 입력">
		<input type="text" id="memo" class="form-control" style="width: 300px;" placeholder="메모 메시지">
		<button type="button" class="btn btn-sm btn-outline-danger" id="btnmemoadd">Memo Add</button>
	</div>
	
	<div class="memolist">
		memo list
	</div>
</body>
</html>
