<%--
  /**
  * Class Name : 
  * Description : bootstrap list 템플릿
  * Modification Information
  * http://localhost:8080/d_dolive/bizmember/do_select_one.do?email=jnhoon111&optionDiv=1
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
    <title>부트스트랩 HR_LIST 등록</title>

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
        	<h2>업체회원 조회</h2>
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
      		<input type="hidden" id="optionDiv" name="optionDiv"/>
      		<input type="hidden" id="searchDiv" name="searchDiv"/>
      		<div class="form-group">
	      		<label for="email" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">이메일</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="email" name="email" placeholder="이메일"
		      		value="${vo.email }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="pw" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">비밀번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="pw" name="pw" placeholder="비밀번호"
		      	 	value="${vo.pw }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="gender" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">성별</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<c:if test="${vo.gender eq '남자'}">
						&nbsp;<input type="radio" id="gender" name="gender" value="${vo.gender }" checked disabled="disabled"/>&nbsp;남자
						&nbsp;<input type="radio" id="gender" name="gender" value="${vo.gender }" disabled="disabled"/>&nbsp;여자
					</c:if>
					<c:if test="${vo.gender eq '여자'}">
						&nbsp;<input type="radio" id="gender" name="gender" value="${vo.gender }" disabled="disabled"/>&nbsp;남자
						&nbsp;<input type="radio" id="gender" name="gender" value="${vo.gender }" checked disabled="disabled"/>&nbsp;여자
					</c:if>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="name" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">이름</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="name" name="name" placeholder="이름"
		      	 	value="${vo.name }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="birth" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">생년월일</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일"
		      	 	value="${vo.birth }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="addr" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">주소</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="addr" name="addr" placeholder="주소"
		      	 	value="${vo.addr }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="addr2" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">상세주소</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소"
		      	 	value="${vo.addr2 }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="zipNo" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">우편번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="zipNo" name="zipNo" placeholder="우편번호"
		      	 	value="${vo.zipNo }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="tel" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">전화번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="tel" name="tel" placeholder="전화번호"
		      	 	value="${vo.tel }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="bizRno" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">사업자등록번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="bizRno" name="bizRno" placeholder="사업자등록번호"
		      	 	value="${vo.bizRno }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="bizTel" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">업체전화번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="bizTel" name="bizTel" placeholder="업체전화번호"
		      	 	value="${vo.bizTel }" readonly>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="pname" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">판매처 이름</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="pname" name="pname" placeholder="판매처 이름"
		      	 	value="${vo.pname }" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="paddr" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">판매처 주소</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="paddr" name="paddr" placeholder="판매처 주소"
		      	 	value="${vo.paddr }" readonly="readonly">
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
				url : "${hContext}/bizmember/do_delete.do",
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
			frm.optionDiv.value = "2";
			frm.searchDiv.value = "10";
	        frm.action = "${hContext}/bizmember/do_select_one.do";
	        frm.submit();
		}
    </script>
</body>
</html>
