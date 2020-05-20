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


<!DOCTYPE html>
<html style="width:100%;height:100%;margin:0;padding:0;">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://livecorona.co.kr/data/worldCumulativeData.js"></script>
</head>
<body >
    
    <div id="curve_chart" style="width: 100%; height: 500px"></div>
    
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
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
        </script>
    </script>
</body>
</html>