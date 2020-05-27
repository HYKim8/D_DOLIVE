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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/common/common.jsp" %>

<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Main</title>
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${hContext}/resources/css/styles.css" rel="stylesheet" />
</head>
<body>
	
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center" style="height: 800px;">
	    <div class="container d-flex align-items-center flex-column">
	        <!-- Masthead Avatar Image--><img class="masthead-avatar mb-5" src="${hContext}/resources/assets/img/mask.png" alt="" /><!-- Masthead Heading-->
	        <h1 class="masthead-heading text-uppercase mb-0">Mask</h1>
	        <!-- Icon Divider-->
	        <div class="divider-custom divider-light">
	            <div class="divider-custom-line"></div>
	            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
	            <div class="divider-custom-line"></div>
	        </div>
			<!-- 주소 입력란 -->
			<form action="${hContext }/pharmacymap/pharmacy_map.do" name="main" method="get">
			<div class="form-group has-success has-feedback">
			  <label class="control-label" for="inputSuccess2">지역을 검색 해주세요</label>
			  <input type="text" class="form-control" id="p_address" name="p_address" placeholder="주소를 입력하세요." value="" aria-describedby="inputSuccess2Status">
			  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
			  <span id="inputSuccess2Status" class="sr-only">(success)</span>
			</div>
			<!-- //주소 입력란 -->
			<!-- 검색 버튼 -->
			<input type="button" value="검색" onclick="goUpdate();"/>
			<!-- 검색 버튼 -->
	        <!-- Masthead Subheading-->
	        </form>
	        <p class="masthead-subheading font-weight-light mb-0">Graphic Artist - Web Designer - Illustrator</p>
	    </div>
        </header>
        
    <script type="text/javascript">
	function goUpdate() {
		//console.log("update_btn");
		
		var frm = document.main;
        frm.action = "${hContext}/pharmacymap/pharmacy_map.do";
        frm.submit();
	}	

	function goSignUp(){
		//!!!!!!!!!!!!!!!!주소 매핑 변경!!!!!!!!!!!!!!!!
		location.href = "${hContext}/member/gomember.do"
	}

    </script>
    
    <!-- Bootstrap core JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <!-- Third party plugin JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <!-- Contact form JS-->
    <script src="${hContext}/resources/assets/mail/jqBootstrapValidation.js"></script>
    <script src="${hContext}/resources/assets/mail/contact_me.js"></script>
    <!-- Core theme JS-->
    <script src="${hContext}/resources/js/scripts.js"></script>
   <script type="text/javascript"></script>
</body>
</html>


