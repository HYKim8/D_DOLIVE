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
      <div id="chart_div" width="400px" height="400px"></div>
      
      
    <script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawLineColors);

    function drawLineColors() {
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'X');
          data.addColumn('number', '확진자수');
          data.addColumn('number', '완치자수');
          data.addColumn('number', '사망자수');

           var datas = [];
                    
           for(var i =0; i<koreaRegionalCumulativeData.length-1;i++){
               //x 날짜
               var obj=[];
               obj.push(koreaRegionalCumulativeData[i][0])
               obj.push(koreaRegionalCumulativeData[i][3])
               obj.push(koreaRegionalCumulativeData[i][4])
               obj.push(koreaRegionalCumulativeData[i][1])
               
               datas.push(obj);
              }
          console.log(datas);
          console.log(koreaRegionalCumulativeData.length);
          data.addRows(datas);

          var options = {
            hAxis: {
              title: 'Time'
            },
            vAxis: {
              title: 'Popularity'
            },
            colors: ['#a52714', '#097138']
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
          chart.draw(data, options);
        }
    </script>
</body>
</html>