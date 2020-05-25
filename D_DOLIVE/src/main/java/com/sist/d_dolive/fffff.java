package com.sist.d_dolive;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fffff {
	
	public static void main(String args[]) {
		
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";
		try {
			Document doc = Jsoup.connect(URL).get();
			
			Elements inspection = doc.select("div.data_table table.num:nth-of-type(1) tbody>tr");
			//Elements inspection = doc.select("div.data_table table.num");
			
			
			String[] test = inspection.text().split(" ");
			for(int i=0; i < test.length; i++) {
				System.out.println(test[i]);
			}
				
			System.out.println(inspection.html());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}