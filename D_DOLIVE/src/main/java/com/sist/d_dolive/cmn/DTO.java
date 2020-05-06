/**
 *<pre>
 * com.sist.ehr.cmn
 * Class Name : DTO.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-04-07           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-04-07 
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
public class DTO {
	//글번호
	private int num;
	
	//총글수 
	private int totalCnt;
	
	public DTO() {}

	public DTO(int num, int totalCnt) {
		super();
		this.num = num;
		this.totalCnt = totalCnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	@Override
	public String toString() {
		return "DTO [num=" + num + ", totalCnt=" + totalCnt + ", toString()=" + super.toString() + "]";
	}
	
}
