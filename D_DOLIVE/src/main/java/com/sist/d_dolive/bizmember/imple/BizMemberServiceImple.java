/**
 * 
 */
package com.sist.d_dolive.bizmember.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.d_dolive.bizmember.BizMemberDao;
import com.sist.d_dolive.bizmember.BizMemberService;
import com.sist.d_dolive.bizmember.BizMemberVO;
import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
@Service
public class BizMemberServiceImple implements BizMemberService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BizMemberDao bizMemberDao;

	@Override
	public int doInsert(DTO dto) {
		return bizMemberDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return bizMemberDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		BizMemberVO outVO = (BizMemberVO) bizMemberDao.doSelectOne(dto);
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		return bizMemberDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return bizMemberDao.doRetrieve(dto);
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
