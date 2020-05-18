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
</head>
<body style="width:100%;height:100%;margin:0;padding:0;">
   
   <div style="height:30%;">
        <p id="coivdupdatetime" style="color:gray; margin:0;"></p>
        <p id="clock" style="color:gray; margin:0;">00:00</p>
   </div>
   <div id="map" style="width:100%;height:70%;"></div>


   <script src="/d_dolive/resources/js/covidmap/sidomap.js"></script>
</body>
</html>