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

	
	//주어진 승인상태를 검색조건으로 넘겨 그에 맞는 예약목록을 출력한 리스트
	List<CodeVO> searchList = (List<CodeVO>)request.getAttribute("searchList");
    
	int totalCnt = 0;	
	totalCnt = (Integer) request.getAttribute("totalCnt");
	
	//paging
	String url = H_PATH + "/reserv/do_retrieve.do";
	String scriptName = "doSearchPage";
	int maxNum = 0;//총 글 수
	int currPageNo = 1;//현재 페이지
	int rowPerPage = 10;
	int bottomCount = 5;//바닥 페이지 수
	
	if(null != search) {
		currPageNo = 	search.getPageNum();
		rowPerPage = search.getPageSize();
		maxNum = totalCnt;
	}
	//--paging
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
	
   	<style type="text/css">
    				
    	.paddingMain {margin:80px 20% 160px;	}
    				
    	.paddingTitle {padding-bottom:40px}
    	
    	.paddingButton {padding-bottom:10px}
    	
    </style>
</head>
<body>
	<div class="container, paddingMain">
	
		<!-- div title -->
		<div class="paddingTitle">
			<h1>예약 내역</h1><hr/>
		</div>
		<!--// div title -->
		
		<!-- 검색영역 -->
		<div class="paddingButton">
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
						&nbsp;&nbsp;
						<button type="button" onclick="javascript:doRetrieve();" class="btn btn-primary btn-sm">조회</button>
					</div>
					<div style ="margin: 0 0 0 auto;">
						<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
						<button type="button" onclick="doPayment()" class="btn btn-primary btn-sm">결제하기</button>
						&nbsp;&nbsp;
						<button type="button" onclick="cancelPay()" class="btn btn-primary btn-sm" >환불하기</button>
						&nbsp;&nbsp;
						<button type="button" onclick="doUpdate(2,0)" class="btn btn-primary btn-sm">예약취소</button>
					</div>
				</form>
		</div>
		<!--// 검색영역 -->

		<!-- Grid영역 -->
		<div class="table-responsive">
			<table class="table table-striped table-bordered sung" style="table-layout:fixed;word-break;break-all" id="listTable">
				<!-- hidden-sm hidden-xs 숨기기 -->
				<thead class="bg-primary">
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 5%;"></th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 6%;">번호</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 15%;">약국 이름</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 35%;">약국 주소</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 10%;">마스크수량</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 10%;">예약상태</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 10%;">결제금액</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1" style="width: 10%;">신청일</th>
    				<th style="display: none;">regId</th>
    				<th style="display: none;">imp_uid</th>
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
									<td class="text-center"><c:out value="${vo.maskCnt } 개" /></td>
									<td class="text-center"><c:out value="${vo.approval }" /></td>
									<td class="text-center"><c:out value="${vo.amount }" /></td>
									<td class="text-center"><c:out value="${vo.regDt }" /></td>
									<td style="display: none;"><c:out value="${vo.impuid }"></c:out></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td class="text-center" colspan="8">해당 예약 상태인 건이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose> 

				</tbody>
			</table>
		</div>
		<!--// Grid영역 -->
		
		<!-- pagenation -->
		<div >
 			<%=StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %> 
		</div>
		<!--// pagenation -->
	</div>
	<!--// div container -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" ></script>
	<script type="text/javascript">
		function doSearchPage(url, no) {
			console.log("#url:"+url);
			console.log("#no:"+no);
	
			var frm = document.searchFrm;
			frm.pageNum.value = no;
			frm.action = url;
			frm.submit();
		}

		function cancelPay() {
			var rno = $('input[name="rno"]:checked').val();
			var imp_uid = $('input[name="rno"]:checked').parent().parent().children().eq(8).text();
			var nowApproval = $('input[name="rno"]:checked').parent().parent().children().eq(5).text();

			if(rno == undefined) {
				alert("체크를 확인해주세요.");
				return;
			}

			if(nowApproval != "결제완료"){
				alert("결제완료된 건만 환불이 가능합니다.");
				return;
			}
			
			//ajax
			$.ajax({
				type : "POST",
				url : "${hContext}/iamport/do_cancel.do",
				dataType : "html",
				data : {
					"imp_uid" : imp_uid
				},
				success : function(data) { //성공
					var jData = JSON.parse(data);
					if(null!=jData && jData.msgId=="1") {
						alert(jData.msgMsg);
						doUpdate(8,0);//환불완료 상태로 업데이트
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

		function doUpdate(approval, imp_uid){
			var rno = $('input[name="rno"]:checked').val();
			var nowApproval = $('input[name="rno"]:checked').parent().parent().children().eq(5).text();
			
			if(rno == undefined) {
				alert("체크를 확인해주세요.");
				return;
			}

			if(nowApproval == "취소완료"){
				alert("취소완료된 건은 상태변경이 불가능합니다.");
				return;
			}else if(nowApproval == "승인거절"){
				alert("승인거절된 건은 상태변경이 불가능합니다.");
				return;
			}else if(nowApproval == "상품배정"){
				alert("상품배정 된 건은 상태변경이 불가능합니다.");
				return;
			}else if(nowApproval == "구매확정"){
				alert("구매확정 된 건은 상태변경이 불가능합니다.");
				return;
			}else if(nowApproval == "환불완료"){
				alert("환불완료된 건은 상태변경이 불가능합니다.");
				return;
			}else if(nowApproval == "예약신청" && approval == "2"){
				
			}else if(nowApproval == "예약신청" && approval != "2"){
				alert("예약신청된 건은 예약취소만 가능합니다.");
				return;
			}else if(nowApproval == "승인완료" && approval == "5"){
				
			}else if(nowApproval == "승인완료" && approval != "5"){
				alert("승인완료된 건은 결제하기만 가능합니다.");
				return;
			}else if(nowApproval == "결제완료" && approval == "8"){
				
			}else if(nowApproval == "결제완료" && approval != "8"){
				alert("결제완료된 건은 환불하기만 가능합니다.");
				return;
			}

			//ajax
			$.ajax({
				type:"POST",
				url:"${hContext}/reserv/do_update.do",
				dataType:"html", 
				data:{
					"rno" : rno
				    , "approval" : approval
					, "impuid" : imp_uid
					, "searchDiv" : 10
					, "optionDiv" : 1
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

		function doPayment(){

			var rno = $('input[name="rno"]:checked').val();
			var nowApproval = $('input[name="rno"]:checked').parent().parent().children().eq(5).text();
			
			var amount = $('input[name="rno"]:checked').parent().parent().children().eq(6).text();
			var email = "${memberVO.email}";
			var name = "${memberVO.name}";
			var tel = "${memberVO.tel}";
			var addr = "${memberVO.addr}";
			var zipNo = "${memberVO.zipno}";

			if(rno == undefined) {
				alert("체크를 확인해주세요.");
				return;
			}
			
			if(nowApproval != "승인완료"){
				alert("승인완료 된 건만 결제가 가능합니다.");
				return;
			}
			
	        var IMP = window.IMP; // 생략가능
	        IMP.init('iamport'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	        //onclick, onload 등 원하는 이벤트에 호출합니다
	        IMP.request_pay({
	            
	            
	            pg : 'inicis', // version 1.1.0부터 지원.
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : 'COREA',
	            amount : amount,
	            buyer_email : email,
	            buyer_name : name,
	            buyer_tel : tel,
	            buyer_addr : addr,
	            buyer_postcode : zipNo,
	            m_redirect_url : 'https://www.yourdomain.com/payments/complete',
	            app_scheme : 'iamportapp'
	              
	             
	
	        }, function(rsp) {
	            if ( rsp.success ) {
	                var msg = '결제가 완료되었습니다.';
	                /* msg += '고유ID : ' + rsp.imp_uid;
	                msg += '상점 거래ID : ' + rsp.merchant_uid;
	                msg += '결제 금액 : ' + rsp.paid_amount;
	                msg += '카드 승인번호 : ' + rsp.apply_num; */

	                doUpdate(5, rsp.imp_uid);
	            } else {
	                var msg = '결제에 실패하였습니다.\n';
	                msg += '에러내용 : ' + rsp.error_msg;
	            }
	            alert(msg);
	        });
		}
		
	</script>
</body>
</html>
	