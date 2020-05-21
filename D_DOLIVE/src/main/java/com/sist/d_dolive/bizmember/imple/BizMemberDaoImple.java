/**
 * 
 */
package com.sist.d_dolive.bizmember.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.bizmember.BizMemberDao;
import com.sist.d_dolive.bizmember.BizMemberVO;
import com.sist.d_dolive.cmn.DTO;

/**
 * @author sist
 *
 */
@Repository
public class BizMemberDaoImple implements BizMemberDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE= "com.sist.d_dolive.bizmember";

	@Override
	public int doInsert(DTO dto) {
		BizMemberVO inVO = (BizMemberVO) dto;
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
		BizMemberVO inVO = (BizMemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==========================");
		
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		BizMemberVO inVO = (BizMemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		BizMemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}
	
	@Override
	public int idCheck(DTO dto) {
		int cnt = 0;
		BizMemberVO inVO = (BizMemberVO) dto;

		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");

		// namespace+id = com.sist.ehr.user.doUpdate
		String statement = NAMESPACE+".idPwCheck";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");

		cnt = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=cnt="+cnt);
		LOG.debug("3==============================");

		LOG.debug("=cnt= "+cnt);
		return cnt;
	}

	@Override
	public int pwCheck(DTO dto) {
		int cnt = 0;
		BizMemberVO inVO = (BizMemberVO) dto;

		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");

		// namespace+id = com.sist.ehr.user.doUpdate
		String statement = NAMESPACE+".idPwCheck";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");

		cnt = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=cnt="+cnt);
		LOG.debug("3==============================");

		LOG.debug("=cnt= "+cnt);
		return cnt;
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
		BizMemberVO inVO = (BizMemberVO) dto;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
