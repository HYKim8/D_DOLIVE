package com.sist.d_dolive.countdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

	public Parser() {
	};

	public List<String> Parse() throws IOException {

		List<String> outList = new ArrayList<String>();
		String URL = "https://flexable.kr/mask";
		Document doc = Jsoup.connect(URL).get();

		Elements elem = doc.select(".relative");
		String[] str = elem.text().split("문제가 있는 마스크 인가요\\?");

		Elements elemSite = doc.select(".relative a");

		// Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");

//		for(String element:str)	{
//			System.out.println(element.trim());
//		}

		for (String element : str) {

			// if( element.substring(element.length()-5, element.length())!="판매종료" ) {
			String result = element.substring(element.length() - 5, element.length() - 1);

			if (!result.equals("판매종료")) { // 판매종료만 제외
				// if(result2.equals("2020")) { //판매종료 , 게릴라판매 제외..
				// System.out.println(element.trim());
				outList.add(element.trim());
				System.out.println(element.trim());
			}
		}
		return outList;
	}

	public Elements ParseSite() throws IOException {

		Elements outSite = new Elements();
		String URL = "https://flexable.kr/mask";
		Document doc = Jsoup.connect(URL).get();

		Elements elemSite = doc.select(".relative a");

		for (int i = 0; i < elemSite.size(); i++) {
			if (i % 2 == 0) {
				System.out.println("키키:" + elemSite.get(i).attr("href"));
				outSite.add(elemSite.get(i));

			} 

		}
		return outSite;
	}
}
