<%--
  /**
  * Class Name : login.jsp
  * Description : 로그인
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 6.            최초 생성
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title>로그인</title>
	
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
	<div class="container, paddingMain">
		<div class="page-header">
			<h1 align="center">Login</h1>
		</div>
		<div class="row" >
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 " ></div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 ">
                <!-- div title -->
                <form action="login.do" class="form-horizontal" id="login_form" name="login_form" method="post">
					<div class="form-group">
						<label for="gender" class="col-lg-4 col-sm-4 col-xs-4  control-label"></label>
						<div class="col-lg-6 col-sm-6 col-xs-6">
								 일반회원<input type = "radio" id="member1" name = "radio" value = "1" checked><br/>
						               업체회원<input type = "radio" id="member2" name = "radio" value = "2" >
						</div>
					</div>	                	
                    <!-- div 아이디 -->
                    <div class="form-group">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <input class="form-control" type="text" name="email" id="email" size="40"
                             placeholder="이메일입력"
                             maxlength="40"> 
                        </div>
                    </div>
                    <!-- div 비번 -->
                    <div class="form-group">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <input class="form-control" type="password" name="pw"  id="pw" size="40"
                             placeholder="비밀번호입력"
                             maxlength="50">
                        </div>
                    </div>   
                    
                   <!-- div 버튼 -->
<!--                     <div class="text-center">
                        <input type="submit" value="로그인"  class="submit">  
                    </div>  --> 
					<button type="button" class="btn btn-lg btn-primary btn-block"
						id="member_login" size="30">로그인
					</button>                    
                    <a href="${hContext}/login/gomember.do" class="more">일반 회원가입 / </a>
                    <a href="${hContext}/login/goidpw.do" class="more">아이디/비번찾기</a>
                    <br/><br/>
                    <a href="${hContext}/bizmember/go_insert.do" class="more">업체 회원가입 / </a>
                    <a href="${hContext}/bizmember/go_id_pw_find.do" class="more">업체아이디/비번찾기</a>                            
                </form>	
                   
                	
		    </div>
		</div>
	</div>
	
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    <!-- jQuery validator -->
    <script src="${hContext}/resources/js/jquery.validate.js"></script>		
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>
	<!-- page -->
	<script src="${hContext}/resources/js/jquery.bootpag.min.js"></script>	
	
	<script type="text/javascript">

 	function goLogin(radio){
 		//location.href="http://localhost:8080/d_dolive/member/gomypage.do";
 		if(radio=="1") {
 			location.href="http://localhost:8080/d_dolive/pharmacymap/main.do"; 
 	 	}else if(radio="2") {
 	 		location.href="http://localhost:8080/d_dolive/reserv/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=30&searchWord=&optionDiv=2";
 	 	}
    }

	
	   $("#member_login").on("click",function(){
		   var radio = $('input[name=radio]:checked').val();
			var url = "";
			if(radio=="1") {
				url = "${hContext}/member/login.do";
			}else if(radio=="2") {
				url = "${hContext}/bizmember/do_login.do";
			}
			
			$.ajax({
				type:"POST",
				url:url,
				dataType:"html",
				data:{
					"email" : $("#email").val(),
					"pw" : $("#pw").val()
				},
				success:function(data){ //성공
					//alert(data);
					var jData = JSON.parse(data);
					if(null!=jData.msgId && jData.msgId=="10") {
						alert(jData.msgMsg);
					}else if(null!=jData.msgId && jData.msgId=="20") {
						alert(jData.msgMsg);
					}else if(null!=jData.msgId && jData.msgId=="30") {
						alert(jData.msgMsg);
						goLogin(radio);
					}
				},
				error:function(xhr,status,error){
				    alert("이메일과 비밀번호를 다시 확인해주세요:"+error);
				},
				   complete:function(data){
				}
			});//--ajax
	   });
	</script>
	
	
	
	
</body>
</html>










