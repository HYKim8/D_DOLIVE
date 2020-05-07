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

.powerup{
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

	<script>
//	window.onload = function() {
		// Month Day, Year Hour:Minute:Second, id-of-element-container
//		countDownToTime("Jan 5, 2021 15:00:00", 'a'); // ****** Change this line!
//	}
		

		
	</script>
	
	<%
		Parser ps = new Parser();
		

	List<String> newlist = ps.Parse();
	Elements sitelist= ps.ParseSite();
	
	%>
<div class="countdown2" >
		
<h1>MASK COUNT DOWN SERVICE</h1>

</div>
<div class="countdown" id="count1">
		<h2> 시간 확인 </h2>
			<span class="timeel days">00</span> <span class="timeel timeRefDays">days</span>
			<span class="timeel hours">00</span> <span class="timeel timeRefHours">hours</span> 
			<span class="timeel minutes">00</span> <span class="timeel timeRefMinutes">minutes</span>
			<span class="timeel seconds">00</span> <span class="timeel timeRefSeconds">seconds</span>
			<hr>
		</div>
	<!-- 판매중인 마스크 리스트 뽑기+ 해당 URL 연결 -->
	<% 	
	
		for(int i=0; i<newlist.size();i++){
			
	//	System.out.println("현재 i값은:"+i+"\n내용은:"+newlist.get(i).substring(newlist.get(i).length()-16, newlist.get(i).length()));
		//System.out.println("현재 i값은:"+i+"\n내용은:"+newlist.get(i).substring(newlist.get(i).length()-2, newlist.get(i).length()));
			if(newlist.get(i).substring(newlist.get(i).length()-3, newlist.get(i).length()-2).equals(":")){
				
			
	%>

	
		<div >
			<h4><%=sitelist.get(i) %></h4>
			
			<input class="powerup" type="button" value="CountDown" onclick=" countDownToTime('<%=newlist.get(i).substring(newlist.get(i).length()-16, newlist.get(i).length())%>','count1'); " />
			
			
		</div>
	


		<hr>

	<% 
		}
			}
	%>
	
		<!-- 판매중인 마스크 리스트 뽑기+ 해당 URL 연결 -->
		
	

<script>
			window.onload = function() {
				
				// Month Day, Year Hour:Minute:Second, id-of-element-container
				
			
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