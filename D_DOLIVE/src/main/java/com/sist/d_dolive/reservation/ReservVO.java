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
	
	private String 	rno				;	//예약번호
	private String 	pcode			;	//판매처코드
	private int 	maskCnt			;	//마스크수량
	private String 	approval		;	//예약상태
	private String 	impuid			;	//아임포트고유번호
	private int		amount			;	//결제금액
	private String 	regId			;	//등록자아이디
	private String 	regDt			;	//등록일
	private String 	modId			;	//수정자아이디
	private String 	modDt			;	//수정일
	private String	name			;	//회원이름
	private String	ihidnum			;	//회원주민등록번호
	private String	pname			;	//약국명
	private String	paddr			;	//약국주소
	
	public ReservVO() {}

	//do_insert용 생성자
	public ReservVO(String rno, String pcode, int maskCnt, String approval, String impuid, int amount, String regId,
			String regDt, String modId, String modDt, String name, String ihidnum, String pname, String paddr) {
		super();
		this.rno = rno;
		this.pcode = pcode;
		this.maskCnt = maskCnt;
		this.approval = approval;
		this.impuid = impuid;
		this.amount = amount;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
		this.name = name;
		this.ihidnum = ihidnum;
		this.pname = pname;
		this.paddr = paddr;
	}

	/**
	 * @return the rno
	 */
	public String getRno() {
		return rno;
	}

	/**
	 * @param rno the rno to set
	 */
	public void setRno(String rno) {
		this.rno = rno;
	}

	/**
	 * @return the pcode
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * @param pcode the pcode to set
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
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
	 * @return the impuid
	 */
	public String getImpuid() {
		return impuid;
	}

	/**
	 * @param impuid the impuid to set
	 */
	public void setImpuid(String impuid) {
		this.impuid = impuid;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ihidnum
	 */
	public String getIhidnum() {
		return ihidnum;
	}

	/**
	 * @param ihidnum the ihidnum to set
	 */
	public void setIhidnum(String ihidnum) {
		this.ihidnum = ihidnum;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the paddr
	 */
	public String getPaddr() {
		return paddr;
	}

	/**
	 * @param paddr the paddr to set
	 */
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}

	@Override
	public String toString() {
		return "ReservVO [rno=" + rno + ", pcode=" + pcode + ", maskCnt=" + maskCnt + ", approval=" + approval
				+ ", impuid=" + impuid + ", amount=" + amount + ", regId=" + regId + ", regDt=" + regDt + ", modId="
				+ modId + ", modDt=" + modDt + ", name=" + name + ", ihidnum=" + ihidnum + ", pname=" + pname
				+ ", paddr=" + paddr + ", toString()=" + super.toString() + "]";
	}

}
