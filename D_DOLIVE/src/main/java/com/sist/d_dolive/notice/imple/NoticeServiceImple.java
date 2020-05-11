/**
 * 
 */
package com.sist.d_dolive.notice.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.notice.NoticeDao;
import com.sist.d_dolive.notice.NoticeService;
import com.sist.d_dolive.notice.NoticeVO;

/**
 * @author sist
 *
 */
@Service
public class NoticeServiceImple implements NoticeService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NoticeDao noticeDao;

	@Override
	public int doInsert(DTO dto) {
		return noticeDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		NoticeVO outVO = (NoticeVO) noticeDao.doSelectOne(dto);
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		return noticeDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return noticeDao.doRetrieve(dto);
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
