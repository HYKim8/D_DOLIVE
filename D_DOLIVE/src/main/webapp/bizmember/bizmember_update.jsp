<%--
  /**
  * Class Name : 
  * Description : bootstrap list 템플릿
  * Modification Information
  * http://localhost:8080/d_dolive/bizmember/do_select_one.do?email=jnhoon111&optionDiv=2
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
        	<h2>업체회원 수정</h2>
      	</div>
      	
      	<!--// div title -->
        <div class="row text-right">
			<label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"></label>
		    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<input type="button" class="btn btn-primary btn-sm" value="수정" onclick="doUpdate();" />
			</div>
		</div>
      	<!-- div title -->
      	<form class="form-horizontal" action="${hContext }/bizmember/do_select_one.do" name="updateFrm" method="get">
      		<input type="hidden" id="optionDiv" name="optionDiv"/>
      		<input type="hidden" id="h_email" name="h_email"/>
      		<div class="form-group">
	      		<label for="email" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">이메일</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="email" name="email" placeholder="이메일"
		      		value="${vo.email }" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="pw" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">비밀번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="pw" name="pw" placeholder="비밀번호"
		      	 	value="${vo.pw }">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="gender" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">성별</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<c:if test="${vo.gender eq '남자'}">
						&nbsp;<input type="radio" id="gender" name="gender" value="1" checked/>&nbsp;남자
						&nbsp;<input type="radio" id="gender" name="gender" value="2" />&nbsp;여자
					</c:if>
					<c:if test="${vo.gender eq '여자'}">
						&nbsp;<input type="radio" id="gender" name="gender" value="1" />&nbsp;남자
						&nbsp;<input type="radio" id="gender" name="gender" value="2" checked/>&nbsp;여자
					</c:if>
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="name" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">이름</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="name" name="name" placeholder="이름"
		      	 	value="${vo.name }">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="birth" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">생년월일</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일"
		      	 	value="${vo.birth }">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="addr" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">주소</label>
	      		<input type="button" class="btn btn-primary btn-sm" value="주소 조회" onclick="goJusoPopup();"/>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="roadAddrPart1" name="roadAddrPart1" placeholder="주소"
		      	 	value="${vo.addr }" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="addr2" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">상세주소</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="addrDetail" name="addrDetail" placeholder="상세주소"
		      	 	value="${vo.addr2 }" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="zipNo" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">우편번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="zipNo" name="zipNo" placeholder="우편번호"
		      	 	value="${vo.zipNo }" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="tel" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">전화번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="tel" name="tel" placeholder="전화번호"
		      	 	value="${vo.tel }">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="bizRno" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">사업자등록번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="bizRno" name="bizRno" placeholder="사업자등록번호"
		      	 	value="${vo.bizRno }">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="bizTel" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">업체전화번호</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="bizTel" name="bizTel" placeholder="업체전화번호"
		      	 	value="${vo.bizTel }">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="pname" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">판매처 이름</label>
	      		<input type="button" class="btn btn-primary btn-sm" value="판매처 조회" onclick="goPharmacyPopup();"/>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="pname" name="pname" placeholder="판매처 이름"
		      	 	value="" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="paddr" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">판매처 주소</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="paddr" name="paddr" placeholder="판매처 주소"
		      	 	value="" readonly="readonly">
		      	</div>
	      	</div>
	      	<div class="form-group">
	      		<label for="pcode" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">판매처코드</label>
		    	<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
		      		<input type="text" class="form-control" id="pcode" name="pcode" placeholder="판매처 코드"
		      	 	value="" readonly="readonly">
		      	</div>
	      	</div>
   		</form>
 	</div>   
 	
 	  
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${hContext}/resources/js/bootstrap.min.js"> </script>
    
    
    <script type="text/javascript">
	    function goPharmacyPopup() {
			var pop = window.open("${hContext}/pharmacy/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=", "pop", "width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
	
		function pharmacyCallBack(pname, paddr, pcode) {
			document.updateFrm.pname.value = pname;
			document.updateFrm.paddr.value = paddr;
			document.updateFrm.pcode.value = pcode;
		}
    
	    function goJusoPopup(){
	    	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	    	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	    	var pop = window.open("${hContext}/jusoapi/juso_popup_api.jsp", "pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	    	
	    	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	        //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	    }
	
	    function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail, roadAddrPart2, engAddr, jibunAddr, zipNo
	    		, admCd, rnMgtSn, bdMgtSn, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm
	    		, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
			// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
			document.updateFrm.roadAddrPart1.value = roadAddrPart1;
			document.updateFrm.addrDetail.value = addrDetail;
			document.updateFrm.zipNo.value = zipNo;
		}
    
		function goSelectOne() {
			var frm = document.updateFrm;
			frm.optionDiv.value = "1";
			frm.h_email.value = $("#email").val();
	        frm.action = "${hContext}/bizmember/do_select_one.do";
	        frm.submit();
		}
    
		function doUpdate() {
			//console.log("update_btn");
			
			var email = $("#email").val();
			var pw = $("#pw").val();
			var gender = $("input[name='gender']:checked").val();
			var name = $("#name").val();
			var birth = $("#birth").val();
			var addr = $("#addr").val();
			var addr2 = $("#addr2").val();
			var zipNo = $("#zipNo").val();
			var tel = $("#tel").val();
			var bizRno = $("#bizRno").val();
			var bizTel = $("#bizTel").val();
			var pcode = $("#pcode").val();

			if(false==confirm("수정 하시겠습니까?"))return;

			//ajax
			$.ajax({
				type : "POST",
				url : "${hContext}/bizmember/do_update.do",
				dataType : "html",
				data : {
					"email" : email
					, "pw" : pw
					, "gender" : gender
					, "name" : name
					, "birth" : birth
					, "addr" : addr
					, "addr2" : addr2
					, "zipNo" : zipNo
					, "tel" : tel
					, "bizRno" : bizRno
					, "bizTel" : bizTel
					, "pcode" : pcode
				},
				success : function(data) { //성공
					var jData = JSON.parse(data);
					if(null!=jData && jData.msgId=="1") {
						alert(jData.msgMsg);
						goSelectOne();
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
    </script>
</body>
</html>
