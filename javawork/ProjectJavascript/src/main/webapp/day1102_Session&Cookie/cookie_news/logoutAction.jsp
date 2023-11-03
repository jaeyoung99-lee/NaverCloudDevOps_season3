<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<%
	// 전체 쿠키 중 loginok 쿠키를 찾아서 삭제 후 메인으로 이동한다
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie ck : cookies){
			if(ck.getName().equals("loginok")){
				// ck의 유지 시간과 path 다시 지정
				ck.setMaxAge(0);
				ck.setPath("/");
				
				// 브라우저에 다시 저장
				response.addCookie(ck);
				break;
			}
		}
	}
	
	response.sendRedirect("loginMain.jsp");
%>