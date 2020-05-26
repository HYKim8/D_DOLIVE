<%--
  /**
  * Class Name : member_mng.jsp
  * Description : 회원관리
  * Modification Information
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>
<c:if test="${maxPageNo == null }">
	<c:set var="maxPageNo" value="0"></c:set>
</c:if>
<c:if test="${pageNum == null }">
	<c:set var="pageNum" value="1"></c:set>
</c:if>


<!DOCTYPE html>
<html lang="ko">
<head profile="http://www.w3.org/2005/10/profile">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	
	<link rel="icon" type="image/png" href="http://example.com/myicon.png">
	<title>회원관리</title>
	
	<link rel="shortcut icon" type="image/x-icon"
		href="${hContext}/resources/img/main/favicon.ico">
	<!-- 부트스트랩 -->
	<link href="${hContext}/resources/css/styles.css" rel="stylesheet" />
	
	<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
	<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	<style type="text/css">
    				
    	.paddingMain {margin:80px 20% 160px;	}
    </style>
</head>
<body>
	<!-- div container -->
	<div class="container paddingMain">
		<!-- div title -->
		<div class="page-header">
			<h2>아이디 비번찾기</h2><hr/>
		</div>
		<!--// div title -->
	

	<!-- 입력 form -->
	<div class="container">
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>
		</br></br>
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-10 col-sm-10 col-xs-10 ">
				<div class="text-right">
					<span style="float:right"><button type="button" class="btn btn-primary btn-sm" id="findId">아이디찾기</button></span>
					<!-- <input class="btn btn-primary py-2 px-3" type="button" onclick="location.href='javascript:findId();'"  value="Id찾기" id="cancel" /> -->
				</div>
			</div>
		</div>
		<!--// Button Area -->

		<!-- 아이디찾기 Form -->
		<form action="${hContext}/member/find_id.do" name="member_edit" method="post" class="form-horizontal">
			
			
			<div class="form-group">
				<label for="name" class="col-lg-4 col-sm-4 col-xs-4  control-label">이름</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
					<input type="text" maxlength="350" class="form-control input-sm"
						id="name" name="name" placeholder="이름" />
				</div>
			</div>			
			
			<div class="form-group">
				<label for="ihidnum"
					class="col-lg-4 col-sm-4 col-xs-4  control-label">주민번호</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
					<input type="password" maxlength="50" class="form-control input-sm"
						id="ihidnum" name="ihidnum" placeholder="비밀번호" />
				</div>
			</div>
	


		</form>
		
		<!--// 아이디찾기 Form -->
		</br></br></br>
		
		<!-- Button Area -->
		<div class="row">
			<div class="col-lg-10 col-sm-10 col-xs-10 ">
				<div class="text-right">
					<span style="float:right"><button type="button" class="btn btn-primary btn-sm" id="findPw">비밀번호찾기</button></span>
				</div>
			</div>
		</div>
		<!--// Button Area -->		
		
		<!-- 비번찾기 Form -->
		<form action="${hContext}/member/do_find_pw.do" name="member_edit" method="post" class="form-horizontal">
			
			<div class="form-group">
				<label for="email" class="col-lg-4 col-sm-4 col-xs-4  control-label">이메일</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
					<input type="text" maxlength="350" class="form-control input-sm"
						id="email" name="email" placeholder="이메일" />
				</div>
			</div>				
			
			<div class="form-group">
				<label for="name" class="col-lg-4 col-sm-4 col-xs-4  control-label">이름</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
					<input type="text" maxlength="350" class="form-control input-sm"
						id="name1" name="name1" placeholder="이름" />
				</div>
			</div>			
			
			<div class="form-group">
				<label for="ihidnum"
					class="col-lg-4 col-sm-4 col-xs-4  control-label">주민번호</label>
				<div class="col-lg-10 col-sm-10 col-xs-10">
					<input type="password" maxlength="50" class="form-control input-sm"
						id="ihidnum1" name="ihidnum1" placeholder="비밀번호" />
				</div>
			</div>
	


		</form>
		
		<!--// 비번찾기 Form -->		
		


	</div>
	<!-- 입력 form -->



	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>
	<!-- page -->
	<script src="${hContext}/resources/js/jquery.bootpag.min.js"></script>

	<script type="text/javascript">
	
    	
		//아이디찾기버튼
		$("#findId").on("click", function() {
			
/* 			alert("name="+$("#name").val());
            alert("ihidnum="+$("#ihidnum").val()); */
            

            if ($("#name").val() == "" || $("#name").val() == false) {
                alert("이름를 입력 하세요.");
                $("#name").focus();
                return;
            }
            
            if ($("#ihidnum").val() == "" || $("#ihidnum").val() == false) {
                alert("주민번호를 입력 하세요.");
                $("#ihidnum").focus();
                return;
            }

            
            //confirm
            if (confirm("아이디를 찾으시겠습니까?") == false)return;
            
            //ajax
            $.ajax({
                type : "GET",
                url : "${hContext}/member/find_id.do",
                dataType : "html",
                data : {
                	"name" : $("#name").val(),
                    "ihidnum" : $("#ihidnum").val()
                },
                success : function(data) { //성공
                	if($.trim(data) == "x"){
    					alert("가입기록이 없습니다.이름 또는 이메일을 다시 한 번 확인해주세요!");
                    }
                    else{
                    	alert("회원님의 아이디는"+$.trim(data)+"입니다.");
                    }

                },
                error : function(xhr, status, error) {
                    alert("입력값을 다시 확인해주세요.");
                },
                complete : function(data) {

                }

            });//--ajax 

        });



		//비밀번호찾기버튼
		$("#findPw").on("click", function() {

/* 			alert("email="+$("#email").val());
 			alert("name="+$("#name1").val());
            alert("ihidnum="+$("#ihidnum1").val());  */
            

            if ($("#email").val() == "" || $("#email").val() == false) {
                alert("이메일를 입력 하세요.");
                $("#email").focus();
                return;
            }
            
            if ($("#name1").val() == "" || $("#name1").val() == false) {
                alert("이름를 입력 하세요.");
                $("#name").focus();
                return;
            }
            
            if ($("#ihidnum1").val() == "" || $("#ihidnum1").val() == false) {
                alert("주민번호를 입력 하세요.");
                $("#ihidnum").focus();
                return;
            }

            
            //confirm
            if (confirm("비밀번호를 이메일로 전송하시겠습니까?") == false)return;
            
            //ajax
            $.ajax({
                type : "POST",
                url : "${hContext}/member/do_find_pw.do",
                dataType : "html",
                data : {
                    "email" :$("#email").val(),
                	"name" : $("#name1").val(),
                    "ihidnum" : $("#ihidnum1").val()
                },
                success : function(data) { //성공
                	if($.trim(data) == "x"){
    					alert("이름 또는 이메일또는 주민번호를 다시 확인해주세요!");
                    }
                    else{
                    	 alert("전송완료");
                    }
               

                },
                error : function(xhr, status, error) {
                	alert("이름 또는 이메일또는 주민번호를 다시 확인해주세요!");
                },
                complete : function(data) {

                }

            });//--ajax 

        });        


 
	</script>
</body>
</html>





















