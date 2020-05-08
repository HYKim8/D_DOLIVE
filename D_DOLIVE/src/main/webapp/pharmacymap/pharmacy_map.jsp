<%--
  /**
  * Class Name : 
  * Description : 
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/cmn/common.jsp" %>
<c:set  var="hContext" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 300px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 300px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
    
    .switch {
	  position: relative;
	  display: inline-block;
	  width: 30px;
	  height: 17px;
	}
	
	.switch input { 
	  opacity: 0;
	  width: 0;
	  height: 0;
	}
	
	.slider {
	  position: absolute;
	  cursor: pointer;
	  top: 0;
	  left: 0;
	  right: 0;
	  bottom: 0;
	  background-color: #ccc;
	  -webkit-transition: .4s;
	  transition: .4s;
	}
	
	.slider:before {
	  position: absolute;
	  content: "";
	  height: 13px;
	  width: 13px;
	  left: 2px;
	  bottom: 2px;
	  background-color: white;
	  -webkit-transition: .2s;
	  transition: .2s;
	}
	
	input:checked + .slider {
	  background-color: #2196F3;
	}
	
	input:focus + .slider {
	  box-shadow: 0 0 1px #2196F3;
	}
	
	input:checked + .slider:before {
	  -webkit-transform: translateX(13px);
	  -ms-transform: translateX(13px);
	  transform: translateX(13px);
	}
	
	/* Rounded sliders */
	.slider.round {
	  border-radius: 17px;
	}
	
	.slider.round:before {
	  border-radius: 50%;
	}
	
	.button {
	  display: inline-block;
	  padding: 5px 10px;
	  font-size: 10px;
	  cursor: pointer;
	  text-align: center;
	  text-decoration: none;
	  outline: none;
	  color: #fff;
	  background-color: #4CAF50;
	  border: none;
	  border-radius: 5px;
	  box-shadow: 0 1px #999;
	}
	
	.button:hover {background-color: #3e8e41}
	
	.button:active {
	  background-color: #3e8e41;
	  box-shadow: 0 5px #666;
	  transform: translateY(4px);
	}
</style>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c798e37b13fac506a55eb2eebfd5a18&libraries=services"></script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 주소 입력란 -->
   <input type="text" id="address" placeholder="주소를 입력하세요." value="서울특별시 마포구"/>
   <!-- //주소 입력란 -->
   
   <!-- 검색 버튼 -->
   <input type="button" value="검색" onclick="javascript:test();"/>
   <!-- 검색 버튼 -->
   
   <!-- 지도 -->
   <div id="map" style="width:100%;height:700px;"></div>
   <!-- //지도 -->
   
   <script type="text/javascript">
   
      //검색 버튼
      function test(){
         
         // 검색 지역
         var address = $("#address").val();
         
         //ajax
         $.ajax({
            url:"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json",
                 type:"GET",
                 dataType:"json",
                 data:{"address":address},
                 success:function(data){ //성공
                  // 전체 제이슨 보기
                  //console.log(data);
                 
                  // 업체 배열 0번째의 모든 값 보기
                  //console.log(data.stores[0]);
                    
                  // 업체 배열 0번째의 주소 보기
                  //console.log(data.stores[0].addr);
                    
                  // 지도를 표시할 div
                  var mapContainer = document.getElementById('map'),  
                       
                   // 지도의 중심좌표
                   mapOption = { 
                       center: new kakao.maps.LatLng(data.stores[0].lat, data.stores[0].lng),
                       
                       // 지도의 확대 레벨
                       level: 5
                   };
               
                  // 지도를 생성합니다
                  var map = new kakao.maps.Map(mapContainer, mapOption); 
                  
                  // 주소-좌표 변환 객체를 생성합니다
                  var geocoder = new kakao.maps.services.Geocoder();

                  // 주소로 좌표를 검색합니다
                  geocoder.addressSearch(address, function(result, status) {

                  // 정상적으로 검색이 완료됐으면 
                  if (status === kakao.maps.services.Status.OK) {

                     var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                          map.setCenter(coords);
                      } 
                  });    
                  
                  // 마커를 표시할 위치와 title 객체 배열입니다 
                  var positions = [];
                  
                  var imageSrc = "";
              
                  // 검색 결과의 수만큼 배열에 추가
                  for(var i=0;i<data.stores.length;i++){
                     
                        if(data.stores[i].remain_stat == "some" ){
                            imageSrc = "${hContext}/resources/img/main/icon_orange.png"; 
                          }else if(data.stores[i].remain_stat == "plenty"){
                            imageSrc = "${hContext}/resources/img/main/icon_green.png"; 
                          }else if(data.stores[i].remain_stat == "empty"){
                            imageSrc = "${hContext}/resources/img/main/icon_gray.png";  
                          }else if(data.stores[i].remain_stat == "few"){
                            imageSrc = "${hContext}/resources/img/main/icon_red.png";  
                          }else if(data.stores[i].remain_stat == null){
                            imageSrc = "${hContext}/resources/img/main/icon_gray.png";
                          }else if(data.stores[i].remain_stat == "break"){
                            imageSrc = "${hContext}/resources/img/main/icon_gray.png";
                          }
                     positions.push({title: data.stores[i].name
                                 , latlng: new kakao.maps.LatLng(data.stores[i].lat, data.stores[i].lng)
                                 , image : imageSrc
                                 });
            
                  }
                  
                  
                  var imageSize = new kakao.maps.Size(30, 40); 
                  
                  
                  // 검색 결과의 수만큼 마커 출력
                  for (var i = 0; i < positions.length; i ++) {
                     
                      // 마커 이미지의 이미지 크기 입니다
                     
                      
                      // 마커 이미지를 생성합니다    
                      //var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,imageSrc1,imageSrc2,imageSrc3,imageSrc4); 
                      var markerImage = new kakao.maps.MarkerImage(positions[i].image, imageSize ); 
                      
                      // 마커를 생성합니다
                      var marker = new kakao.maps.Marker({
                          map: map, // 마커를 표시할 지도
                          position: positions[i].latlng, // 마커를 표시할 위치
                          title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                          image : markerImage // 마커 이미지 
                      });

					  if(data.stores[i].remain_stat == "break"){
						  data.stores[i].remain_stat = "재고 없음"
					  }else if(data.stores[i].remain_stat == "some"){
						  data.stores[i].remain_stat = "30개~100개"
					  }else if(data.stores[i].remain_stat == "plenty"){
						  data.stores[i].remain_stat = "100개 이상"
					  }else if(data.stores[i].remain_stat == "empty"){
						  data.stores[i].remain_stat = "재고 없음"
					  }else if(data.stores[i].remain_stat == "few"){
						  data.stores[i].remain_stat = "1개~30개"
					  }else if(data.stores[i].remain_stat == null){
						  data.stores[i].remain_stat = "재고 없음"
				      }
				      
                      kakao.maps.event.addListener(marker, 'click', openOverlay(data.stores[i].code, map, marker,data.stores[i].name,
                                                 data.stores[i].addr,data.stores[i].stock_at,data.stores[i].remain_stat));
                  }
                  
                  
                  
            },
               error:function(xhr,status,error){
                    alert("error:"+error);
            },
                    complete:function(data){
            }
         });//--ajax
         
         // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
         function openOverlay(code, map, marker,name,addr,stock,remain) {
            return function() {
               if($("#"+code+"").text()==""){
                  // 마커 위에 커스텀오버레이를 표시합니다
                     // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
                     overlay = new kakao.maps.CustomOverlay({
                         content: '<div class="wrap" id="'+code+'">' + 
                         '    <div class="info">' + 
                         '        <div class="title">' + 
                         '            '+name+'' + 
                         '            <div class="close" onclick="closeOverlay('+"$(this).parent().parent().parent()"+')" title="닫기"></div>' + 
                         '        </div>' + 
                         '        <div class="remain" align="center" style="font-size: 16px;">재고 상태:<b>'+remain+'</b></div>' + 
                         '        <div align="center">'+
                         '           <label class="switch">'+
                         '               <input type="checkbox"><span class="slider round"></span>'+
                         '           </label>'+ 
                         '           <button class="button" >예약</button>'+ 
                         '        </div>'+
                         '        <div class="body">' + 
                         '                <div class="ellipsis">'+addr+'</div>' + 
                         '                <div class="jibun ellipsis">업데이트:<b>'+stock+'</b></div>' + 
                         '        </div>' + 
                         '    </div>' +    
                         '</div>',
                         map: map,
                         position: marker.getPosition()       
                     });
               }
             };
         }//--openOverlay
      }//--test
      
      function closeOverlay(data){
         data.remove();
      }
   </script>
</body>
</html>