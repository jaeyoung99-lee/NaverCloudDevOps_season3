<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="simpleboard.data.simpleBoardDAO"%>
<%@page import="simpleboard.data.simpleBoardDTO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MultipartRequest multipartRequest = null;

	String realPath = getServletContext().getRealPath("/save");
	System.out.println("path=" + realPath);
	int uploadSize = 1024 * 1024 * 5; // 5MB
	
	try{
		multipartRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
		
		// dao, dto 선언
		simpleBoardDAO dao = new simpleBoardDAO();
		simpleBoardDTO dto = new simpleBoardDTO();
		
		// 데이터 읽기(파일 포함)
		String writer = multipartRequest.getParameter("writer");
		String subject = multipartRequest.getParameter("subject");
		String content = multipartRequest.getParameter("content");
		// 업로드된 실제 파일명, 업로드 안했을 경우 null
		String photo = multipartRequest.getFilesystemName("upload"); // 업로드된 실제 파일명
		// null일 경우, "no"라고 저장
		if(photo==null){
			photo = "no";
		}
		
		// dto에 넣기
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setPhoto(photo);
		
		// insert 메서드 호출
		dao.insertBoard(dto);
		
		// list.jsp로 이동
		response.sendRedirect("list.jsp");
	}catch(Exception e){
		out.print("<h3>파일 업로드 오류 발생 : " + e.getMessage() + "</h3>");
	}
%>