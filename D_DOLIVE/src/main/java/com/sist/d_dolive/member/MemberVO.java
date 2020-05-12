/**
 * 
 */
package com.sist.d_dolive.member;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public class MemberVO extends DTO {
	private String email	; //이메일		
	private String pw		; //비밀번호	
	private String gender	; //성별		
	private String name	    ; //이름		
	private String ihidnum	; //주민등록번호	
	private String addr	    ; //주소		
	private String addr2	; //상세주소	
	private String zipno	; //우편번호	
	private String tel		; //전화번호	
	private String regid	; //등록자아이디	
	private String regdt	; //등록일		
	private String modid	; //수정자아이디	
	private String moddt	; //수정일		

	public MemberVO() {}

	public MemberVO(String email, String pw, String gender, String name, String ihidnum, String addr, String addr2,
			String zipno, String tel, String regid, String regdt, String modid, String moddt) {
		super();
		this.email = email;
		this.pw = pw;
		this.gender = gender;
		this.name = name;
		this.ihidnum = ihidnum;
		this.addr = addr;
		this.addr2 = addr2;
		this.zipno = zipno;
		this.tel = tel;
		this.regid = regid;
		this.regdt = regdt;
		this.modid = modid;
		this.moddt = moddt;
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
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}

	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
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

	/**
	 * @return the regid
	 */
	public String getRegid() {
		return regid;
	}

	/**
	 * @param regid the regid to set
	 */
	public void setRegid(String regid) {
		this.regid = regid;
	}

	/**
	 * @return the regdt
	 */
	public String getRegdt() {
		return regdt;
	}

	/**
	 * @param regdt the regdt to set
	 */
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	/**
	 * @return the modid
	 */
	public String getModid() {
		return modid;
	}

	/**
	 * @param modid the modid to set
	 */
	public void setModid(String modid) {
		this.modid = modid;
	}

	/**
	 * @return the moddt
	 */
	public String getModdt() {
		return moddt;
	}

	/**
	 * @param moddt the moddt to set
	 */
	public void setModdt(String moddt) {
		this.moddt = moddt;
	}

	@Override
	public String toString() {
		return "UserVO [email=" + email + ", pw=" + pw + ", gender=" + gender + ", name=" + name + ", ihidnum="
				+ ihidnum + ", addr=" + addr + ", addr2=" + addr2 + ", zipno=" + zipno + ", tel=" + tel + ", regid="
				+ regid + ", regdt=" + regdt + ", modid=" + modid + ", moddt=" + moddt + ", toString()="
				+ super.toString() + "]";
	}

	





	
	
	
}
