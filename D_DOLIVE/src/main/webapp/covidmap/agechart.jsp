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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>

<head>
    <title>Polar Area Chart</title>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
</head>

<body>
    <div class="ageChart">
	    <div style="width:50%;">
	      <canvas id="ageChart" ></canvas>
         <button onclick="ageConfirmer()">확진자</button>
         <button onclick="ageDead()">사망자</button>
         <button onclick="ageCFR()">치명률</button>
	    </div>
    </div>
   <!--  <button id="polarswitch">폴라 차트</button>
    <button id="barswitch">바 차트</button> -->
<script>

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
	                data: [ 490,
	                        717,
	                        1369,
	                        1972,
	                        1468,
	                        1219,
	                        3100,
	                        627,
	                        148 ],
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
		var ageChart = null;
	    var ctxOne = document.getElementById('ageChart');
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

    </script>
</body>

</html>
