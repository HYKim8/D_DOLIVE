/**
 *<pre>
 * com.sist.ehr.cmn
 * Class Name : SearchVO.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-04-08           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-04-08 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */

package com.sist.d_dolive.cmn;

/**
 * @author sist
 *
 */
public class SearchVO extends DTO {
	//페이지 사이즈
	private int pageSize;
	
	//페이지 넘버
	private int pageNum;
	
	//검색어
	private String searchWord;
	
	//검색어02
	private String searchWord02;
	
	public SearchVO() {}

	public SearchVO(int pageSize, int pageNum, String searchWord, String searchWord02) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchWord = searchWord;
		this.searchWord02 = searchWord02;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchWord02() {
		return searchWord02;
	}

	public void setSearchWord02(String searchWord02) {
		this.searchWord02 = searchWord02;
	}

	@Override
	public String toString() {
		return "SearchVO [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchWord=" + searchWord
				+ ", searchWord02=" + searchWord02 + ", toString()=" + super.toString() + "]";
	}

}
