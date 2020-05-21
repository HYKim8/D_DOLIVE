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
<%@page import="com.sist.d_dolive.code.CodeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.d_dolive.cmn.StringUtil"%>
<%@page import="com.sist.d_dolive.cmn.SearchVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/common/common.jsp" %>
<%
	//페이지 사이즈
	String pageSize = "10";

	//페이지 num
	String pageNum = "1";
	
	//검색 구분
	//	10 : 전체 검색
	//	20 : 승인상태 별 검색
	String searchDiv = "10";
	
	//검색어
	//	session처리
	String searchWord = "bealright6@naver.com";
	
	//ReservCont에서 넘어온 param
	SearchVO search = (SearchVO)request.getAttribute("vo");
	if(search != null){
		pageSize = String.valueOf(search.getPageSize());
		pageNum = String.valueOf(search.getPageNum());
		searchDiv = String.valueOf(search.getSearchDiv());
		searchWord = String.valueOf(search.getSearchWord());
	}
	//out.print("search:"+search);
	
	//주어진 승인상태를 검색조건으로 넘겨 그에 맞는 예약목록을 출력한 리스트
	List<CodeVO> searchList = (List<CodeVO>)request.getAttribute("searchList");
/* 	out.print("searchList:"+searchList);     
    for(CodeVO vo:searchList){          
 		out.print(vo.toString()+"<br/>");  
 	}  */                                 
%>
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
<!-- Navigation-->
	<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
	    <div class="container">
	        <a class="navbar-brand js-scroll-trigger" href="#page-top">COREA</a><button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	            <ul class="navbar-nav ml-auto">
	                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Main</a></li>
	                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">Market</a></li>
	                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">LogOut</a></li>
	            </ul>
	        </div>
	    </div>
	</nav>
	<!-- div container -->
	<div class="container">
		<!-- div title -->
		<div class="page-header">
			<h1>예약 내역</h1>
		</div>
		<!--// div title -->
		<!-- 검색영역 -->
		<div class="row">
			<div class="col-md-12 text-right">
				<form action="${hContext}/reserv/do_retrieve.do" name="searchFrm" method="get" class="form-inline">
					<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
					<input type="hidden"   name="optionDiv" id="optionDiv" value="${vo.optionDiv }" />
					<input type="hidden"   name="searchDiv" id="searchDiv" value="${vo.searchWord }" />
					<input type="hidden"   name="searchWord" id="searchWord" value="" />
					<input type="hidden"   name="searchWord02" id="searchWord02" value="" />
					<input type="hidden"   name="regId" id="regId" />
					<div class="form-group">
						<%=StringUtil.makeSelectBox(searchList, "approvalSelect", searchDiv, true)%> 
						<!-- StringUtil.makeSelectBox(승인상태에 따라 검색한 리스트, 셀렉트박스 이름, 검색구분(10-전체 검색,20-상태별 검색) -->
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="javascript:doRetrieve();" class="btn btn-primary btn-sm">조회</button>
						<button type="button" onclick="doUpdate(5)" class="btn btn-primary btn-sm">결제하기</button>
						<button type="button" onclick="doUpdate(2)" class="btn btn-primary btn-sm">예약취소</button>
					</div>
				</form>
			</div>
		</div>
		<!--// 검색영역 -->

		<!-- Grid영역 -->
		<div class="table-responsive">
			<table class="table table-striped table-bordered sung" id="listTable">
				<!-- hidden-sm hidden-xs 숨기기 -->
				<thead class="bg-primary">
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8"></th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 hidden-xs ">번호</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">약국 이름</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">약국 주소</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">마스크수량</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">예약상태</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">결제금액</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">신청일</th>
    				<th style="display: none;">regId</th>
				</thead>
				<tbody>
				
					<c:choose>
						<c:when test="${list.size()>0 }">
							<c:forEach var="vo" items="${list }">
								<tr>
									<td class="text-center"><input type="radio" name="rno" id="rno" value="${vo.rno }"></td>
									<td class="text-center hidden-sm hidden-xs"><c:out value="${vo.num }" /></td>
									<td class="text-center"><c:out value="${vo.pname }" /></td>
									<td class="text-center"><c:out value="${vo.paddr }" /></td>
									<td class="text-center"><c:out value="${vo.maskCnt }" /></td>
									<td class="text-center"><c:out value="${vo.approval }" /></td>
									<td class="text-center"><c:out value="${vo.amount }" /></td>
									<td class="text-center"><c:out value="${vo.regDt }" /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td class="text-center">No data found.</td>
							</tr>
						</c:otherwise>
					</c:choose> 

				</tbody>
			</table>
		</div>
		<!--// Grid영역 -->
		
		<!-- pagenation -->
		<div class="text-center">
<%-- 			<%=StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %> --%>
		</div>
		<!--// pagenation -->
	</div>
	<!--// div container -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">

		function doUpdate(approval){
			var rno = $('input[name="rno"]:checked').val();
			console.log("rno=="+rno);

			if(rno == undefined) {
				alert("체크를 해주세요.");
				return;
			}

			//TODO approval 상태 변경 validation!!

			//ajax
			$.ajax({
				type:"POST",
				       url:"${hContext}/reserv/do_update.do",
				dataType:"html", 
				data:{
					"rno" : rno
				    , "approval" : approval
				    , "modId" : "수정자"
				},
				success:function(data){ //성공
					//alert(data)
					var jData = JSON.parse(data);
					if(jData != null && jData.msgId == "1"){
						alert(jData.msgMsg);
						history.go(0);
					}else{
						alert(jData.msgMsg);
					}
				
				},
				error:function(xhr,status,error){
				 alert("error:"+error);
				},
				complete:function(data){
				}
			 
			 });//--ajax    
		}
	
		function doRetrieve(){
			//console.log("doRetrieve");
			var frm = document.searchFrm;
			frm.searchWord.value = "bealright6@naver.com"//세션처리!!!!!

			var approval = $("#approvalSelect option:selected").val();

			if(approval == ""){
				frm.searchDiv.value = "10";
			} else{
				frm.searchDiv.value = "20";
				frm.searchWord02.value = approval;
			}

			frm.action = "${hContext}/reserv/do_retrieve.do";
			frm.submit();
		}
	</script>
</body>
</html>
	