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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }  
</style>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<script type="text/javascript">
	$(function(){
		// 로그인 버튼
		$("#btnlogin").click(function(){
			let saveid = $("#saveid").is(":checked"); // true or false, let saveid = $("#saveid").val() => val()은 체크여부상관없이 무조건 "on"
			let myid = $("#login_myid").val();
			let pass = $("#login_pass").val();
			
			// alert("saveid : " + saveid + ", login_myid : " + login_myid);
			
			// $("#btnclose").trigger("click"); // 강제로 닫기 버튼 클릭하기
			
			$.ajax({
				type: "get",
				dataType: "json",
				url: "${root}/login/process",
				data: {"saveid":saveid, "myid":myid, "pass":pass},
				success: function (res) {
					// 성공 여부 : res.success
					if(res.success){
						$("#btnclose").trigger("click"); // 강제로 닫기 버튼 클릭하기
						location.reload();
					}
					else{
						alert("아이디나 비밀번호가 맞지 않습니다.");
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
		
		// 로그아웃 버튼
		$("#btnlogout").click(function(){
			$.ajax({
				type: "get",
				dataType: "text",
				url: "${root}/login/logout",
				success: function (res) {
					location.reload(); // 새로고침
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
		})
	});
</script>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<!-- The Modal -->
	<div class="modal" id="myLoginModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h6 class="modal-title">회원 로그인</h6>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <table class="table table-bordered">
	        	<caption align="top">
	        		<label>
		        		<c:if test="${sessionScope.saveid == null || sessionScope.saveid == 'no'}">
		        			<input type="checkbox" id="saveid">&nbsp;아이디 저장
		        		</c:if>
		        		<c:if test="${sessionScope.saveid == 'yes'}">
		        			<input type="checkbox" id="saveid" checked>&nbsp;아이디 저장
		        		</c:if>
	        		</label>
	        	</caption>
	        	<tr>
	        		<th width="100">아이디</th>
	        		<td>
		        		<c:if test="${sessionScope.saveid == null || sessionScope.saveid == 'no'}">
		        			<input type="text" id="login_myid" class="form-control">
		        		</c:if>
		        		<c:if test="${sessionScope.saveid == 'yes'}">
		        			<input type="text" id="login_myid" class="form-control" value="${sessionScope.myid}">
		        		</c:if>
	        		</td>
	        	</tr>
	        	
	        	<tr>
	        		<th width="100">비밀번호</th>
	        		<td>
	        			<input type="password" id="login_pass" class="form-control">
	        		</td>
	        	</tr>
	        </table>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success" id="btnlogin">로그인</button>
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="btnclose">닫기</button>
	      </div>
	
	    </div>
	  </div>
	</div>
		<a href="${root}/" style="font-size: 40px; line-height: 100px; margin-left: auto;">
			<img src="${root}/res/photo/고구마.gif" width="150" hspace="20">
			Chunsik's Home
			<img src="${root}/res/photo/고구마.gif" width="150" hspace="20">
		</a>
	<div style="text-align: center; width: 200px; position: fixed; right: 50px; top: 30px;">
		<c:if test="${sessionScope.loginok == null}">
		<button type="button" class="btn btn-success" style="width: 100px; color: black; background-color: #F0E68C;" data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
		</c:if>
		
		<c:if test="${sessionScope.loginok != null}">
			<img src="${root}/res/upload/${sessionScope.myphoto}" class="rounded-circle profile_photo" width="70" height="70" hspace="10" border="1" onerror="this.src='${root}/res/photo/noimage.jpg'"><br><br>
			<h5>${sessionScope.myname}님</h5>
			<div class="input-group">
				&nbsp;&nbsp;&nbsp;&nbsp;<i class="bi bi-gear photochange" style="font-size: 2em; cursor: pointer;"></i>&nbsp;&nbsp;
				<input type="file" id="profile_upload" style="display: none;">
				<button type="button" class="btn btn-success btn-sm" style="width: 100px;" id="btnlogout">로그아웃</button>
			</div>
		</c:if>
	</div>
	<br>
	<h6>Spring5 + Tiles3 + Mybatis3 Mini Project</h6>
	
	<script type="text/javascript">
		// 셋팅 아이콘 클릭 시 파일 업로드 이벤트 트리거
		$(".photochange").click(function(){
			$("#profile_upload").trigger("click");
		});
		
		// 파일 업로드 이벤트
		$("#profile_upload").change(function(){
			let form = new FormData();
			form.append("upload", $("#profile_upload")[0].files[0]);
			
			$.ajax({
				type: "post",
				dataType: "json",
				url: "${root}/login/photochange",
				processData: false,
				contentType: false,
				data: form,
				success: function (res) {
					$("img.profile_photo").attr("src",`${root}/res/upload/\${res.fileName}`); // 자바변수는 $ 쓸 때 그대로, 자바스크립트변수는 $ 앞에 역슬래시 붙이기
					location.reload();
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
	</script>
</body>
</html>
