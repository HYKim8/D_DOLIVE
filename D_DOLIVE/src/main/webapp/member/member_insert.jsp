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
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/common/common.jsp" %>    
<!DOCTYPE html>
<html lang="ko">
<head profile="http://www.w3.org/2005/10/profile">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>회원관리</title>

<!-- 부트스트랩 -->
<link href="${hContext}/resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="icon" type="image/png" href="http://example.com/myicon.png">

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
			<h1>회원관리</h1>
		</div>
		<!--// div title -->
	

	<!-- 입력 form -->
	<div class="container">
		<div class="col-lg-12"></div>
		<div class="col-lg-12"></div>
		<div class="panel panel-default"></div>



		<!-- 입력 Form -->
		<form class="form-horizontal" name="registerForm" id="registerForm" method="post" >
			
			
			<div class="form-group">
				<label for="email" class="col-lg-4 col-sm-4 col-xs-4  control-label">메일</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
					<input type="text" maxlength="350" class="form-control input-sm" id="email" name="email" placeholder="메일" />
				</div>
				<div>
					<input  type="button"  name="checkbtn" class="btn btn-primary btn-sm"  value="중복확인" id="checkbtn" />
				</div>
			</div>			
			
			<div class="form-group">
				<label for="pw"
					class="col-lg-4 col-sm-4 col-xs-4  control-label">비밀번호</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
					<input type="password" maxlength="50" class="form-control input-sm"
						id="pw" name="pw" placeholder="비밀번호" />
				</div>
			</div>
			
         <div class="form-group">
              <label for="confirm_pass" class="col-lg-4 col-sm-4 col-xs-4  control-label">비밀번호 확인</label>
            <div class="col-lg-6 col-sm-6 col-xs-6">
               <input type="password" class="form-control" name="confirm_pass" id="confirm_pass" placeholder="비밀번호 확인">
            </div>
         </div>		
						
			<div class="form-group">
				<label for="gender" class="col-lg-4 col-sm-4 col-xs-4  control-label">성별</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
						 <input type = "radio" id="gender1" name = "gender" value = "1" >남자
				         <input type = "radio" id="gender2" name = "gender" value = "2" >여자
				</div>
			</div>				
			
			<div class="form-group">
				<label for="ihidnum" class="col-lg-4 col-sm-4 col-xs-4  control-label">주민번호</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
					<input type="text" maxlength="50" class="form-control input-sm"
						id="ihidnum" name="ihidnum" placeholder="- 없이 입력" />
				</div>
			</div>				
			
			<div class="form-group">
				<label for="name" class="col-lg-4 col-sm-4 col-xs-4  control-label">이름</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
					<input type="text" maxlength="50" class="form-control input-sm"
						id="name" name="name" placeholder="이름" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="tel" class="col-lg-4 col-sm-4 col-xs-4  control-label">전화번호</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
					<input type="text"  class="form-control input-sm" id="tel" name="tel" placeholder="- 없이 입력" />
						
				</div>
			</div>			
			
			<div class="form-group">
				<label for="zipno" class="col-lg-4 col-sm-4 col-xs-4  control-label">주소</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
						<input type="text" id="zipno" placeholder="우편번호" name="zipno" readonly >
						<input type="button" onclick="sample2_execDaumPostcode()" name="find" value="우편번호 찾기"><br>
				</div>
			</div>	
			
			<div class="form-group">
				<label for="addr" class="col-lg-4 col-sm-4 col-xs-4  control-label">기본주소</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
						<input type="text" name="addr" id="addr" class="form-control input-sm" placeholder="기본주소" readonly>
				</div>
			</div>		
			
			<div class="form-group">
				<label for="addr2" class="col-lg-4 col-sm-4 col-xs-4  control-label">상세주소</label>
				<div class="col-lg-6 col-sm-6 col-xs-6">
						<input type="text" id=addr2 name="addr2" class="form-control input-sm" placeholder="상세주소" >
				</div>
			</div>	
			
			
			<!-- Button Area -->
			<div class="form-group">
				<div class="col-lg-10 col-sm-10 col-xs-10 ">
					<span style="float:right">
						<input  type="button"  name="doInsert" onclick="$(this.form).submit()" class="btn btn-primary btn-sm"  value="등록" id="doInsert" />
					</span>
				</div>
			</div>
			<!--// Button Area -->												


	</form>
		
		<!--// 입력 Form -->


	</div>
	<!--// 입력 form -->


	<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
	<div id="layer"
		style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
		<img
			src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
			id="btnCloseLayer"
			style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1; width: 5%; height: auto;"
			onclick="closeDaumPostcode()" alt="닫기 버튼">
	</div>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		// 우편번호 찾기 화면을 넣을 element
		var element_layer = document.getElementById('layer');

		function closeDaumPostcode() {
			// iframe을 넣은 element를 안보이게 한다.
			element_layer.style.display = 'none';
		}

		function sample2_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = data.address; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수

							// 기본 주소가 도로명 타입일때 조합한다.
							if (data.addressType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('zipno').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('addr').value = fullAddr;

							// iframe을 넣은 element를 안보이게 한다.
							// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
							closeDaumPostcode();
						},
						width : '100%',
						height : '100%',
						maxSuggestItems : 5
					}).embed(element_layer);

			// iframe을 넣은 element를 보이게 한다.
			element_layer.style.display = 'block';

			// iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
			initLayerPosition();
		}

		// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
		// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
		// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
		function initLayerPosition() {
			var width = 300; //우편번호서비스가 들어갈 element의 width
			var height = 400; //우편번호서비스가 들어갈 element의 height
			var borderWidth = 5; //샘플에서 사용하는 border의 두께

			// 위에서 선언한 값들을 실제 element에 넣는다.
			element_layer.style.width = width + 'px';
			element_layer.style.height = height + 'px';
			element_layer.style.border = borderWidth + 'px solid';
			// 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
			element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
					+ 'px';
			element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
					+ 'px';
		}
	</script>


	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    <!-- jQuery validator -->
    <script src="${hContext}/resources/js/jquery.validate.js"></script>	
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>
	<!-- page -->
	<script src="${hContext}/resources/js/jquery.bootpag.min.js"></script>

 
	
	
    <script type="text/javascript">


         function bindEventHandler(){
        	 $("#registerForm").validate({
                 onfocus: true,
                 //서버전송여부
                 debug: true,
                 rules: {
                	 email:{
                        //필수값
                        required: true,
                        //최소길이
                        email: true
                     },pw:{
                         //필수값
                         required: true,
                         //범위
                         maxlength: 12
                     },confirm_pass:{
                         //필수값
                         required: true,
                         //범위
                         rangelength: [5,12],

                         equalTo:"#pw"
                     },gender:{
                    	required: true

                 	 },ihidnum:{
                 		required: true,
                 		rangelength: [13,14]
                 		
                 	 },name:{
                    	 //필수값
                         required: true,
                         //이메일형식
                         minlength: 2
                     },tel:{
                         //필수값
                         required: true,
                         rangelength: [10,11]
                     },zipno:{
                    	 required: true
                     },addr:{
                    	 required: true
                     },addr2:{
                    	 required: true
                     }     

                 },messages: {
                     //message
                     email:{
                         //필수값
                         required: "이메일은 필수값 입니다.",
                         //이메일형식
                         email:  "올바른 이메일 형식이 아닙니다."
                 	 },pw:{
                         //필수값 
                         required: "비밀번호는 필수값 입니다.",
                         //최소길이
                         maxlength: $.validator.format('{0}자 이하 입력하세요.')
                     },confirm_pass:{
                          //필수값 
                          required: "비밀번호확인을 입력하세요.",
                          //최소길이
                          rangelength: $.validator.format('비밀번호확인는 {0}이상~{1}이하로 입력하세요.'),
                          //pass==confirm_pass 
                          equalTo:"비밀번호 항목과 일치하지 않습니다."
                     },gender:{
                         //필수값 
                         required: "필수값 선택값입니다."
                         //최소길이
                     },ihidnum:{
                         //필수값 
                         required: "주민번호는 필수값 입니다.",
                         rangelength: $.validator.format('주민번호는 {0}이상~{1}이하로 입력하세요.')
                     },name:{
                         //필수값 
                         required: "이름은 필수값 입니다.",
                         //최소길이
                         minlength: $.validator.format('{0}자 이상 입력하세요.')
                     },tel:{
                         //필수값 
                         required: "전화번호는 필수값 입니다.",
                         rangelength: $.validator.format('전화번호는 {0}이상~{1}이하로 입력하세요.')
                     },zipno:{
                         //필수값
                         required: "우편번호는 필수값 입니다."
                     },addr:{
                    	 required: "기본주소는 필수값 입니다."
                     },addr2:{
                    	 required: "상세주소는 필수값 입니다."
                     }       
   
                 },errorElement: "em"
                 ,errorPlacement: function ( error, element ) {
                     // Add the `help-block` class to the error element
                     error.addClass( "help-block" );

                     if ( element.prop( "type" ) === "checkbox" ) {
                         error.insertAfter( element.parent( "label" ) );
                     } else {
                         error.insertAfter( element );
                     }
                 },
                 highlight: function ( element, errorClass, validClass ) {
                     $( element ).parents( ".col-lg-6 " ).addClass( "has-error" ).removeClass( "has-success" );
                 },
                 unhighlight: function (element, errorClass, validClass) {
                     $( element ).parents( ".col-lg-6 " ).addClass( "has-success" ).removeClass( "has-error" );
                 }
				

          });

         }
    

    </script>	
	
 	<script type="text/javascript">
	
 	 $(document).ready(function(){
         //input validation
    	 bindEventHandler();
    	 
     });

 	function goLogin(){
    	location.href="http://localhost:8080/d_dolive/member/login.jsp";
    }

	var duplicate = false;
		$('#checkbtn').on('click', function() {
			//alert($('#m_id').val());
			$.ajax({
				type : 'POST',
				url : "${hContext}/member/idCount.do",
				data : {
					"email" : $("#email").val()
				},
				success : function(data) {
					if ($.trim(data) == 0) {
						//$('#checkMsg').html('<p style="color:blue;width:100px;">사용가능</p>');
						alert("사용 가능한 아이디 입니다!");
						duplicate = true;
					} else if ($.trim(data) == "blank") {
						alert("아이디에 공백은 불가합니다!");
						duplicate = false;
					} else if ($.trim(data) == "@") {
						alert("아이디에 특수문자@는 불가합니다!");
						duplicate = false;
					} else {
						alert("사용 불가능한 아이디 입니다!");
						duplicate = false;
					}
				}
			}); //end ajax   
		}); //end on    

	
     
		//등록
		 $("#doInsert").on("click", function() { 
			
/*   			 alert($('#email').val());
			 alert($('#pw').val());
			 alert($('input[name=gender]:checked').val());
			 alert($('#ihidnum').val());
			 alert($('#name').val());
			 alert($('#tel').val());
			 alert($('#zipno').val());
			 alert($('#addr').val());
			 alert($('#addr2').val());   */
			 
				
	 		 if (duplicate == false) {
					alert("아이디 중복확인을 해주세요!");
					return false;
				} else if (duplicate == true) {
					
		            //confirm
		            if (confirm("등록 하시겠습니까?") == false)return;
		            //var gender = $('input[name="gender"]:checked').val();
		            //ajax
		            $.ajax({
		                type : "POST",
		                url : "${hContext}/member/insert.do",
		                dataType : "html",
		                data : {
		                    "email" : $("#email").val(),
		                    "pw" : $("#pw").val(),
		                    "gender" :$('input[name=gender]:checked').val(),
		                    "ihidnum" : $("#ihidnum").val(),
		                    "name" : $("#name").val(),
		                    "tel" : $("#tel").val(),
		                    "zipno" : $("#zipno").val(),
		                    "addr" : $("#addr").val(),
		                    "addr2" : $("#addr2").val(),
		                    "regid" : $("#email").val(),
		                    "modid" : $("#email").val()

		                },
		                success : function(data) { //성공
		                    console.log("data:" + data);
		                    var parseData = $.parseJSON(data);
		                    if (parseData.msgId == "1") {
		                        alert(parseData.msgMsg);
		                        goLogin();
		                    } else {
		                        alert(parseData.msgMsg);
		                    }

		                },
		                error : function(xhr, status, error) {
		                    alert("입력값을 확인하세요!");
		                },
		                complete : function(data) {

		                }

		            });//--ajax 					


					
					} 


        });


 
	</script> 	
	
	
	
	
</body>
</html>





















