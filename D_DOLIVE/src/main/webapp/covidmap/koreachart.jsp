<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 17.            최초 생성
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
<html>

<head>
    <title>Line Chart</title>
      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
      <script src="https://livecorona.co.kr/data/koreaRegionalCumulativeData.js"></script>
</head>

<body>
     <div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
        <div id="chart_div"></div>
        <div id="filter_div" style="width:100%;"></div>
    </div>
      
      
    <script type="text/javascript">

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
    </script>
</body>
</html>