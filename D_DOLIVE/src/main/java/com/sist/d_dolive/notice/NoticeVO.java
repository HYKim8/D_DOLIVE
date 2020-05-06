package com.sist.d_dolive.notice;

import com.sist.d_dolive.cmn.DTO;

public class NoticeVO extends DTO {

	public NoticeVO() {}
	
	private String pcode;
	private String createdAt;
	private String remainStat;
	private String stockAt;
	private String name;
	private String email;
	private String remainStockYn;
	private String emptyStockYn;
	private String updateDiv;
	public NoticeVO(String pcode, String createdAt, String remainStat, String stockAt, String name, String email,
			String remainStockYn, String emptyStockYn, String updateDiv) {
		super();
		this.pcode = pcode;
		this.createdAt = createdAt;
		this.remainStat = remainStat;
		this.stockAt = stockAt;
		this.name = name;
		this.email = email;
		this.remainStockYn = remainStockYn;
		this.emptyStockYn = emptyStockYn;
		this.updateDiv = updateDiv;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getRemainStat() {
		return remainStat;
	}
	public void setRemainStat(String remainStat) {
		this.remainStat = remainStat;
	}
	public String getStockAt() {
		return stockAt;
	}
	public void setStockAt(String stockAt) {
		this.stockAt = stockAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUpdateDiv() {
		return updateDiv;
	}
	public void setUpdateDiv(String updateDiv) {
		this.updateDiv = updateDiv;
	}
	@Override
	public String toString() {
		return "NoticeVO [pcode=" + pcode + ", createdAt=" + createdAt + ", remainStat=" + remainStat + ", stockAt="
				+ stockAt + ", name=" + name + ", email=" + email + ", remainStockYn=" + remainStockYn
				+ ", emptyStockYn=" + emptyStockYn + ", updateDiv=" + updateDiv + ", toString()=" + super.toString()
				+ "]";
	}
		
	
}
