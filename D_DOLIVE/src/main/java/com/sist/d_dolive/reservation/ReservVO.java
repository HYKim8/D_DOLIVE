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
	
	private String 	rNo				;	//예약번호
	private String 	pCode			;	//판매처코드
	private int 	maskCnt			;	//마스크수량
	private String 	approval		;	//예약상태
	private String 	impuId			;	//아임포트고유번호
	private String 	merchantUid		;	//가맹점거래고유번호
	private int		amount			;	//결제금액
	private int 	taxfree			;	//면세금액
	private int 	checksum		;	//취소가능잔액
	private String 	reason			;	//취소사유
	private String 	refundHolder	;	//환불계좌예금주
	private String 	refundBank		;	//환불계좌은행코드
	private String 	refundAccount	;	//환불계좌계좌번호
	private String 	regId			;	//등록자아이디
	private String 	regDt			;	//등록일
	private String 	modId			;	//수정자아이디
	private String 	modDt			;	//수정일
	private String 	email			; //이메일		
	private String 	name	    	; //이름		
	private String 	ihidnum			; //주민등록번호	
	private String 	addr	    	; //주소		
	private String 	zipno			; //우편번호	
	private String 	tel				; //전화번호	
	
	public ReservVO() {}

	//do_insert용 생성자
	public ReservVO(String rNo, String pCode, int maskCnt, String approval, int amount, String regId, String regDt,
			String modId, String modDt) {
		super();
		this.rNo = rNo;
		this.pCode = pCode;
		this.maskCnt = maskCnt;
		this.approval = approval;
		this.amount = amount;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	public ReservVO(String rNo, String pCode, int maskCnt, String approval, String impuId, String merchantUid,
			int amount, int taxfree, int checksum, String reason, String refundHolder, String refundBank,
			String refundAccount, String regId, String regDt, String modId, String modDt, String email, String name,
			String ihidnum, String addr, String zipno, String tel) {
		super();
		this.rNo = rNo;
		this.pCode = pCode;
		this.maskCnt = maskCnt;
		this.approval = approval;
		this.impuId = impuId;
		this.merchantUid = merchantUid;
		this.amount = amount;
		this.taxfree = taxfree;
		this.checksum = checksum;
		this.reason = reason;
		this.refundHolder = refundHolder;
		this.refundBank = refundBank;
		this.refundAccount = refundAccount;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
		this.email = email;
		this.name = name;
		this.ihidnum = ihidnum;
		this.addr = addr;
		this.zipno = zipno;
		this.tel = tel;
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
	 * @return the impuId
	 */
	public String getImpuId() {
		return impuId;
	}

	/**
	 * @param impuId the impuId to set
	 */
	public void setImpuId(String impuId) {
		this.impuId = impuId;
	}

	/**
	 * @return the merchantUid
	 */
	public String getMerchantUid() {
		return merchantUid;
	}

	/**
	 * @param merchantUid the merchantUid to set
	 */
	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
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
	 * @return the taxfree
	 */
	public int getTaxfree() {
		return taxfree;
	}

	/**
	 * @param taxfree the taxfree to set
	 */
	public void setTaxfree(int taxfree) {
		this.taxfree = taxfree;
	}

	/**
	 * @return the checksum
	 */
	public int getChecksum() {
		return checksum;
	}

	/**
	 * @param checksum the checksum to set
	 */
	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the refundHolder
	 */
	public String getRefundHolder() {
		return refundHolder;
	}

	/**
	 * @param refundHolder the refundHolder to set
	 */
	public void setRefundHolder(String refundHolder) {
		this.refundHolder = refundHolder;
	}

	/**
	 * @return the refundBank
	 */
	public String getRefundBank() {
		return refundBank;
	}

	/**
	 * @param refundBank the refundBank to set
	 */
	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	/**
	 * @return the refundAccount
	 */
	public String getRefundAccount() {
		return refundAccount;
	}

	/**
	 * @param refundAccount the refundAccount to set
	 */
	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the zipno
	 */
	public String getZipno() {
		return zipno;
	}

	/**
	 * @param zipno the zipno to set
	 */
	public void setZipno(String zipno) {
		this.zipno = zipno;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "ReservVO [rNo=" + rNo + ", pCode=" + pCode + ", maskCnt=" + maskCnt + ", approval=" + approval
				+ ", impuId=" + impuId + ", merchantUid=" + merchantUid + ", amount=" + amount + ", taxfree=" + taxfree
				+ ", checksum=" + checksum + ", reason=" + reason + ", refundHolder=" + refundHolder + ", refundBank="
				+ refundBank + ", refundAccount=" + refundAccount + ", regId=" + regId + ", regDt=" + regDt + ", modId="
				+ modId + ", modDt=" + modDt + ", email=" + email + ", name=" + name + ", ihidnum=" + ihidnum
				+ ", addr=" + addr + ", zipno=" + zipno + ", tel=" + tel + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
