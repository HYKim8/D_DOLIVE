/**
 * 
 */
package com.sist.d_dolive.pharmacy;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public class PharmacyVO extends DTO {
	private String	pcode	;	/*	판매처코드	*/
	private String	name	;	/*	약국명	*/
	private String	addr	;	/*	주소		*/
	private String	lat		;	/*	위도		*/
	private String	lng		;	/*	경도		*/
	private String	type	;	/*	판매처유형	*/
	
	PharmacyVO() {}

	public PharmacyVO(String pcode, String name, String addr, String lat, String lng, String type) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.addr = addr;
		this.lat = lat;
		this.lng = lng;
		this.type = type;
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

	@Override
	public String toString() {
		return "PharmacyVO [pcode=" + pcode + ", name=" + name + ", addr=" + addr + ", lat=" + lat + ", lng=" + lng
				+ ", type=" + type + ", toString()=" + super.toString() + "]";
	}
	
}
