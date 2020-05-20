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
    </style>
</head>

<body>
    <div style="width:50%;">
      <canvas id="myChart" ></canvas>
    </div>
   <!--  <button id="polarswitch">폴라 차트</button>
    <button id="barswitch">바 차트</button> -->
<script>
var ctx = document.getElementById('myChart');
var datas = {
	    type: 'polarArea',
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
	            data: [490,
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
	                 'rgb(75, 192, 192, 0.2)',
	                 'rgb(54, 162, 235, 0.2)',
	                 'rgb(153, 102, 255, 0.2)',
	                 'rgb(201, 203, 207, 0.2)',
	                 'rgb(102, 255, 51, 0.2)',
	                 'rgb(255, 0, 255, 0.2)'
	            ],
	            borderColor: [
	            	 'rgb(255, 99, 132, 0.2)',
                    'rgb(255, 159, 64, 0.2)',
                     'rgb(255, 205, 86, 0.2)',
                     'rgb(75, 192, 192, 0.2)',
                     'rgb(54, 162, 235, 0.2)',
                     'rgb(153, 102, 255, 0.2)',
                     'rgb(201, 203, 207, 0.2)',
                     'rgb(102, 255, 51, 0.2)',
                     'rgb(255, 0, 255, 0.2)'
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
	    }
	    }
	};

	window.onload = function() {
	    var ctx = document.getElementById('myChart');
	    window.myPolarArea = Chart.PolarArea(ctx, datas);
	};

/*     document.getElementById('barswitch').addEventListener('click', function() {
    	datas.type = 'bar';
    	window.myPolarArea.update();
    });

    document.getElementById('polarswitch').addEventListener('click', function() {
        datas.type = 'polarArea';
        window.myPolarArea.update();
    }); */


    </script>
</body>

</html>
