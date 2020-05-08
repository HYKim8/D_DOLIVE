/**
 * 
 */
package com.sist.d_dolive.reservation;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public class ReservVO extends DTO {
	
	private String rNo		;//예약 번호
	private String pCode    ;//판매처 코드
	private int	   maskCnt ;//마스크 수량
	private String approval ;//예약 상태
	private int    pay      ;//결제 금액
	private String regId   ;//등록자 아이디(이메일)
	private String regDt   ;//등록일
	private String modId   ;//수정자 아이디(이메일)
	private String modDt   ;//수정일
	
	public ReservVO() {}

	public ReservVO(String rNo, String pCode, int maskCnt, String approval, int pay, String regId, String regDt,
			String modId, String modDt) {
		super();
		this.rNo = rNo;
		this.pCode = pCode;
		this.maskCnt = maskCnt;
		this.approval = approval;
		this.pay = pay;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	/**
	 * @return the rNo
	 */
	public String getrNo() {
		return rNo;
	}

	/**
	 * @param rNo the rNo to set
	 */
	public void setrNo(String rNo) {
		this.rNo = rNo;
	}

	/**
	 * @return the pCode
	 */
	public String getpCode() {
		return pCode;
	}

	/**
	 * @param pCode the pCode to set
	 */
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	/**
	 * @return the maskCnt
	 */
	public int getMaskCnt() {
		return maskCnt;
	}

	/**
	 * @param maskCnt the maskCnt to set
	 */
	public void setMaskCnt(int maskCnt) {
		this.maskCnt = maskCnt;
	}

	/**
	 * @return the approval
	 */
	public String getApproval() {
		return approval;
	}

	/**
	 * @param approval the approval to set
	 */
	public void setApproval(String approval) {
		this.approval = approval;
	}

	/**
	 * @return the pay
	 */
	public int getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(int pay) {
		this.pay = pay;
	}

	/**
	 * @return the regId
	 */
	public String getRegId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(String regId) {
		this.regId = regId;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	/**
	 * @return the modId
	 */
	public String getModId() {
		return modId;
	}

	/**
	 * @param modId the modId to set
	 */
	public void setModId(String modId) {
		this.modId = modId;
	}

	/**
	 * @return the modDt
	 */
	public String getModDt() {
		return modDt;
	}

	/**
	 * @param modDt the modDt to set
	 */
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "ReservVO [rNo=" + rNo + ", pCode=" + pCode + ", maskCnt=" + maskCnt + ", approval=" + approval
				+ ", pay=" + pay + ", regId=" + regId + ", regDt=" + regDt + ", modId=" + modId + ", modDt=" + modDt
				+ ", toString()=" + super.toString() + "]";
	}


	
}
