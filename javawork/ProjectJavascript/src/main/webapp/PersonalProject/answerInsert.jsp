<%@page import="findLost.data.answerfindLostDao"%>
<%@page import="findLost.data.answerfindLostDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 한글 인코딩
	request.setCharacterEncoding("utf-8");
	
	// dto 선언
	answerfindLostDto dto = new answerfindLostDto();
	
	// dao 선언
	answerfindLostDao dao = new answerfindLostDao();
	
	// 데이터 읽어서 dto에 담기
	int findLostId = Integer.valueOf(request.getParameter("findLostId"));
	String nickname = request.getParameter("nickname");
	String content = request.getParameter("content");
	
	
	dto.setFindLostId(findLostId);
	dto.setNickname(nickname);
	dto.setContent(content);
	
	// insert 메소드 호출
	dao.insertAnswer(dto);
	
	// content로 이동(num을 필요로 함)
	response.sendRedirect("./content.jsp?id=" + findLostId);
%>