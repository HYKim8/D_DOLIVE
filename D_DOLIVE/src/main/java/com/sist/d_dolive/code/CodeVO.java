/**
 * 
 */
package com.sist.d_dolive.code;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public class CodeVO extends DTO {

	private String	codeTypeId	;	/*	코드유형아이디	*/
	private String	codeId		;	/*	코드아이디		*/
	private String	codeTypeNm	;	/*	코드유형명		*/
	private String	codeNm		;	/*	코드명		*/
	private String	useYn		;	/*	사용여부		*/
	private String	seq			;	/*	순서			*/
	private String	pcodeTypeId	;	/*	상위마스터코드	*/
	private String	regId		;	/*	등록자아이디	*/
	private String	regDt		;	/*	등록일		*/

	public CodeVO() {}

	public CodeVO(String codeTypeId, String codeId, String codeTypeNm, String codeNm, String useYn, String seq,
			String pcodeTypeId, String regId, String regDt) {
		super();
		this.codeTypeId = codeTypeId;
		this.codeId = codeId;
		this.codeTypeNm = codeTypeNm;
		this.codeNm = codeNm;
		this.useYn = useYn;
		this.seq = seq;
		this.pcodeTypeId = pcodeTypeId;
		this.regId = regId;
		this.regDt = regDt;
	}

	public String getCodeTypeId() {
		return codeTypeId;
	}

	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeTypeNm() {
		return codeTypeNm;
	}

	public void setCodeTypeNm(String codeTypeNm) {
		this.codeTypeNm = codeTypeNm;
	}

	public String getCodeNm() {
		return codeNm;
	}

	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getPcodeTypeId() {
		return pcodeTypeId;
	}

	public void setPcodeTypeId(String pcodeTypeId) {
		this.pcodeTypeId = pcodeTypeId;
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

	@Override
	public String toString() {
		return "CodeVO [codeTypeId=" + codeTypeId + ", codeId=" + codeId + ", codeTypeNm=" + codeTypeNm + ", codeNm="
				+ codeNm + ", useYn=" + useYn + ", seq=" + seq + ", pcodeTypeId=" + pcodeTypeId + ", regId=" + regId
				+ ", regDt=" + regDt + ", toString()=" + super.toString() + "]";
	}

}
