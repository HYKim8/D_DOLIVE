/**
 *<pre>
 * 프로젝트명 : DaoWEB
 * 패키지명 : com.hr.cmn
 * 클래스명 : StringUtil.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-24    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-24 오후 2:14:17
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.sist.d_dolive.cmn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 모든 메소드는 static method
 * @author sist
 *
 */
public class StringUtil {
	
	private final static Logger LOG = LoggerFactory.getLogger(StringUtil.class);
	
	public static Date getToDate(String dateStr,String format) {
		String formatStr = format;
		SimpleDateFormat transFormat = new SimpleDateFormat(formatStr);
		Date dateS = new Date();
		
		try {
			dateS = transFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOG.debug("format:"+format);
		LOG.debug("dateS:"+dateS);
		
		return dateS;
	}
	
	/**
	 * 
	 *메서드명 : getUUID
	 *작성일 : 2020. 3. 11.
	 *작성자 : sist
	 *설명 : UUID
	 *@return String
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String retUUID = uuid.toString().replace("-", "");
		LOG.debug("retUUID:"+retUUID);
		return retUUID;
	}
	
	/**
	 * 
	 *메서드명 : getDate
	 *작성일 : 2020. 3. 11.
	 *작성자 : sist
	 *설명 : 날짜 포맷
	 *@param format
	 *@return format String date
	 */
	public static String getDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}

	/**
	 * 
	 *메서드명 : renderPaging
	 *작성일 : 2020. 2. 27.
	 *작성자 : sist
	 *설명 : 총글수, 현재 페이지번호, 한 페이지당 보여질 글수(10), bottom 숫자(10), link url, javascript 이름 
	 *@param maxNum_i
	 *@param currPageNoIn_i
	 *@param rowsPerPage_i
	 *@param bottomCount_i
	 *@param url_i
	 *@param scriptName_i
	 *@return String
	 */
	public static String renderPaging(int maxNum_i, int currPageNoIn_i, int rowsPerPage_i, int bottomCount_i, String url_i, String scriptName_i) {
		int maxNum = 0; // 총 갯수
		int currPageNo = 1; // 현재 페이지 번호 : page_num
		int rowPerPage = 10; // 한페이지에 보여질 행수 : page_size
		int bottomCount = 10; // 바닥에 보여질 페이지 수: 10
	
		maxNum = maxNum_i;
		currPageNo = currPageNoIn_i;
		rowPerPage = rowsPerPage_i;
		bottomCount = bottomCount_i;

		String url = url_i; // 호출 URL
		String scriptName = scriptName_i; // 호출 자바스크립트

		int maxPageNo = ((maxNum - 1) / rowPerPage) + 1;
		int startPageNo = ((currPageNo - 1) / bottomCount) * bottomCount + 1;//
		int endPageNo = ((currPageNo - 1) / bottomCount + 1) * bottomCount;
		int nowBlockNo = ((currPageNo - 1) / bottomCount) + 1;
		int maxBlockNo = ((maxNum - 1) / bottomCount) + 1;

		int inx = 0;
		StringBuilder html = new StringBuilder();
		if (currPageNo > maxPageNo) {
			return "";
		}

		html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">   \n");
		html.append("<tr>                       \n");
		html.append("<td align=\"center\">                                                                    \n");
		//html.append("<ul class=\"pagination pagination-sm\">                                                  \n");
		// <<
		if (nowBlockNo > 1 && nowBlockNo <= maxBlockNo) {
			html.append("<a href=\"javascript:" + scriptName + "( '" + url+ "', 1 );\">  \n");
			html.append("&laquo;   \n");
			html.append("</a>      \n");
		}

		// <
		if (startPageNo > bottomCount) {
			html.append("<a href=\"javascript:" + scriptName + "( '" + url + "'," + (startPageNo - 1)+ ");\"> \n");
			html.append("<        \n");
			html.append("</a>     \n");
		}


