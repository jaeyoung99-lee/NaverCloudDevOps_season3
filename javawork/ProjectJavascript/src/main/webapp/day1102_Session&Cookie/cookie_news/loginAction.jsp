<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// pass를 읽는다
	String pass = request.getParameter("pass");
	
	// pass가 1234인 경우 loginok 라는 쿠키 생성 후 브라우저에 추가
	if(pass.equals("1234")){
		Cookie cookie = new Cookie("loginok", "yes");
		
		// 유지 시간 설정
		cookie.setMaxAge(60 * 60); // 1시간 유지(초 단위)
		
		// path : 저장되는 위치 지정
		cookie.setPath("/");
		
		// 브라우저에 쿠키 저장
		response.addCookie(cookie);
		
		// 메인 페이지로 이동
		response.sendRedirect("loginMain.jsp");
	}
	else{%>
		<script>
			alert("Incorrect password");
			history.back(); // 이전 페이지로 이동
		</script>
	<%}
%>