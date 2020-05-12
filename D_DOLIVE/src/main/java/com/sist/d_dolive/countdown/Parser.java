package com.sist.d_dolive.countdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

	public Parser() {};

	//날짜 뽑기용
	public List<String> Parse() throws IOException {
		
		//리턴용 list
		List<String> outList = new ArrayList<String>();
		 
		String URL = "https://flexable.kr/mask";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select(".relative"); // 사이트에서 클래스이름 .relative 크롤링
		String[] str = elem.text().split("문제가 있는 마스크 인가요\\?"); // "문제가 있는 마스크 인가요\\?"기준으로 잘라서 배열에 한 건씩 담기


		for (String element : str) { 
		  String result = element.substring(element.length() - 5, element.length() - 1); //뒤에 4글자 잘라서
			if (!result.equals("판매종료")) { // 판매종료는 제외				
				outList.add(element.trim()); 
				System.out.println(element.trim());
			}
		}
		return outList; //판매종료 제외한 값 리턴
	}

	
	//사이트 연결용
	public Elements ParseSite() throws IOException {

		Elements outSite = new Elements();
		String URL = "https://flexable.kr/mask";
		Document doc = Jsoup.connect(URL).get();
		Elements elemSite = doc.select(".relative a"); // relative 클래스의 a태그 크롤링

		for (int i = 0; i < elemSite.size(); i++) {
			
			if (i % 2 == 0) { // 필요없는 링크도 와서 필요한 짝수 링크만 받아오기
				System.out.println("키키:" + elemSite.get(i).attr("href")); //href 만 가져오기
				outSite.add(elemSite.get(i));
			} 
		}
		return outSite; 
	}
}
