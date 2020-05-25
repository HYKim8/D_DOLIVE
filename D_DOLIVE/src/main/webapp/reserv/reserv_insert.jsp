<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 19.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/common/common.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>예약 페이지</title>

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    				
    	.paddingMain {padding:100px 400px 160px;	}
    				
    	.paddingTitle {padding-bottom:50px}
    	
    	.paddingButton {padding-bottom:30px}
    	
    </style>
</head>
<body>
	<!-- div container -->
   	<div class="container, paddingMain">
   	
      	<!-- div title --> 
      	<div class="page-header">
      		<div class="paddingTitle">
	        	<h2>마스크 예약</h2>
      		</div>
      	</div>      	
      	<!--// div title -->
      	
        <div class="paddingButton">
			<label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"></label>
		    <div style="float:right;">
				<input type="button" class="btn btn-primary btn-sm" value="예약하기" id="insertBtn" />
				<input type="button" class="btn btn-primary btn-sm" value="돌아가기" id="returnBtn" />
			</div>
		</div>
		
      	<!-- div title -->
      	<form class="form-horizontal" action="${hContext }/reserv/do_insert.do" name="insertFrm" method="post">
      	<!-- hidden으로 변경! -> 회원아이디 session 처리, 약국코드 가지고 넘어오기 -->
      	<input type="hidden" id="email" name="email" value="bealright6@naver.com">
      	<input type="hidden" id="pcode" name="pcode" value="약국 코드">

	      	<div class="form-group">
   				<select name="maskCnt" id="maskCnt" class="form-control input-sm">
   				<!-- 마스크 수량 셀렉트 -->
   					<option value="1">1</option> 
					<option value="2">2</option>
					<option value="3">3</option>
   				</select>
	      	</div>
   		</form>
 	</div>  
 	
 	
 	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${hContext}/resources/js/bootstrap.min.js"> </script>
    
    
    <script type="text/javascript"> 

		function goMain(){
			//!!!!!!!!!!!!!!!!주소 매핑 변경!!!!!!!!!!!!!!!!
			location.href = "${hContext}/covidmap/sidomap.do"
		}

    
    	$("#insertBtn").on("click", function(){
        	//console.log("insertBtn");

        	var rno = "rno";
        	var pcode = $("#pcode").val();
        	var maskCnt = $("#maskCnt").val();
        	var approval = 1;
        	var amount = maskCnt*1500;
        	var regId = $("#email").val();
        	var regDt = "sysdate";
        	var modId = $("#email").val();
        	var modDt = "sysdate";

        	if(confirm(maskCnt+"개를 예약하시겠습니까?") == false) return;

			//ajax
			$.ajax({
				type : "POST",
				url : "${hContext}/reserv/do_insert.do",
				dataType : "html",
				data : {
					"rno" : rno
					, "pcode" : pcode
					, "maskCnt" : maskCnt
					, "approval" : approval
					, "amount" : amount
					, "regId" : regId
					, "regDt" : regDt
					, "modId" : modId
					, "modDt" : modDt
				},
				success : function(data) { //성공
					//alert(data);
					
					var jData = JSON.parse(data);
					if(jData != null && jData.msgId=="1") {
						alert(jData.msgMsg);
						//!!!!!!!!!!!!지도 메인 페이지로 주소 매핑!!!!!!!!!!!!!
						
					}else {
						alert(jData.msgMsg);
					}
				},
				error : function(xhr, status, error) {
					alert("error:"+error);
				},
				complete : function(data) {
	
				}
			});//--ajax
        	
        });


    	$("#returnBtn").on("click", function(){
    		if(confirm("메인 화면으로 돌아가시겠습니까?") == false) return;

    		goMain();
    	});
    </script>
</body>
</html>