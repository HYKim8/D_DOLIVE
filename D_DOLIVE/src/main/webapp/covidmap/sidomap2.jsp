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
</head>
<body style="width:100%;height:100%;margin:0;padding:0;">
   
   <div style="">
        <p id="coivdupdatetime" style="color:gray; margin:0;"></p>
        <p id="clock" style="color:gray; margin:0;">00:00</p>
   </div>
   <div style="marge : 0 auto;">
   <div id="map" style="width:60%;height: 400px; marge : 0 auto;"></div>
   </div>
    
    <div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
        <div id="chart_div"></div>
        <div id="filter_div" style="width:100%;"></div>
    </div>
    
    <div class="ageChart" style="width:50%;">
      <canvas id="ageChart" ></canvas>
     <button onclick="ageConfirmer()">확진자</button>
     <button onclick="ageDead()">사망자</button>
     <button onclick="ageCFR()">치명률</button>
    </div>
    
     <div id="regions_div" style="width: 900px; height: 500px;"></div>
    
     <div id="curve_chart" style="width: 100%; height: 500px"></div>
    
        
   <script src="/d_dolive/resources/js/covidmap/sidomap.js"></script>
</body>
</html>