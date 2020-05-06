package com.sist.countdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

	public Parser() {};
	
	public List<String> coreaParse() throws IOException {
		
		List<String> outList = new ArrayList<String>();
		String URL = "https://flexable.kr/mask";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select(".relative");
		String[] str = elem.text().split("문제가 있는 마스크 인가요\\?");
		Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");
		
//		for(String element:str)	{
//			System.out.println(element.trim());
//		}

	for(String element:str)	{ // -- 3. Elemntes 길이만큼 반복한다.
		// System.out.println(element.trim()); // -- 4. 원하는 요소가 출력된다.
		// if( element.substring(element.length()-5, element.length())!="판매종료" ) {
		String result = element.substring(element.length() - 5, element.length() - 1);
		//String result2 = element.substring(element.length() - 17, element.length() - 13);

		if (!result.equals("판매종료")) { // 판매종료만 제외
			// if(result2.equals("2020")) { //판매종료 , 게릴라판매 제외..
			//System.out.println(element.trim());
			outList.add(element.trim());
			System.out.println(element.trim());
			}
		}
	return outList;
	}
}

