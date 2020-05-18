
window.addEventListener("load",init);


function init() {

coivdupdatetime();
	
clock();

// 최초에 함수를 한번 실행시켜주고 
setInterval(clock, 1000);

// setInterval이라는 함수로 매초마다 실행을 해줍니다.

// setInterval은 첫번째 파라메터는 함수이고 두번째는 시간인데 밀리초단위로 받습니다. 1000 = 1초 
loadMap();
}

function coivdupdatetime(){
	var time =koreaRegionalData[koreaRegionalData.length-1]["업데이트날짜"];
	
	
	
	document.getElementById("coivdupdatetime").innerText = '데이터 업데이트 : 2020년 '+time.substring(1,2)+'월 '+ time.substring(3,5)+'일 '+time.substring(7,9)+':00:00';
}

function clock() {
    var date = new Date();

    // date Object를 받아오고 
    var month = date.getMonth();
    
    // 연도를 받아옵니다.
    var year = date.getFullYear();
    
    // 달을 받아옵니다 
    var clockDate = date.getDate();

    // 몇일인지 받아옵니다 
    var day = date.getDay();

    // 요일을 받아옵니다. 
    var week = ['일', '월', '화', '수', '목', '금', '토'];

    // 요일은 숫자형태로 리턴되기때문에 미리 배열을 만듭니다. 
    var hours = date.getHours();

    // 시간을 받아오고 
    var minutes = date.getMinutes();
    
    // 분도 받아옵니다.
    var seconds = date.getSeconds();
    var clockTarget = document.getElementById("clock");
    
    // 초까지 받아온후 
    clockTarget.innerText = `현재시간 : ${year}년 ${month+1}월 ${clockDate}일 ${week[day]}요일` +
    `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes }`  : minutes }:${seconds < 10 ? `0${seconds }`  : seconds }`;
    
    // 월은 0부터 1월이기때문에 +1일을 해주고 

    // 시간 분 초는 한자리수이면 시계가 어색해보일까봐 10보다 작으면 앞에0을 붙혀주는 작업을 3항연산으로 했습니다. 
}



	/*지도*/

	//지역 주소
	var sidoaddress = ["",
	                  "서울특별시 중구 세종대로 110",
	                  "부산광역시 연제구 중앙대로 1001",
	                  "대구광역시 중구 공평로 88",
	                  "인천광역시 남동구 정각로29",
	                  "광주광역시 서구 내방로 111",
	                  "대전 서구 둔산로 100",
	                  "울산광역시 남구 중앙로 201",
	                  "세종특별자치시 한누리대로 2130",
	                  "경기 수원시 팔달구 효원로 1",
	                  "강원도 춘천시 중앙로 1",
	                  "충청북도 청주시 상당구 상당로 82",
	                  "충청남도 홍성군 홍북면 충남대로 21",
	                  "전북 전주시 완산구 효자로 225",
	                  "전남 무안군 삼향읍 오룡길 1",
	                  "경상북도 안동시 풍천면 도청대로 455",
	                  "경상남도 창원시 의창구 중앙대로 300",
	                  "제주특별자치도 제주시 문연로 6"];
	//지역별 확진자 현황
	var sidocovidsite = ["",
					    "http://www.seoul.go.kr/coronaV/coronaStatus.do",
					    "http://www.busan.go.kr/corona19/index",
					    "http://www.daegu.go.kr/dgcontent/index.do",
					    "https://www.incheon.go.kr/health/HE020409",
					    "https://www.gwangju.go.kr/",
					    "https://www.daejeon.go.kr/corona19/index.do?tab=2&subTab=1",
					    "http://www.ulsan.go.kr/corona.jsp",
					    "https://www.sejong.go.kr/bbs/R3273/list.do?cmsNoStr=17465",
					    "https://www.gg.go.kr/contents/contents.do?ciIdx=1150&menuId=2909",
					    "https://www.chuncheon.go.kr/index.chuncheon?menuCd=DOM_000000599001000000",
					    "http://www1.chungbuk.go.kr/covid-19/index.do",
					    "http://www.chungnam.go.kr/coronaStatus.do",
					    "http://www.jeonbuk.go.kr/index.jeonbuk",
					    "https://www.jeonnam.go.kr/coronaMainPage.do",
					    "http://www.gb.go.kr/Main/open_contents/section/wel/page.do?mnu_uid=5760&LARGE_CODE=360&MEDIUM_CODE=10&SMALL_CODE=50&SMALL_CODE2=60mnu_order=2",
					    "http://xn--19-q81ii1knc140d892b.kr/main/main.do",
					    "https://www.jeju.go.kr/corona19.jsp"
					    ];
  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(35.95, 128.25), // 지도의 중심좌표
        level: 13 // 지도의 확대 레벨
    };  

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption); 
    var geocoder = new kakao.maps.services.Geocoder();
    var markers=[];
function loadMap(){
    koreaRegionalData.forEach(function(element,index,array){
       if(index!=0&&index!=koreaRegionalData.length-1){
   try{
       geocoder.addressSearch(sidoaddress[index], function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
           var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              var marker = new kakao.maps.Marker({
               map: map,
               position: coords,
			   customData:{
			   "지역이름":koreaRegionalData[index]["지역이름"],
			   "확진자수":koreaRegionalData[index]["확진자수"],
			   "격리해제수":koreaRegionalData[index]["격리해제수"],
			   "사망자수":koreaRegionalData[index]["사망자수"],
			   "십만명당발생율":koreaRegionalData[index]["십만명당발생율"],
			   "지역별확진자비율":koreaRegionalData[index]["지역별확진자비율"]
			   }
            
              });//--마커표시
              markers.push(marker);
 var el="<div style='width:250px;text-align:center;padding:10px;'>";
          el+="<div style='width:100%;border-bottom:1px solid #000;'><span style='text-align:center;'><b>"+koreaRegionalData[index]["지역이름"]+"</b></span></div>";
          el+="<div style='width:100%'><span style='text-align:left;width:65%;display:inline-block;'>확진자수 : </span><span style='text-align:center;width:35%;display:inline-block;'>"+koreaRegionalData[index]["확진자수"]+" 명</span></div>";
          el+="<div style='width:100%'><span style='text-align:left;width:65%;display:inline-block;'>격리해제수 : </span><span style='text-align:center;width:35%;display:inline-block;'>"+koreaRegionalData[index]["격리해제수"]+" 명</span></div>";
          el+="<div style='width:100%'><span style='text-align:left;width:65%;display:inline-block;'>사망자수 : </span><span style='text-align:center;width:35%;display:inline-block;'>"+koreaRegionalData[index]["사망자수"]+" 명</span></div>";
          el+="<div style='width:100%'><span style='text-align:left;width:65%;display:inline-block;'>십만명당발생율 : </span><span style='text-align:center;width:35%;display:inline-block;'>"+koreaRegionalData[index]["십만명당발생율"]+"%</span></div>";
          el+="<div style='width:100%'><span style='text-align:left;width:65%;display:inline-block;'>지역별확진자비율 : </span><span style='text-align:center;width:35%;display:inline-block;'>"+koreaRegionalData[index]["지역별확진자비율"]+"%</span></div>";
          el+="</div>";
             var infowindow = new kakao.maps.InfoWindow({
                 content: el
             });       

             kakao.maps.event.addListener(marker, 'mouseover', function() {
                   infowindow.open(map, marker);  
             });
    kakao.maps.event.addListener(marker, 'mouseout', function() {
                   infowindow.close();
             });
    kakao.maps.event.addListener(marker, 'click', function() {
    	window.open(sidocovidsite[index]);
    	});
       }//if
    
      }); 
 }catch(e){console.log("좌표 데이터 못불러옴 -> "+sidoaddress[index]);} 
       } 
    });
   
}


