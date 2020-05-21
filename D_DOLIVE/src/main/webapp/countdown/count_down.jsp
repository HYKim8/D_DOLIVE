<%@page import="org.jsoup.select.Elements"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sist.d_dolive.countdown.Parser"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8"">
<title>COREA MASK TIMER</title>

<style>
.countdown {
	text-align: center;
	margin-bottom: 20px;
}

.countdown2 {
	text-align: center;
	margin-bottom: 20px;
}

.countdown .timeel {
	display: inline-block;
	padding: 10px;
	background: #151515;
	margin: 0;
	color: white;
	min-width: 2.6rem;
	margin-left: 13px;
	border-radius: 10px 0 0 10px;
}

.countdown span[class*="timeRef"] {
	border-radius: 0 10px 10px 0;
	margin-left: 0;
	background: #e8c152;
	color: black;
}

.powerup {
	display: inline-block;
	padding: 10px;
	background: #e8c152;
	margin: 0;
	color: white;
	min-width: 2.6rem;
	margin-left: 13px;
	border-radius: 10px 0 0 10px;
}
</style>

</head>
<body>



	<%
		Parser ps = new Parser(); //객체 생성

		List<String> newlist = ps.Parse(); //카운트다운 메서드에 넣을 날짜용 크롤링  ex)990원 [걸리버] KF94 휴그린 미세먼지 방역마스크 (5매) 개당 : 990원 / 시작: 2020/05/12 13:00

		Elements sitelist = ps.ParseSite(); //클릭시 연결 사이트 이동용 크롤링 ex)https://smartstore.naver.com/soommask/products/4828127993
	%>

	<div class="countdown2">

		<h1>MASK COUNT DOWN SERVICE</h1>

	</div>

	<!-- 카운트 다운 나오는 판 -->
	<div class="countdown" id="count1">
		<h2>시간 확인</h2>
		<span class="timeel days">00</span> <span class="timeel timeRefDays">days</span>
		<span class="timeel hours">00</span> <span class="timeel timeRefHours">hours</span>
		<span class="timeel minutes">00</span> <span class="timeel timeRefMinutes">minutes</span> 
		<span class="timeel seconds">00</span> <span class="timeel timeRefSeconds">seconds</span>
		<hr>
	</div>
	<!-- 카운트 다운 나오는 판 END-->


	<!-- 판매중인 마스크 리스트 뽑기 + 해당 URL 연결 -->
	
	<%	//리스트 크기만큼 반복
		for (int i = 0; i < newlist.size(); i++) { 
			
			 // 2020/05/19 09:00 이런 형식 가진 애들만 찍기위해서.. 문자열 잘라서 체크
			if (newlist.get(i).substring(newlist.get(i).length() - 3, newlist.get(i).length() - 2).equals(":")) {
	%>
 
	<div>
		<!-- 사이트 링크 -->
		<h4><%=sitelist.get(i)%></h4>
		<!-- 사이트 링크 END-->
		
		<!-- 카운트 다운 버튼 // 클릭시 날짜(ex: 2020/05/19 09:00)만 잘라서 countDownToTime 메서드로-->
		<input class="powerup" type="button" value="CountDown"
			onclick=" countDownToTime('<%=newlist.get(i).substring(newlist.get(i).length() - 16, newlist.get(i).length())%>','count1'); " />
		<!-- 카운트 다운 버튼 END-->

	</div>



	<hr>

	<%
		}
	}
	%>

	<!-- 판매중인 마스크 리스트 뽑기 + 해당 URL 연결 END -->



	<script>
		window.onload = function() {
				
		}
		function countDownToTime(i, id) {

			countTo = new Date(i).getTime();
			var now = new Date(), countTo = new Date(countTo), timeDifference = (countTo - now);

			var secondsInADay = 60 * 60 * 1000 * 24, secondsInAHour = 60 * 60 * 1000;

			days = Math.floor(timeDifference / (secondsInADay) * 1);
			hours = Math.floor((timeDifference % (secondsInADay))
					/ (secondsInAHour) * 1);
			mins = Math
					.floor(((timeDifference % (secondsInADay)) % (secondsInAHour))
							/ (60 * 1000) * 1);
			secs = Math
					.floor((((timeDifference % (secondsInADay)) % (secondsInAHour)) % (60 * 1000)) / 1000 * 1);

			var idEl = document.getElementById(id);
			idEl.getElementsByClassName('days')[0].innerHTML = days;
			idEl.getElementsByClassName('hours')[0].innerHTML = hours;
			idEl.getElementsByClassName('minutes')[0].innerHTML = mins;
			idEl.getElementsByClassName('seconds')[0].innerHTML = secs;

			clearTimeout(countDownToTime.interval);
			countDownToTime.interval = setTimeout(function() {
				countDownToTime(countTo, id);
			}, 1000); 
		}
	</script>



</body>
</html>