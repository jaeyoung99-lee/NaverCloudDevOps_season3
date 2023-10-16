<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyshopDao"%>
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
<script type="text/javascript">
	$(function(){
		// 작은 이미지 클릭 시, num 얻어서 myshopDetail.jsp로 이동
		$("img.small").click(function(){
			let num = $(this).attr('num');
			// 페이지 이동
			// location.href="myshopDetail.jsp?num=" + num;
			// es6의 리터럴 문자 사용 시, jsp 자체적으로 $기능이 있으므로 앞에 \를 붙여서 변수 가져옴
			location.href=`myshopDetail.jsp?num=\${num}`;
		});
	});
</script>
<style>
	body * {
		font-family: 'Jua';
	}
	
	.shoptb thead tr th {
		background-color: #ccf;
		color: blue;
	}
	
	div.box {
		width: 60px;
		height: 60px;
		border: 1px solid black;
		border-radius: 100px;
	}
	
	img.small {
		width: 50px;
		height: 50px;
		cursor: pointer;
		border: 1px solid black;
		margin-right: 5px;
	}
</style>
</head>
<body>
<%
	// dao 선언
	MyshopDao dao = new MyshopDao();
	// list 가져오기
	List<MyShopDto> list = dao.getAllSangpums();
	// 날짜 출력하기 위한 형식
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH시");
%>
<div class="input-group" style="width:700px;">
	<h5 class="alert alert-danger" style="width:700px; text-align: center;">총 <%=list.size() %>개의 상품이 있습니다.
	<button type="button" class="btn btn-outline-info btn-sm" style="float: right;" onclick="location.href='myshopInform.jsp'">상품 등록</button>
	</h5>
</div>
<table class="table table-bordered shoptb" style="width:700px; text-align:center;">
	<thead>
		<tr>
			<th width="50">번호</th>
			<th width="150">상품명</th>
			<th width="80">색상</th>
			<th width="100">가격</th>
			<th width="150">등록일</th>
			<th width="50">삭제</th>
		</tr>
	</thead>
	<tbody>
		<%
			int n = 0;
			for(MyShopDto dto : list){%>
				<tr align="center">
					<td><%=++n %></td>
					<td align="left">
						<img class="small" src="../shop/<%=dto.getPhoto() %>" num="<%=dto.getNum() %>">
						<%=dto.getSangpum() %>
					</td>
					<td>
						<div class="box" style="background-color: <%=dto.getColor() %>"></div>
					</td>
					<td align="center"><%=dto.getPrice() %>원</td>
					<td><%=sdf.format(dto.getWriteday()) %></td>
					<td>
						<button type="button" class="btn btn-sm btn-danger del" num="<%=dto.getNum() %>">삭제</button>
					</td>
				</tr>
			<%}
		%>
	</tbody>
</table>
<script type="text/javascript">
	$(document).on("click", ".del", function(){
		let num = $(this).attr("num");
	
		let check = confirm("삭제하려면 [확인]을 눌러주세요");
		if(check){
			location.href="myshopDelete.jsp?num=" + num;
		}
	});
</script>
</body>
</html>