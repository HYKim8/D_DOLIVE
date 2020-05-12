/**
 * 
 */
package com.sist.d_dolive.code;

import java.util.List;

import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
public interface CodeDao {
	/**
	 * 목록조회
	 * @param dto
	 * @return
	 */
	public List<?> doRetrieve(DTO dto);
}
