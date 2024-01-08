<%@page import="findLost.data.findLostDto"%>
<%@page import="findLost.data.findLostDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	MultipartRequest multipartRequest = null;

	String realPath = getServletContext().getRealPath("/PersonalProject/Images/");
	int uploadSize = 1024 * 1024 * 5; // 5MB
	
	try{
		multipartRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
		
		// dao, dto 선언
		findLostDao dao = new findLostDao();
		findLostDto dto = new findLostDto();
		
		// 데이터 읽기(파일 포함)
		String name = multipartRequest.getParameter("name");
		// 업로드된 실제 파일명, 업로드 안했을 경우 null
		String photo = "./Images/" + multipartRequest.getFilesystemName("upload"); // 업로드된 실제 파일명
		// null일 경우, "no"라고 저장
		if(photo==null){
			photo = "no";
		}
		String lostplace = multipartRequest.getParameter("lostplace");
		if (lostplace.equals("")) {
			lostplace = "정보 없음";
		}
		String lostday = multipartRequest.getParameter("lostday");
		if (lostday.equals("")) {
			lostday = "정보 없음";
		}
		String money = multipartRequest.getParameter("money");
		int id = Integer.parseInt(multipartRequest.getParameter("findLostId"));
		
		// dto에 넣기
		dto.setName(name);
		dto.setPhoto(photo);
		dto.setLostplace(lostplace);
		dto.setLostday(lostday);
		dto.setMoney(money);
		dto.setId(id);
		
		// update 메서드 호출
		dao.updateLost(dto);
		
		// findLost_main.html로 이동
		response.sendRedirect("findLost_main.html");
	}catch(Exception e){
		out.print("<h3>파일 업로드 오류 발생 : " + e.getMessage() + "</h3>");
	}
%>