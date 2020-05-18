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
	private String 	impuId			;	//아임포트고유번호
	private int		amount			;	//결제금액
	private String 	regId			;	//등록자아이디
	private String 	regDt			;	//등록일
	private String 	modId			;	//수정자아이디
	private String 	modDt			;	//수정일
	private String	name			;	//약국명
	private String	addr			;	//약국주소
	
	public ReservVO() {}

	//do_insert용 생성자
	

	public String getRno() {
		return rno;
	}

	public ReservVO(String rno, String pcode, int maskCnt, String approval, String impuId, int amount, String regId,
			String regDt, String modId, String modDt, String name, String addr) {
		super();
		this.rno = rno;
		this.pcode = pcode;
		this.maskCnt = maskCnt;
		this.approval = approval;
		this.impuId = impuId;
		this.amount = amount;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
		this.name = name;
		this.addr = addr;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public int getMaskCnt() {
		return maskCnt;
	}

	public void setMaskCnt(int maskCnt) {
		this.maskCnt = maskCnt;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getImpuId() {
		return impuId;
	}

	public void setImpuId(String impuId) {
		this.impuId = impuId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "ReservVO [rno=" + rno + ", pcode=" + pcode + ", maskCnt=" + maskCnt + ", approval=" + approval
				+ ", impuId=" + impuId + ", amount=" + amount + ", regId=" + regId + ", regDt=" + regDt + ", modId="
				+ modId + ", modDt=" + modDt + ", name=" + name + ", addr=" + addr + ", toString()=" + super.toString()
				+ "]";
	}

}
