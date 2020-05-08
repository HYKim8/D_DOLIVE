package com.sist.d_dolive.member;

import java.util.List;

import com.sist.d_dolive.cmn.DTO;

public interface UserDao {


	public int doInsert(DTO dto);
	
	public int doUpdate(DTO dto);

	public int idCount(DTO dto);
	
	public DTO doFindId(DTO dto);
	
	public DTO doFindPw(DTO dto);
	
	public int doDelete(DTO dto);
	
	public DTO getMember(DTO dto);

	public DTO doSelectOne(DTO dto);

	
	

	
	
}