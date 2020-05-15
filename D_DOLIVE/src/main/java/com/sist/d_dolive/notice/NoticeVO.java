package com.sist.d_dolive.notice;

import com.sist.d_dolive.cmn.DTO;

public class NoticeVO extends DTO {

	private String	pcode			/*	판매처코드		*/	;
	private String	name			/*	판매처이름		*/	;
	private String	addr			/*	판매처주소		*/	;
	private String	email			/*	이메일		*/	;
	private String	remainStockYn	/*	입고발송여부	*/	;
	private String	emptyStockYn	/*	품절발송여부	*/	;
	
	public NoticeVO() {}

	public NoticeVO(String pcode, String name, String addr, String email, String remainStockYn, String emptyStockYn) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.addr = addr;
		this.email = email;
		this.remainStockYn = remainStockYn;
		this.emptyStockYn = emptyStockYn;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemainStockYn() {
		return remainStockYn;
	}

	public void setRemainStockYn(String remainStockYn) {
		this.remainStockYn = remainStockYn;
	}

	public String getEmptyStockYn() {
		return emptyStockYn;
	}

	public void setEmptyStockYn(String emptyStockYn) {
		this.emptyStockYn = emptyStockYn;
	}

	@Override
	public String toString() {
		return "NoticeVO [pcode=" + pcode + ", name=" + name + ", addr=" + addr + ", email=" + email
				+ ", remainStockYn=" + remainStockYn + ", emptyStockYn=" + emptyStockYn + ", toString()="
				+ super.toString() + "]";
	}

}
