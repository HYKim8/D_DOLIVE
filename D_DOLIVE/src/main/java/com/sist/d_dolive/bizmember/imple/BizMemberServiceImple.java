/**
 * 
 */
package com.sist.d_dolive.bizmember.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
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
	
	@Autowired
	@Qualifier("dummyMailSender")
	private MailSender mailSender;
	
	@Override
	public void sendEmail(DTO dto) {
		LOG.debug("=service30=");
		bizMemberDao.sendEmail(dto);
	}

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
	public int idPwCheck(DTO dto) {
		int idFlag = 0;
		int pwFlag = 0;
		int result = 0;
		
		//1. idCheck   실패: 10
		dto.setSearchDiv("10");
		idFlag = bizMemberDao.idCheck(dto);
		if(idFlag!=1) {
			result = 10;//id not found
		}
	
		//2. pwCheck 실패: 20
		if(idFlag==1) {
			dto.setSearchDiv("40");
			pwFlag = bizMemberDao.pwCheck(dto);
			if(pwFlag!=1) {
				result = 20;//pw not found
			}else {
				//3. 성공: 30
				result = 30;
			}
		}
	
		return result;
	}

	@Override
	public int doDelete(DTO dto) {
		return bizMemberDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
