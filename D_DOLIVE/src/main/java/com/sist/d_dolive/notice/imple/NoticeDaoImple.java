/**
 * 
 */
package com.sist.d_dolive.notice.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.notice.NoticeDao;
import com.sist.d_dolive.notice.NoticeVO;

/**
 * @author sist
 *
 */
@Repository
public class NoticeDaoImple implements NoticeDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE= "com.sist.d_dolive.notice";

	@Override
	public int doInsert(DTO dto) {
		NoticeVO inVO = (NoticeVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==========================");
		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		NoticeVO inVO = (NoticeVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		NoticeVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}
	
	public void doDeleteAll() {
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doDeleteAll";
		LOG.debug("1==========================");
		LOG.debug("1=statement="+statement);
		LOG.debug("1==========================");
		
		int flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("2==========================");
		LOG.debug("2=flag="+flag);
		LOG.debug("2==========================");
	}

	@Override
	public int doDelete(DTO dto) {
		NoticeVO inVO = (NoticeVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==========================");
		
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doRetrieve";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		List<NoticeVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outList="+outList);
		LOG.debug("3==========================");
		
		return outList;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
