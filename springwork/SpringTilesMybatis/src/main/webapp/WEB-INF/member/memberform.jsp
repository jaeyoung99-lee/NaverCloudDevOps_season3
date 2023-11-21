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
</style>
<script type="text/javascript">
	let idok = false;
	
	$(function(){
		$("#upload").change(function(){
			console.log("1:"+$(this)[0].files.length);
			console.log("2:"+$(this)[0].files[0]);
			
			//정규표현식
			var reg = /(.*?)\/(jpg|jpeg|png|bmp|gif)$/;
			var f=$(this)[0].files[0];//현재 선택한 파일
			if(!f.type.match(reg)) {
			   alert("확장자가 이미지파일이 아닙니다");
			   return;
			}
			
			if($(this)[0].files[0]) {
				var reader=new FileReader();
			    reader.onload=function(e){
			    	$("#showimg").attr("src",e.target.result);
			   	}
			   	reader.readAsDataURL($(this)[0].files[0]);
			}
		});
		
		// 중복체크 버튼 이벤트
		$("#btnidcheck").click(function(){
			// 입력한 아이디
			let myid = $("#myid").val();
			$.ajax({
				type: "get",
				dataType: "json",
				url: "./idcheck",
				data: {"myid":myid},
				success: function (res) {
					if(res.count != 0){
						alert("이미 가입된 아이디입니다.");
						idok = false;
						$("#myid").val("");
					}
					else {
						alert("사용 가능한 아이디입니다.");
						idok = true;
					}
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
		
		// 아이디 입력 시 발생하는 이벤트
		$("#myid").keyup(function(){
			idok = false;
		});
		
	}); // close function
	
	function check(){
		if(!idok){
			alert("중복체크 버튼을 눌러주세요.");
			return false;
		}
		
		let pass1 = $("#pass1").val();	
		let pass2 = $("#pass2").val();
		if(pass1 == pass2){
			return true; // action 호출
		}
		else{
			alert("두 개의 비밀번호가 서로 맞지 않습니다.");
			return false; // action이 호출되지 않음
		}
	}
</script>
</head>
<body>
	<div>
		<button type="button" class="btn btn-outline-success" style="width: 100px; margin-left: auto;" onclick="location.href='./list'">회원현황</button>
		<form action="./addmember" method="post" enctype="multipart/form-data" onsubmit="return check()" style="margin-left: 70px;">
			<table class="table table-bordered" style="width: 500px; margin: 30px; text-align: center;">
				<caption align="top"><b>회원가입</b></caption>
				<tr>
					<td rowspan="4" width="150" align="center">
						<img id="showimg" style="width: 150px; height: 150px; margin-bottom: 10px;" src="../res/photo/noimage.jpg">
						<br>
						<button type="button" class="btn btn-secondary" onclick="$('#upload').trigger('click')">사진선택</button>
						<input type="file" name="upload" id="upload" style="display: none;">
					</td>
					<td width="100">닉네임</td>
					<td>
						<input type="text" class="form-control" required="required" autofocus=autofocus" name="name">
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td class="input-group">
						<input type="text" name="myid" id="myid" class="form-control" required="required">
						<button type="button" class="btn btn-danger btn-sm" id="btnidcheck">중복체크</button>
					</td>
				</tr>
				<tr>
					<td rowspan="2" valign="middle">비밀번호</td>
					<td>
						<input type="password" name="pass" id="pass1" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" id="pass2" class="form-control">
					</td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td colspan="2">
						<input type="text" name="hp" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="2">
						<input type="email" name="email" class="form-control">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button type="submit" class="btn btn-secondary">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
