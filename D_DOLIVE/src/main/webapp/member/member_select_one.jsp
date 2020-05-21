<%--
  /**
  * Class Name : 
  * Description : bootstrap list 템플릿
  * Modification Information
  * http://localhost:8080/d_dolive/member/do_select_one.do?email=wkdkfl815
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 3. 9.            최초 생성
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
    <title>마이페이지</title>

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- div container -->
   	<div class="container">
      	<!-- div title --> 
      	<div class="page-header">
        	<h2>나의정보 보기</h2>
      	</div>
      	
      	<!--// div title -->
        <div class="row text-right">
			<label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"></label>
		    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<input type="button" class="btn btn-primary btn-sm" value="수정하러가기" onclick="goUpdate();" />
				<input type="button" class="btn btn-primary btn-sm" value="탈퇴" onclick="doDelete();" />
			</div>
		</div>
      	<!-- div title -->
      	<form class="form-horizontal" action="${hContext }/bizmember/do_select_one.do" name="selectFrm" method="get">
      		<input type="hidden" id="h_email" name="h_email"/>
      		<div class="form-group">
	      		<label for="email" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">이메일</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="email" name="email" placeholder="이메일"
		      		value="${member.email }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="pw" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">비밀번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="pw" name="pw" placeholder="비밀번호"
		      	 	value="${member.pw }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="gender" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">성별</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		    		<c:choose>
		    			<c:when test="${member.gender eq '1'}">
		    				<input type="text" class="form-control" id="gender" name="gender" placeholder="성별" value="남자" readonly>
		    			</c:when>
		    			<c:when test="${member.gender eq '2'}">
		    				<input type="text" class="form-control" id="gender" name="gender" placeholder="성별" value="여자" readonly>
		    			</c:when>		    			
		    			
		    		</c:choose>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="ihidnum" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">주민번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="ihidnum" name="ihidnum" placeholder="주민번호"
		      	 	value="${member.ihidnum }" readonly>
		      	</div>
	      	</div>	      	
	      	<div class="form-group">
	      		<label for="name" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">이름</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="name" name="name" placeholder="이름"
		      	 	value="${member.name }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="tel" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">전화번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="tel" name="tel" placeholder="전화번호"
		      	 	value="${member.tel }" readonly>
		      	</div>
	      	</div>
	      	
	      	
	      	
			<div class="form-group">
				<label for="zipno" class="col-lg-4 col-sm-4 col-xs-4  control-label">주소</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
						<input type="text" id="zipno"  class="form-control" placeholder="우편번호" name="zipno" value="${member.zipno }" readonly >
				</div>
			</div>	
			
			<div class="form-group">
				<label for="addr" class="col-lg-4 col-sm-4 col-xs-4  control-label">기본주소</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
						<input type="text" name="addr" id="addr"  class="form-control" placeholder="기본주소" value="${member.addr }" readonly>
				</div>
			</div>		
			
			<div class="form-group">
				<label for="addr2" class="col-lg-4 col-sm-4 col-xs-4  control-label">상세주소</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
						<input type="text" id=addr2 name="addr2"  class="form-control" placeholder="상세주소" value="${member.addr2 }" readonly >
				</div>
			</div>		      	


   		</form>
 	</div>   
 	

 	  
 	  
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${hContext}/resources/js/bootstrap.min.js"> </script>
    
    
    <script type="text/javascript">
		function doDelete() {
			var email = $("#email").val();

			if(false==confirm("탈퇴 하시겠습니까?"))return;
			
			//ajax
			$.ajax({
				type : "POST",
				url : "${hContext}/member/do_delete.do",
				dataType : "html",
				data : {
					"email" : email
				},
				success : function(data) { //성공
					var jData = JSON.parse(data);
					if(null!=jData && jData.msgId=="1") {
						alert(jData.msgMsg);
						location.href = "http://localhost:8080/d_dolive/pharmacymap/Main.jsp";
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
		}
    
		function goUpdate() {
			//console.log("update_btn");
			
			var frm = document.selectFrm;
			frm.h_email.value = $("#email").val();
	        frm.action = "${hContext}/member/do_select_one.do";
	        frm.submit();
		}
    </script>
</body>
</html>

































