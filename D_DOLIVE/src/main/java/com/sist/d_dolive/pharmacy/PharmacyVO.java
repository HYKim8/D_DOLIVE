package com.sist.d_dolive.pharmacy;

import com.sist.d_dolive.cmn.DTO;

public class PharmacyVO extends DTO {
	
	public PharmacyVO() {}
	
	private	String	pcode	;
	private	String	name	;
	private	String	addr	;
	private	String	lat		;
	private	String	lng		;
	private	String	type	;
	private	String	remainStat	;
	private	String	regId	;
	private	String	regDt	;
	private	String	modId	;
	private	String	modDt	;
	public PharmacyVO(String pcode, String name, String addr, String lat, String lng, String type, String remainStat,
			String regId, String regDt, String modId, String modDt) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.addr = addr;
		this.lat = lat;
		this.lng = lng;
		this.type = type;
		this.remainStat = remainStat;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
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
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemainStat() {
		return remainStat;
	}
	public void setRemainStat(String remainStat) {
		this.remainStat = remainStat;
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
		return "PharmacyVO [pcode=" + pcode + ", name=" + name + ", addr=" + addr + ", lat=" + lat + ", lng=" + lng
				+ ", type=" + type + ", remainStat=" + remainStat + ", regId=" + regId + ", regDt=" + regDt + ", modId="
				+ modId + ", modDt=" + modDt + ", toString()=" + super.toString() + "]";
	}

		
	
	
}
