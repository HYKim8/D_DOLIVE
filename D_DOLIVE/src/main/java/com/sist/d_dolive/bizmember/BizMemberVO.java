/**
 * 
 */
package com.sist.d_dolive.bizmember;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public class BizMemberVO extends DTO {

	private String	email	/*	이메일		*/	;
	private String	pw		/*	비밀번호		*/	;
	private String	gender	/*	성별			*/	;
	private String	name	/*	이름			*/	;
	private String	birth	/*	생년월일		*/	;
	private String	addr	/*	주소			*/	;
	private String	addr2	/*	상세주소		*/	;
	private String	zipNo	/*	우편번호		*/	;
	private String	tel		/*	전화번호		*/	;
	private String	bizRno	/*	사업자등록번호	*/	;
	private String	bizTel	/*	업체전화번호	*/	;
	private String	pCode	/*	판매처코드		*/	;
	private String	regId	/*	등록자아이디	*/	;
	private String	regDt	/*	등록일		*/	;
	private String	modId	/*	수정자아이디	*/	;
	private String	modDt	/*	수정일		*/	;

	public BizMemberVO() {}

	public BizMemberVO(String email, String pw, String gender, String name, String birth, String addr, String addr2,
			String zipNo, String tel, String bizRno, String bizTel, String pCode, String regId, String regDt,
			String modId, String modDt) {
		super();
		this.email = email;
		this.pw = pw;
		this.gender = gender;
		this.name = name;
		this.birth = birth;
		this.addr = addr;
		this.addr2 = addr2;
		this.zipNo = zipNo;
		this.tel = tel;
		this.bizRno = bizRno;
		this.bizTel = bizTel;
		this.pCode = pCode;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBizRno() {
		return bizRno;
	}

	public void setBizRno(String bizRno) {
		this.bizRno = bizRno;
	}

	public String getBizTel() {
		return bizTel;
	}

	public void setBizTel(String bizTel) {
		this.bizTel = bizTel;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
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

	@Override
	public String toString() {
		return "BizMemberVO [email=" + email + ", pw=" + pw + ", gender=" + gender + ", name=" + name + ", birth="
				+ birth + ", addr=" + addr + ", addr2=" + addr2 + ", zipNo=" + zipNo + ", tel=" + tel + ", bizRno="
				+ bizRno + ", bizTel=" + bizTel + ", pCode=" + pCode + ", regId=" + regId + ", regDt=" + regDt
				+ ", modId=" + modId + ", modDt=" + modDt + ", toString()=" + super.toString() + "]";
	}
	
}
