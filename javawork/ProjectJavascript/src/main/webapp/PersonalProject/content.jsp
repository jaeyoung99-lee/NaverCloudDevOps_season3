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
<title>상세 정보</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body * {
		font-family: 'Single Day';
	}
	
	.container {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        text-align: center;
        min-height: 100vh;
        margin: 0 auto; /* 가로 가운데 정렬 */
        width: 100%; /* 전체 너비를 사용하여 가로 간격을 균등하게 설정 */
        background-color: #FFFFE0;
    }

    .content-container {
        /* 내용 컨테이너에 대한 추가적인 스타일을 여기에 추가합니다 */
    }
	
	td {
    	text-align: center;
    	vertical-align: middle;
	}
</style>
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
			// 태그에 넣어둔 id, findLostId 가져오기
			let id = $(this).attr("id");
			let findLostId = $(this).attr("findLostId");
			
			// 댓글 삭제하는 파일로 이동
			location.href=`answerDelete.jsp?id=\${id}&findLostId=\${findLostId}`;
		}
	});
});
</script>
<body>
<div class="container">
	<div class="content-container">
		<div style="margin: 30px 50px;">
			<table class="table table-bordered" style="width: 600px;">
				<tr>
					<b style="font-size: 50px;"><%=dto.getName() %></b>
					&nbsp;&nbsp;
					<br>
					<span class="day" style="float: right; color: blue;">
						&nbsp;
						조회&nbsp;<%=dto.getReadcount() %>
					</span>
				</tr>
				<tr height="300" valign="top">
					<td style="font-size: 20px;">
						장소 : <b style="font-weight: bold;"><%=dto.getLostplace() %></b>
						<br>
						날짜 : <b style="font-weight: bold;"><%=dto.getLostday() %></b>
						<br>
						보상금 : <b style="font-weight: bold;"><%=dto.getMoney() %></b>
						<br><br>
						<%
							if(!dto.getPhoto().equals("no")){%>
								<img src="<%=dto.getPhoto() %>" style="max-width: 300px; border: 5px solid red; border-radius: 20px;">
							<%}
						%>
					</td>
				</tr>
				<tr>
					<td>
						<h6 class="acount" style="cursor: pointer;">댓글<%=alist.size() %><span style="color: gray;">&nbsp;&nbsp;← 댓글을 보려면 클릭하세요</span></h6>
						<div class="alist" style="margin-left: 20px; text-align: left;">
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
								<div class="input-group" style="width: 500px; margin: 0 auto;">
									<input type="text" name="nickname" class="form-control" style="text-align: center; margin-left: 5px; width: 130px;" placeholder="닉네임" required="required" autofocus="autofocus">
									<input type="text" name="content" class="form-control" style="text-align: center; margin-left: 5px; width: 130px;" placeholder="댓글" required="required">
									
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
		</div>
	</div>
</div>
</body>
</html>