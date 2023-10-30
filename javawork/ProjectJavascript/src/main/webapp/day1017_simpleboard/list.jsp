<%@page import="simpleboard.data.AnswerBoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.data.simpleBoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.data.simpleBoardDAO"%>
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
	
	a:link { /* 초기 a 링크에 적용 */
		text-decoration: none;
		color: black;
	}
	
	a:visited { /* 한 번이라도 클릭한 글에만 적용 */
		text-decoration: none;
		color: gray;
	}
	
	a:hover { /* a 태그에 마우스를 올렸을 때 */
		text-decoration: none;
		color: blue;
	}
	
	.photoicon {
		font-size: 0.8em;
		color: gray;
	}
</style>
</head>
<%
		// dao 선언
		simpleBoardDAO dao = new simpleBoardDAO();

		// 전체 데이터 가져오기
		List<simpleBoardDTO> list = dao.getAllList();
		
		// 날짜 형식
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
		
		// 댓글 dao 선언
		AnswerBoardDao adao = new AnswerBoardDao();
%>
<body>
	<div style="margin: 30px 50px;">
		<button type="button" class="btn btn-success btn-sm" onclick="location.href='boardForm.jsp'">글쓰기</button>
		<br>
		<h5><b>총 <%=list.size() %>개의 게시글이 있습니다</b></h5>
		<br>
		<table class="table table-striped" style="text-align: center; width: 800px;">
			<thead>
				<tr>
					<th width="50" style="border-right: 1px dotted gray;">번호</th>
					<th width="300" style="border-right: 1px dotted gray;">제목</th>
					<th width="80" style="border-right: 1px dotted gray;">작성자</th>
					<th width="100" style="border-right: 1px dotted gray;">작성일</th>
					<th width="70">조회</th>
				</tr>
			</thead>
			<tbody>
			<%
			if(list.size()==0){%>
				<tr height="50">
					<td colspan="5" align="center">
						<h5>등록된 글이 없습니다</h5>
					</td>
				</tr>
			<%}
			else{
				int n = 0;
				for(simpleBoardDTO dto : list){
					// 댓글 개수 가져오기
					int acount = adao.getBoardAnswers(dto.getNum()).size();
					
					// dto에 저장
					dto.setAnswercount(acount);
				%>
					<tr align="center">
						<td><%=list.size() - n++ %></td>
						<td align="center">
							<a href="content.jsp?num=<%=dto.getNum() %>">
								<%=dto.getSubject() %>
								<%
									if(!dto.getPhoto().equals("no")){%>
										<i class="bi bi-image photoicon"></i>
									<%}
								
									if(acount > 0){%>
										&nbsp;
										<span style="color: red">(<%=dto.getAnswercount() %>)</span>
									<%}
								%>
							</a>
						</td>
						<td><%=dto.getWriter() %></td>
						<td><%=sdf.format(dto.getWriteday()) %></td>
						<td><%=dto.getReadcount() %></td>
					</tr>
				<%}
			}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>