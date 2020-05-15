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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="cancelPay()">환불하기</button>
	<input type="button" value="환불" id="cancle"/>
<script
    src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
    crossorigin="anonymous"></script><!-- jQuery CDN --->
  <script>
function cancelPay() {
    jQuery.ajax({
      "url": "http://www.myservice.com/payments/cancel",
      "type": "POST",
      "contentType": "application/json",
      "data": JSON.stringify({
    	 	"imp_uid": "imp_120399097759", // 주문번호
        	"reason": "테스트 결제 환불" // 환불사유
      }),
      "dataType": "json"
    });
  }
	
	
</script>
</body>
</html>