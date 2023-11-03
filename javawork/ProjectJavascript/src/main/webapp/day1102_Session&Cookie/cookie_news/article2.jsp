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
영국 매체 ‘더 부트 룸’은 미국 대표팀 출신으로 현재는 축구 해설가로 활동 중인 야누시 미할리크가 케인의 이적이 손흥민에게 미치는 영향에 대해 언급한 내용을 전했다.

미할리크는 “케인이 없는 것이 토트넘 홋스퍼에 더 좋은가? 안 좋은가? 이제는 손흥민이 있다”고 언급했다.

이어 “케인이 떠난 건 손흥민에게 이득이다. 그가 없다면 토트넘에 중대한 문제가 될 것이다”고 존재감을 거론했다.

‘더 부트 룸’은 “케인에 대한 논쟁은 이상하다. 엔제 포스테코글루 감독에게 선택권이 있었다면 잔류가 아닌 이적을 선택했을 가능성은 전혀 없다”고 바라봤다.

그러면서 “케인 이적 후 토트넘은 발전했다. 손흥민은 확실하게 뛰어나다. 눈부신 활약을 펼쳤을 뿐만 아니라 초기 성공을 이끄는 놀라운 리더라는 걸 입증했다”며 팀 입장에서 새로운 계기가 됐다고 언급했다.

이어 “손흥민은 케인의 공백을 메우면서 세계적인 공격수임을 입증했다. 지난 시즌 아쉬웠지만, 이번 시즌은 즐기고 있다. 제임스 매디슨과 놀라운 파트너십을 맺었다”고 활약상을 조명했다.
	</pre>
	<br><br>
	<a href="loginMain.jsp">메인패이지로 이동</a>
	<%}
%>
</body>
</html>