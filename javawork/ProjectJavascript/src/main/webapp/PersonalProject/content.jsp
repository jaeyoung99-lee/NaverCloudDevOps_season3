<%@page import="java.util.List"%>
<%@page import="findLost.data.answerfindLostDao"%>
<%@page import="findLost.data.answerfindLostDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="findLost.data.findLostDao"%>
<%@page import="findLost.data.findLostDto"%>
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
</head>
<%
	int id = Integer.valueOf(request.getParameter("id"));

	findLostDao flDao = new findLostDao();
	// findLostId
	findLostDto dto = flDao.getData(Integer.valueOf(id));
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	answerfindLostDao afDao = new answerfindLostDao();
	// alist
	List<answerfindLostDto> alist = afDao.getFindLostAnswers(id);
	
%>
<script type="text/javascript">
$(function(){
	$("div.alist").hide(); // 처음에는 댓글 숨기기
	
	// 댓글 보이기&숨기기
	$("h6.acount").click(function(){
		$(this).next().slideToggle("fast");
	});
	
	// 댓글 삭제
	$(document).on("click", ".answerdel", function(){
		let a = confirm("삭제하려면 [확인]을 누르세요.");
		if(a){
			// 태그에 넣어둔 idx, num 가져오기
			let id = $(this).attr("id");
			let findLostId = $(this).attr("findLostId");
			
			// 댓글 삭제하는 파일로 이동
			location.href=`answerDelete.jsp?id=\${id}&findLostId=\${findLostId}`;
		}
	});
});
</script>
<body>
	<div style="margin: 30px 50px;">
		<table class="table table-bordered" style="width: 500px;">
			<tr>
				<h2><b><%=dto.getName() %></b></h2>
				&nbsp;&nbsp;
				<span class="day">
					&nbsp;
					조회&nbsp;<%=dto.getReadcount() %>
				</span>
			</tr>
			<tr height="300" valign="top">
				<td>
					<!-- 여러줄 일 경우 replace로 \n을 <br>로 변경하거나 <pre> 태그로 출력을 해야만 줄넘김 가능 -->
					장소 : <%=dto.getLostplace() %>
					<br>
					날짜 : <%=dto.getLostday() %>
					<br>
					보상금 : <%=dto.getMoney() %>
					<br><br>
					<%
						if(!dto.getPhoto().equals("no")){%>
							<img src="<%=dto.getPhoto() %>" style="max-width: 300px;">
						<%}
					%>
				</td>
			</tr>
			<tr>
				<td>
					<h6 class="acount" style="cursor: pointer;">댓글<%=alist.size() %></h6>
					<div class="alist" style="margin-left: 20px;">
						<%
							for(answerfindLostDto adto : alist){%>
								<b><%=adto.getNickname() %></b>
								: <span><%=adto.getContent() %></span>
								&nbsp;
								<span class="day"><%=sdf.format(adto.getWriteday()) %></span>
								<!-- 삭제 아이콘 -->
								&nbsp;&nbsp;
								<i class="bi bi-trash answerdel" style="cursor: pointer;" id="<%= adto.getId() %>" findLostId="<%= adto.getFindLostId() %>"></i>
								<br>
							<%}
						%>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center">
					<b>댓글</b>
					<div style="margin-bottom: 10px;">
						<form action="./answerInsert.jsp" method="post">
							<input type="hidden" name="findLostId" value="<%=id %>">
							<div class="input-group" style="width: 500px;">
								<input type="text" name="nickname" class="form-control" style="margin-left: 5px; width: 130px;" placeholder="닉네임" required="required" autofocus="autofocus">
								<input type="text" name="content" class="form-control" style="margin-left: 5px;" placeholder="댓글" required="required">
								
								<button type="submit" class="btn btn-sm btn-outline-success">저장</button>
							</div>
						</form>
					</div>
					<button type="button" class="btn btn-outline-success" style="width: 100px;" onclick="location.href='findLost_main.html'">목록</button>
					<button type="button" class="btn btn-outline-success" style="width: 100px;" onclick="location.href='updateForm.jsp?id=<%=dto.getId()%>'">수정</button>
					<button type="button" class="btn btn-outline-success" style="width: 100px;" onclick="location.href='contentDelete.jsp?id=<%=dto.getId()%>'">삭제</button>
				</td>
			</tr>
		</table>
</body>
</html>