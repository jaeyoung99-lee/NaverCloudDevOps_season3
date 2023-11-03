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
김민재(바이에른 뮌헨)가 고개를 숙였다. 독일 3부리그 FC 자르브뤼켄전에서 연이은 실수로 실점을 막지 못한 탓이다. 오롯이 김민재만의 실수들로 보긴 어려웠지만, 평소 그가 보여주던 수비력을 돌아보면 분명 김민재답지 않은 치명적인 실수들이었다. 바이에른 뮌헨은 3부리그에서도 하위권에 머무른 자르브뤼켄에 져 자존심을 잔뜩 구겼다.

김민재는 2일(한국시간) 독일 자르브뤼켄의 루트비히스파르크 슈타디온에서 열린 2023~224 DFB(독일축구협회) 포칼 2라운드 자르브뤼켄전에 선발 풀타임 출전했지만 전반 추가시간 동점골 실점 장면에서 연이은 실수를 저지른 뒤 고개를 숙였다. 안일한 패스로 역습 위기를 초래한 뒤, 실수를 만회하기 위한 마지막 태클마저 무위로 돌아가면서 결국 동점골 실점의 빌미를 제공했다.

이 장면 외에 김민재는 공·수 양면에 걸쳐 존재감을 보여줬지만, 최후방 수비수로서 뼈아픈 실점 장면에 관여한 걸 만회하진 못했다. 실제 이날 김민재는 패스 성공률 92%(130회 시도·120회 성공)에 공격지역 패스 10회, 롱패스 성공률 50%(6회 시도·3회 성공) 등을 기록했고, 수비 지역에서도 리커버리 10회, 클리어링 3회 등을 기록했지만 앞선 실수 탓에 빛이 바랬다.
	</pre>
	<br><br>
	<a href="loginMain.jsp">메인패이지로 이동</a>
	<%}
%>
</body>
</html>