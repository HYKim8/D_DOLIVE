<%--
  /**
  * Class Name : board_list.jsp
  * Description : 게시판 목록
  * Modification Information
  * http://localhost:8080/d_dolive/notice/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 3. 10.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.sist.d_dolive.cmn.StringUtil"%>
<%@page import="com.sist.d_dolive.cmn.SearchVO"%>
<%@page import="com.sist.d_dolive.code.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/common.jsp" %>
<%
	//페이지 사이즈
	String pageSize = "10";

	//페이지 num
	String pageNum = "1";
	
	//검색 구분
	String searchDiv = "";
	
	//검색어
	String searchWord = "";

	SearchVO search = (SearchVO) request.getAttribute("vo");
	//out.print("search:"+search);
	if(null != search) {
		pageSize = String.valueOf(search.getPageSize());
		pageNum = String.valueOf(search.getPageNum());
		searchDiv = search.getSearchDiv();
		searchWord = search.getSearchWord();
	}

	List<CodeVO> pageSizeList = (List<CodeVO>) request.getAttribute("pageSizeList");
	/*
	for(CodeVO vo : pageSizeList) {
		out.print(vo+"<br/>");
	}
	*/
	
	int totalCnt = 0;
	
	totalCnt = (Integer) request.getAttribute("totalCnt");
	//out.print("totalCnt:"+totalCnt);
	
	//paging
	String url = H_PATH + "/notice/do_retrieve.do";
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

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
   	<meta http-equiv="X-UA-Compatible" content="IE=edge">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
   	<title>부트스트랩 템플릿_LIST</title>

   	<!-- 부트스트랩 -->  
   	<!-- <link href="${hContext}/resources/css/bootstrap.min.css" rel="stylesheet"> -->

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
  	    	<h1>알림 신청 목록</h1>
  	    </div>
  	    <!--// div title -->
    	<!-- Grid영역 -->
    	<div class="table-responsive">
    		<table class="table table-striped table-bordered jong" id="listTable">
    		    <!-- hidden-sm hidden-xs 숨기기 -->
    			<thead class="bg-primary">
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 hidden-xs ">번호</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">업체명</th>
    				<th class="text-center col-lg-8 col-md-8 col-sm-8 col-xs-8">주소</th>
    				<th style="display: none;">pcode</th>
    				<th class="text-center col-lg-1 col-md-1 col-sm-1 col-xs-1">삭제</th>
    			</thead>
    			<tbody>
    				<c:choose>
    					<c:when test="${list.size()>0 }">
    						<c:forEach var="vo" items="${list }">
    							<tr>
			    					<td class="text-center hidden-sm hidden-xs"><c:out value="${vo.num }"></c:out></td>
			    					<td class="text-left"><c:out value="${vo.name }"></c:out></td>
			    					<td class="text-center"><c:out value="${vo.addr }"></c:out></td>
			    					<td style="display: none;"><c:out value="${vo.pcode }"></c:out></td>
			    					<td><input type="button" value="삭제" onclick="doDelete($(this));"/></td>
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
				<%=StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
     		</div>
     		<!--// pagenation -->    	
  		</div>
  		<!--// div container -->
   
   
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${hContext}/resources/js/bootstrap.min.js"></script>
   
   
   	<script type="text/javascript">
   		function doDelete(td) {
   			var tr = td.parent().parent();
			var pcode = tr.children().eq(3).text();

			var email = "이메일1";
   	   		
   			//ajax
			$.ajax({
				type : "POST",
				url : "${hContext}/notice/do_delete.do",
				dataType : "html",
				data : {
					"pcode" : pcode
					, "email" : email
				},
				success : function(data) { //성공
					var jData = JSON.parse(data);
					if(null!=jData && jData.msgId=="1") {
						alert(jData.msgMsg);
						//새로고침
						history.go(0);
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





















