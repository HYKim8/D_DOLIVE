/**
 * 
 */
package com.sist.d_dolive.bizmember;

import java.util.List;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public interface BizMemberService {
	/**
	 * 등록
	 * @param dto
	 * @return 
	 */
	public void sendEmail(DTO dto);
	
	/**
	 * 등록
	 * @param dto
	 * @return int
	 */
	public int doInsert(DTO dto);
	
	/**
	 * 수정   
	 * @param dto
	 * @return int
	 */
	public int doUpdate(DTO dto);
	
	/**
	 * 단건조회
	 * @param dto
	 * @return DTO
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * 아이디, 비밀번호 체크
	 * @param dto
	 * @return DTO
	 */
	public int idPwCheck(DTO dto);
	
	/**
	 * 삭제
	 * @param dto
	 * @return int
	 */
	public int doDelete(DTO dto);
	
	/**
	 * 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);
	
	/**
	 * 전체 조회
	 * @param dto
	 * @return
	 */
	public List<?> getAll(DTO dto);
}
