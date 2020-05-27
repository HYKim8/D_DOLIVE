
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
	
	
	
	document.getElementById("coivdupdatetime").innerText = '데이터 업데이트 : 2020년 '+time.substring(1,3)+'월 '+ time.substring(4,6)+'일 '+time.substring(7,9)+':00:00';
}

var agedata = '${agedata}';

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
 /*확진자 일일 현황 */   
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



agedata = [490,717,1369,1972,1468,1219,3100,627,148];






var ageConfirmerDatas = {
        type: 'doughnut',
        data: {
            labels: [  '80이상',
                        '70-79',
                        '60-69',
                        '50-59',
                        '40-49',
                        '30-39',
                        '20-29',
                        '10-19',
                        '0-9'],
            datasets: [{
                label: '나이별 확진자 현황',
                data: agedata,
                backgroundColor: [
                	'rgb(255, 99, 132, 0.2)',
                    'rgb(255, 159, 64, 0.2)',
                     'rgb(255, 205, 86, 0.2)',
                     'rgb(102, 255, 51, 0.2)',
                     'rgb(75, 192, 192, 0.2)',
                     'rgb(54, 162, 235, 0.2)',
                     'rgb(153, 102, 255, 0.2)',
                     'rgb(255, 0, 255, 0.2)',
                     'rgb(120, 120, 120, 0.2)'
                ],
                borderColor: [
                	'rgb(255, 99, 132, 0.2)',
                    'rgb(255, 159, 64, 0.2)',
                     'rgb(255, 205, 86, 0.2)',
                     'rgb(102, 255, 51, 0.2)',
                     'rgb(75, 192, 192, 0.2)',
                     'rgb(54, 162, 235, 0.2)',
                     'rgb(153, 102, 255, 0.2)',
                     'rgb(255, 0, 255, 0.2)',
                     'rgb(120, 120, 120, 0.2)'
                ]
            }]
        },
        options: {
		            scales: {
		                yAxes: [{
		                    ticks: {
		                        beginAtZero: true
				                    }
				                }]
				            }
                    ,legend: {
                    	  position: 'top'
                    		  },
                      title : {
                          display: true,
                          text: '확진자 연령별 현황'
                      }
		        }
    };

	var ageDeadDatas = {
			 type: 'doughnut',
		        data: {
		            labels: [  '80이상',
		                        '70-79',
		                        '60-69',
		                        '50-59',
		                        '40-49',
		                        '30-39',
		                        '20-29',
		                        '10-19',
		                        '0-9'],
		            datasets: [{
		                label: '나이별 사망자 현황',
		                data: [ 128,
		                        78,
		                        38,
		                        15,
		                        3,
		                        2,
		                        0,
		                        0,
		                        0 ],
		                backgroundColor: [
		                    'rgb(255, 99, 132, 0.2)',
		                    'rgb(255, 159, 64, 0.2)',
		                     'rgb(255, 205, 86, 0.2)',
		                     'rgb(102, 255, 51, 0.2)',
		                     'rgb(75, 192, 192, 0.2)',
		                     'rgb(54, 162, 235, 0.2)',
		                     'rgb(153, 102, 255, 0.2)',
		                     'rgb(255, 0, 255, 0.2)',
		                     'rgb(120, 120, 120, 0.2)'
		                ],
		                borderColor: [
		                    'rgb(255, 99, 132, 0.2)',
		                    'rgb(255, 159, 64, 0.2)',
		                     'rgb(255, 205, 86, 0.2)',
		                     'rgb(102, 255, 51, 0.2)',
		                     'rgb(75, 192, 192, 0.2)',
		                     'rgb(54, 162, 235, 0.2)',
		                     'rgb(153, 102, 255, 0.2)',
		                     'rgb(255, 0, 255, 0.2)',
		                     'rgb(120, 120, 120, 0.2)'
		                ]
		            }]
		        },
		        options: {
		                    scales: {
		                        yAxes: [{
		                            ticks: {
		                                beginAtZero: true
		                                    }
		                                }]
		                            }
		                    ,legend: {
		                          position: 'top'
		                              },
                              title : {
                                  display: true,
                                  text: '사망자 연령별 현황'
                              }
		                }		
	};
	
	var ageCFRDatas = {
			 type: 'doughnut',
		        data: {
		            labels: [  '80이상',
		                        '70-79',
		                        '60-69',
		                        '50-59',
		                        '40-49',
		                        '30-39',
		                        '20-29',
		                        '10-19',
		                        '0-9'],
		            datasets: [{
		                label: '나이별 치명률 현황',
		                data: [ 26.12,
		                        10.88,
		                        2.78,
		                        0.76,
		                        0.2,
		                        0.16,
		                        0,
		                        0,
		                        0 ],
		                backgroundColor: [
		                    'rgb(255, 99, 132, 0.2)',
		                    'rgb(255, 159, 64, 0.2)',
		                     'rgb(255, 205, 86, 0.2)',
		                     'rgb(102, 255, 51, 0.2)',
		                     'rgb(75, 192, 192, 0.2)',
		                     'rgb(54, 162, 235, 0.2)',
		                     'rgb(153, 102, 255, 0.2)',
		                     'rgb(255, 0, 255, 0.2)',
		                     'rgb(120, 120, 120, 0.2)'
		                ],
		                borderColor: [
		                    'rgb(255, 99, 132, 0.2)',
		                    'rgb(255, 159, 64, 0.2)',
		                     'rgb(255, 205, 86, 0.2)',
		                     'rgb(102, 255, 51, 0.2)',
		                     'rgb(75, 192, 192, 0.2)',
		                     'rgb(54, 162, 235, 0.2)',
		                     'rgb(153, 102, 255, 0.2)',
		                     'rgb(255, 0, 255, 0.2)',
		                     'rgb(120, 120, 120, 0.2)'
		                ]
		            }]
		        },
		        options: {
		                    scales: {
		                        yAxes: [{
		                            ticks: {
		                                beginAtZero: true
		                                    }
		                                }]
		                            }
		                    ,legend: {
		                          position: 'top'
		                              },
                              title : {
                                  display: true,
                                  text: '치명률(사망자/확진자) 연령별 현황'
                              }
		                }
	};
	
	var ctxOne = document.getElementById('ageChart');
	var ageChart;
	
	ageChart = new Chart(ctxOne, ageConfirmerDatas);
    
    
    function ageConfirmer(){
	   ageChart.destroy();
       ageChart = new Chart(ctxOne, ageConfirmerDatas);
    }

    function ageDead(){
    	ageChart.destroy();
    	ageChart = new Chart(ctxOne, ageDeadDatas);
	    }
    function ageCFR(){
    	  ageChart.destroy();
    	ageChart = new Chart(ctxOne, ageCFRDatas);
	    }



        google.charts.load('current', {'packages':['corechart', 'controls']});

        google.charts.setOnLoadCallback(drawDashboard);

        function drawDashboard() {
            
      	  var data = new google.visualization.DataTable();
            data.addColumn('datetime', '날짜');
            data.addColumn('number', '확진자수');
            data.addColumn('number', '완치자수');
            data.addColumn('number', '사망자수');

             var datas = [];

              //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
             var chartDateformat  = 'MM월dd일';

             //라인차트의 라인 수
             var chartLineCount    = 10;

             console.log(koreaRegionalCumulativeData[1][1]);         
             for(var i =0; i<koreaRegionalCumulativeData.length;i++){
                 //x 날짜
                 var obj=[];
                 var dateArray = koreaRegionalCumulativeData[i][0].split('/');
                 
                 obj.push(new Date('2020',dateArray[0]-1,dateArray[1]))
                 obj.push(koreaRegionalCumulativeData[i][3])
                 obj.push(koreaRegionalCumulativeData[i][4])
                 obj.push(koreaRegionalCumulativeData[i][1])
                 
                 datas.push(obj);
                }
             
            data.addRows(datas);

            var chart = new google.visualization.ChartWrapper({
                chartType   : 'LineChart',
                containerId : 'chart_div', //라인 차트 생성할 영역
                options     : {
                                isStacked   : 'percent',
                                focusTarget : 'category',
                                height          : 500,
                                width              : '100%',
                                legend          : { position: "top", textStyle: {fontSize: 13}},
                                pointSize        : 5,
                                tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                                hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                    months: {format: ['MM월']},
                                                                    days  : {format: ['dd일']}}
                                                                  },textStyle: {fontSize:12}},
  			                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
  			                animation        : {startup: true,duration: 1000,easing: 'in' },
  			                annotations    : {pattern: chartDateformat,
  			                                textStyle: {
  			                                fontSize: 15,
  			                                bold: true,
  			                                italic: true,
  			                                color: '#871b47',
  			                                auraColor: '#d799ae',
  			                                opacity: 0.8,
  			                                pattern: chartDateformat
  			                              }
  			                            }
                }
              });


            var control = new google.visualization.ControlWrapper({
                controlType: 'DateRangeFilter',
                containerId: 'filter_div',  //control bar를 생성할 영역
                options: {
                      filterColumnIndex: 0
                  }
              });

            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);


            
          var dashboard = new google.visualization.Dashboard(
              document.getElementById('dashboard_div'));


          dashboard.bind(control, chart);

          dashboard.draw(data);
          }
        
        google.charts.load('current', {
            'packages':['geochart'],
            // Note: you will need to get a mapsApiKey for your project.
            // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
            'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
          });
          google.charts.setOnLoadCallback(drawRegionsMap);

          function drawRegionsMap() {
              
              let datas=[['국명', '확진자수', '사망자']];
              for(let i in marker){
            	  datas.push([
            		           marker[i].Name_en, 
            		           marker[i]["확진자수"],
            		           marker[i]["사망자수"]
            		          ]);
                  }
            var data = google.visualization.arrayToDataTable(datas);

            var options = {colors: ['white', 'red']};

            var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

            chart.draw(data, options);
          }
          
          google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);

          function drawChart() {
              var data = new google.visualization.DataTable();
                data.addColumn('datetime', '날짜');
                data.addColumn('number', '확진자수');
                data.addColumn('number', '완치자수');
                data.addColumn('number', '사망자수');

                 var datas = [];

                  //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
                 var chartDateformat  = 'MM월dd일';

                 //라인차트의 라인 수
                 var chartLineCount    = 10;

                 console.log(crawlWorldCumulativeData[1][1]);         
                 for(var i =0; i<crawlWorldCumulativeData.length;i++){
                     //x 날짜
                     var obj=[];
                     var dateArray = crawlWorldCumulativeData[i][0].split('/');
                     
                     obj.push(new Date('2020',dateArray[0]-1,dateArray[1]))
                     obj.push(crawlWorldCumulativeData[i][1])
                     obj.push(crawlWorldCumulativeData[i][3])
                     obj.push(crawlWorldCumulativeData[i][2])
                     
                     datas.push(obj);
                    }
                 
                data.addRows(datas);

              var options = {
                            isStacked   : 'precent',
                            focusTarget : 'category',
                            height          : 500,
                            width              : '100%',
                            legend          : { position: "top", textStyle: {fontSize: 13}},
                            pointSize        : 5,
                            tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                            hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                months: {format: ['MM월']},
                                                                days  : {format: ['dd일']}}
                                                              },textStyle: {fontSize:12}},
                              vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                              series: {
                                  0: { color: '#3366FF' },
                                  1: { color: '#66FF66' },
                                  2: { color: '#FF3333' }
                                }
              };

              var date_formatter = new google.visualization.DateFormat({ pattern: 'MM월dd일'});
                date_formatter.format(data, 0);
                
              var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

              chart.draw(data, options);
            }
          
