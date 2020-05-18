<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 16.            최초 생성
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
<meta charset="UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   <script src="https://livecorona.co.kr/data/worldData.js"></script>
</head>
<body>          

 <div id="regions_div" style="width: 900px; height: 500px;"></div>
                            
<script type="text/javascript">

   
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
    </script>
</body>
</html>