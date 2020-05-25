<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 12.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/common.jsp" %>

<!DOCTYPE html>
<html style="width:100%;height:100%;margin:0;padding:0;">
<head>
<meta charset="UTF-8">
<title>지역별 확진자 현황</title>
   <!-- 전국 확진자 현황 -->
   <script src="https://livecorona.co.kr/data/koreaRegionalData.js"></script>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=43aece2f44d2c157208d1b90434bfa71&libraries=services"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
      <script src="https://livecorona.co.kr/data/koreaRegionalCumulativeData.js"></script>
      <script src="https://livecorona.co.kr/data/worldData.js"></script>
      <script src="https://livecorona.co.kr/data/worldCumulativeData.js"></script>
      
      <style type="text/css">
        ::-webkit-scrollbar{-webkit-appearance: none;}
		  /* 기본 스크롤바를 안보이게 함 */
		::-webkit-scrollbar-track-piece{background-color:#FFF;}
		  /* 양 끝 화살표와 몸통 바를 제외한 길 */
		::-webkit-scrollbar:vertical{width:15px;}
		  /* 가로 스크롤바의 크기 horizontal, 세로는 vertical*/
		::-webkit-scrollbar-thumb{background-color:#FFF;border-radius:10px;border: 2px solid #d4d4d4;} 
		  /* 실제로 움직이는 몸통 바 */
		  
		::-webkit-scrollbar-button:vertical:increment {
		   display:none;
		    /* background: url(/img/arrow_down.png) no-repeat center 50%; */
		}
		::-webkit-scrollbar-button:vertical:decrement {
		   display:none;
		    /* background: url(/img/arrow_up.png) no-repeat center 50%; */
		}
		
		.title{
		      height:174px;
		      box-shadow: 0px 0px 5px #2c3e50;
		}
		
		.navegation{
		  width : 220px;
		  position : fixed;
		  right: 3%;
		  top: 330px;
		  border: 1px solid black;
		}
		
		.chartContainer{
		  margin: 15px auto 20px auto;
		}
		.nave{
		  cursor: pointer;
		  text-indent : 10px;
           width : 220px;
           overflow : hidden;
           height:25px;
           line-height:25px;
		}
		.nave:hover{color:#FFF;background-color:#000;}
        .nave:hover::after{    content: "\27A5";
            width: 16px;
            float: left;}
		.moveTop:hover{color:#FFF;background-color:#000;}
		.moveTop:hover::before{    content: "◔∏◔"; margin: 0 10px 0 0;
            width: 16px;
            display : inline;}
      </style>
</head>
<body style="width:100%;height:100%;margin:0;padding:0;">
   
   <div class="title">
        <div style="font-size: 52px; font-weight:800; margin: 0 0 0 20%; padding: 40px 0 0 0;">코로나 현황</div>
        <div style="float:right;">
            <p id="coivdupdatetime" style="color:gray; margin:0; "></p>
            <p id="clock" style="color:gray; margin:0; ">00:00</p>
        </div>
   </div>
   
   <div class="navegation">
        <div style="border-bottom:1px solid black; text-align: center;">메뉴</div>
        <div class="nave" data-location="sidomap">시도별 확진자 현황</div>
        <div class="nave" data-location="koreachart">한국 일일 코로나 증가추이</div>
        <div class="nave" data-location="agechart">연령별 현황</div>
        <div class="nave" data-location="worldmap">세계 확진자/사망자 현황</div>
        <div class="nave" data-location="worldchart">일일 세계 코로나 현황</div>
   </div>
        <div class="navegation moveTop" onclick="moveTop()" style="top:494px; cursor: pointer; height:25px; line-height:22px; text-align : center;">top</div>
   
   <div class="chartContainer sidomap" style="width : 60%;">
     <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
         <h6 class="m-0 font-weight-bold text-danger">시도별 확진자 현황</h6>
     </div>
        <div id="map" style="height: 500px;"></div>
   </div>
    
    <div class="chartContainer koreachart" style="width : 60%;">
	   <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
	      <h6 class="m-0 font-weight-bold text-danger">한국 일일 코로나 증가추이</h6>
	   </div>
	   <div id="dashboard_div">
	     <!--Divs that will hold each control and chart-->
	       <div id="chart_div"></div>
	       <div id="filter_div" style="width:100%;"></div>
	   </div>
    </div>
    
    <div class="chartContainer agechart" style="width : 60%;">
	    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
	        <h6 class="m-0 font-weight-bold text-danger">연령별 현황</h6>
	    </div>
	    <div class="ageChart">
		    <canvas id="ageChart" ></canvas>
		    <button onclick="ageConfirmer()">확진자</button>
		    <button style="margin: 0 15px;"onclick="ageDead()">사망자</button>
		    <button onclick="ageCFR()">치명률</button>
	    </div>
    </div>
    
     <div class="chartContainer worldmap" style="width : 60%;">
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-danger">세계 확진자/사망자 현황</h6>
        </div>
        <div id="regions_div" style="width: 100%; height: 500px;"></div>
      </div>
    
    <div class="chartContainer worldchart" style="width : 60%;">
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-danger">일일 세계 코로나 현황</h6>
        </div>
        <div id="curve_chart" style="width: 100%; height: 500px"></div>
     </div>
        
   <script src="/d_dolive/resources/js/covidmap/sidomap.js"></script>
   <script src="/d_dolive/resources/js/jquery-migrate-1.4.1.js"></script>
   <script type="text/javascript">
   $(document).on("click",".nave",function(e){
	   e.preventDefault();
       const nave = $(e.target);
       const loc = nave.attr("data-location");
       const ps = $(".chartContainer."+loc+"").offset().top;
       window.scrollTo({top:ps-104,behavior:"smooth"});
       });
   function moveTop(){
	   window.scrollTo({top:0,behavior:"auto"});
	   }
   </script>
</body>
</html>