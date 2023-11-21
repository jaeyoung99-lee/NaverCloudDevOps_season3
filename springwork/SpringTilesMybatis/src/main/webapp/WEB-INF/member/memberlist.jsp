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
	let field = "";
	let word = "";
	
	$(function(){
		list(); // 처음 로딩 시 전체 회원 출력
		
		// 검색 버튼 이벤트
		$("#btnsearch").click(function(){
			field = $("#field").val();
			word = $("#word").val();
			list();
		});
		
		// 탈퇴 이벤트
		$(document).on("click", ".memberdel", function(){
			let a = confirm("해당 회원을 탈퇴시키려면 [확인]을 눌러주세요.");
			if(a){
				let num = $(this).attr("num");
				$.ajax({
					type: "get",
					dataType: "text",
					url: "./delete",
					data: {"num":num},
					success: function (res) {
						word=""; // 전역 변수라 마지막 검색 단어를 갖고 있으므로 초기화 해줌
						list(); // 삭제 후 전체 목록 다시 출력
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
	});
	
	function list(){
		$.ajax({
			type: "get",
			dataType: "json",
			url: "./search",
			data: {"field":field, "word":word},
			success: function (res) {
				let s = "";
				
				s += 
					`
					<table class="table table-bordered" style="width: 800px; margin: 0 auto;">
						<thead>
							<tr>
								<th width=200>닉네임</th>
								<th width=115>아이디</th>
								<th width=150>전화번호</th>
								<th width=200>이메일</th>
								<th width=200>가입일</th>
								<th width=55>탈퇴</th>
							</tr>
						</thead>
						<tbody>
					`;
				$.each(res, function(idx, item){
					let imgsrc = item.photo == "no photo" ? "../res/photo/noimage.jpg" : "../res/upload/" + item.photo;
					// let imgsrc = item.photo == "no photo" ? "../res/photo/noimage.jpg" : `../res/upload/\${item.photo}`; // 위의 코드와 같음(백틱(`) 쓸 때의 코드)
					s +=
						`
						<tr>
							<td><img src="\${imgsrc}" width="50" height="50" class="rounded-circle" hspace="5" border="1">\${item.name}</td>
							<td>\${item.myid}</td>
							<td>\${item.hp}</td>
							<td>\${item.email}</td>
							<td>\${item.gaipday}</td>
							<td>
								<span class="memberdel" num="\${item.num}" style="cursor: pointer; color: red;">탈퇴</span>
							</td>
						</tr>
						`;
				});
				
				s += "</tbody></table>";
				$("div.searchlist").html(s);
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
	<div>
		<h4>현재 총 <b style="color: orange; font-size: 40px;">${totalCount}</b>명의 회원이 있습니다.</h4>
		<br><br>
		<div class="input-group" style="width: 400px; margin: 0 auto;">
			<select id="field" class="form-select">
				<option hidden disabled selected>검색할 필드</option>
				<option value="name">닉네임</option>
				<option value="myid">아이디</option>
				<option value="hp">전화번호</option>
				<option value="email">이메일</option>
			</select>
			<input type="text" class="form-control" style="margin-left: 10px;" id="word" placeholder="검색 값 입력">
			<button type="button" class="btn btn-success btm-sm" id="btnsearch"	style="margin-left: 10px;">검색</button>
		</div>
		<br>
	</div>
		<div class="searchlist" style="width: 100%; margin-top: 20px;"></div>			
</body>
</html>
