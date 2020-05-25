<%--
  /**
  * Class Name : header.jsp
  * Description : tiles header
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 15.            최초 생성
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
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${hContext}/resources/css/styles.css" rel="stylesheet" /> 

   <c:choose>
   	<c:when test="${empty member}">
   		<!-- Navigation-->
		<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
		    <div class="container">
		        <a class="navbar-brand js-scroll-trigger" href="#page-top">COREA</a><button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
		        <div class="collapse navbar-collapse" id="navbarResponsive">
		            <ul class="navbar-nav ml-auto">
		            	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${hContext}/pharmacymap/main_test.do">Main</a></li>
		            	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${hContext}/covidmap/sidomap.do">확진자현황</a></li>
		                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Market</a></li>
		                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="http://localhost:8080/d_dolive/member/gomember.do">Sign Up</a></li>
		                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="http://localhost:8080/d_dolive/member/gologin.do">LogIn</a></li>
		            </ul>
		        </div>
		    </div>
		</nav>
   	</c:when>
   	<c:when test="${not empty member}">
   		<!-- Navigation-->
		<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
		    <div class="container">
		        <a class="navbar-brand js-scroll-trigger" href="#page-top">COREA</a><button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
		        <div class="collapse navbar-collapse" id="navbarResponsive">
		            <ul class="navbar-nav ml-auto">
		            	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${hContext}/pharmacymap/main_test.do">Main</a></li>
		            	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="${hContext}/covidmap/sidomap.do">확진자현황</a></li>		            
		                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Maket</a></li>
		                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="http://localhost:8080/d_dolive/member/gomypage.do">Mypage</a></li>
		                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="http://localhost:8080/d_dolive/member/gologin.do">LogOut</a></li>
		            </ul>
		        </div>
		    </div>
		</nav>
   	</c:when>
   	
   	
   </c:choose>

	
	
	<div style="height : 104px;"></div>
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center" style="display:none; height: 800px;">
	    <div class="container d-flex align-items-center flex-column">
	        <!-- Masthead Avatar Image--><img class="masthead-avatar mb-5" src="${hContext}/resources/assets/img/avataaars.svg" alt="" /><!-- Masthead Heading-->
	        <h1 class="masthead-heading text-uppercase mb-0">Mask</h1>
	        <!-- Icon Divider-->
	        <div class="divider-custom divider-light">
	            <div class="divider-custom-line"></div>
	            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
	            <div class="divider-custom-line"></div>
	        </div>
	        <!-- Masthead Subheading-->
	        <p class="masthead-subheading font-weight-light mb-0">Graphic Artist - Web Designer - Illustrator</p>
	    </div>
	</header>
	
	
	