		// 1 2 3 ... 10 (숫자보여주기)
		for (inx = startPageNo; inx <= maxPageNo && inx <= endPageNo; inx++) {
	    
			if (inx == currPageNo) {
				html.append("<b>" + inx + "</b> &nbsp;&nbsp; \n");
			} else {
				html.append("<a href=\"javascript:" + scriptName + "('" + url + "'," + inx+ ");\" >" + inx + "</a> &nbsp;&nbsp; \n");
			}
		}
	   
		// >
		if (maxPageNo >= inx) {
			html.append("<a href=\"javascript:" + scriptName + "('" + url + "',"+ ((nowBlockNo * bottomCount) + 1) + ");\"> \n");
			html.append(">                       \n");
			html.append("</a>              \n");
		}

		// >>
		if (maxPageNo >= inx) {
			html.append("<a href=\"javascript:" + scriptName + "('" + url + "'," + maxPageNo+ ");\">      \n");
			html.append("&raquo;     \n");
			html.append("</a>    \n");
		}

		html.append("</td>   \n");
		html.append("</tr>   \n");
		html.append("</table>   \n");

		return html.toString();
	}
	
	/**
	 * 
	 *메서드명 : makeSelectBox
	 *작성일 : 2020. 2. 27.
	 *작성자 : sist
	 *설명 : 
	 *@param list
	 *@param selectBoxNm
	 *@param selectNm
	 *@param allYn
	 *@return String
	 */
//	public static String makeSelectBox(List<CodeVO> list, String selectBoxNm, String selectNm, boolean allYn) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("<select class='form-control input-sm' name='"+selectBoxNm+"' id='"+selectBoxNm+"' > \n");
//		//전체
//		if(allYn==true) {
//			sb.append("<option value='' >전체</option> \n");
//		}
//		//for
//		for(CodeVO vo:list) {
//			sb.append("<option value='"+vo.getDtlId()+"' ");
//			if(selectNm.equals(vo.getDtlId())) {
//				sb.append("selected='selected' ");
//			}
//			sb.append(">");
//			sb.append(vo.getDtlNm());
//			sb.append("</option> \n");
//		}
//		sb.append("</select> \n");
//		
//		LOG.debug("========================================");
//		LOG.debug("=sb.toString()="+sb.toString());
//		LOG.debug("========================================");
//		
//		return sb.toString();
//		
////		<select name="search_div" id="search_div">
////			<option value="">전체</option>
////			<option value="10" <%if(searchDiv.equals("10"))out.print("selected"); %> >제목</option>
////			<option value="20" <%if(searchDiv.equals("20"))out.print("selected"); %> >내용</option>
////			<option value="30" <%if(searchDiv.equals("30"))out.print("selected"); %> >등록자</option>
////		</select>
//	}
	
	/**
	 * 
	 *메서드명 : nvl
	 *작성일 : 2020. 2. 24.
	 *작성자 : sist
	 *설명 : null -> ""
	 *@param val String
	 *@return String
	 */
	public static String nvl(String val) {
		return nvl(val,"");
	}
	
	/**
	 * 
	 *메서드명 : nvl
	 *작성일 : 2020. 2. 24.
	 *작성자 : sist
	 *설명 : request param null to ""
	 *@param val 원본 String
	 *@param rep 치환 String
	 *@return String
	 */
	public static String nvl(String val, String rep) {
		if(val==null || val.equals("")) {
			val = rep;
		}
		
		return val;
	}
	
	/**
	 * 
	 *Method Name:getCutUTFString
	 *작성일: 2020. 2. 27.
	 *작성자: sist
	 *설명: 문자를 특정길이
	 *@param str
	 *@param len
	 *@param tail 
	 *@return
	 */
	public static String getCutUTFString(String str, int len, String tail) {
		if (str.length() <= len) {
			return str;
		}
		
		StringCharacterIterator sci = new StringCharacterIterator(str);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(sci.first());
		
		for (int i = 1; i < len; i++) {
			if (i < len - 1) {
				buffer.append(sci.next());
			} else {
				char c = sci.next();
				if (c != 32) { // 마지막 charater가 공백이 아닐경우
					buffer.append(c);
				}
			}
		}
		
		buffer.append(tail);
		
		return buffer.toString();
	}	  
	
}
