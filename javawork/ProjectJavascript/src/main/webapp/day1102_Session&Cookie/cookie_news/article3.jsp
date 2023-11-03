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
<style>
	body * {
		font-family: 'Jua';
	}
</style>
</head>
<%
	Cookie[] cookies = request.getCookies(); // 배열로 반환됨
	boolean find = false;
	if(cookies != null){
		for(Cookie ck : cookies){
			// 저장된 쿠키 이름을 얻기
			String name = ck.getName();
			if(name.equals("loginok")){
				find = true; // 해당 쿠키가 존재하면 true
			}
		}
	}
%>
<body>	
<%
	if(!find){%>
		<script type="text/javascript">
			alert("login first");
			history.back();
		</script>
	<%}else{%>
	<pre style="width: 500px;">
한국 축구대표팀 공격수 오현규(22·셀틱)가 교체 투입 9분 만에 골망을 가르며 강렬한 인상을 남겼다.

셀틱은 2일(한국시간) 스코틀랜드 글래스고의 셀틱 파크에서 열린 세인트 미렌과 2023~24시즌 스코틀랜드 프리미어십 11라운드에서 오현규의 결승 골에 힘입어 2-1로 이겼다. 셀틱은 개막 11경기 무패(9승 2무)를 질주, 1위 자리를 굳건히 지켰다.

이날 교체 명단에 이름을 올린 오현규는 후반 29분 교체 출전해 팀의 승리를 이끌었다. 올 시즌 8경기 만에 마수걸이 골을 터뜨렸다.

셀틱은 경기 시작 7분 만에 세인트 미렌의 코너 맥메나민에게 실점했다. 그러나 전반 18분 데이비드 던불의 동점 골로 균형을 맞췄다. 

셀틱은 좀체 득점이 터지지 않자 후반 들어 양현준, 오현규를 차례로 투입했다. 오현규가 브렌던 로저스 셀틱 감독의 믿음에 부응했다. 후반 38분 오딘 홀름이 패스한 볼을 페널티박스 정면에서 잡아 반 박자 빠른 강력한 오른발 슈팅으로 세인트 미렌의 골네트를 출렁였다.

무승부로 경기를 마칠 가능성이 컸던 셀틱은 오현규의 천금 같은 득점 덕에 선두 자리를 공고히 했다.
	</pre>
	<br><br>
	<a href="loginMain.jsp">메인패이지로 이동</a>
	<%}
%>
</body>
</html>