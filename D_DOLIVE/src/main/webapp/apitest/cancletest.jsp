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
	<input type="button" value="환불" id="cancle"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" ></script>
<script type="text/javascript">
	$("#cancle").on("click",function(){
		//alert("성공");
		//ajax
		$.ajax({
		    type : "POST",
		    url : "https://api.iamport.kr/payments/cancel",
		    dataType : "json",
		    data : {
		        "imp_uid" : "imp_229901617008"
		    },
		    success : function(data) { //성공
				alert("성공");	
		    },
		    error : function(xhr, status, error) {
		    	alert("실패");	
		    },
		    complete : function(data) {
		
		    }
	
		});//--ajax
	});
	
	
</script>
</body>
</html>