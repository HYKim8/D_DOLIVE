/**
 * 
 */
package com.sist.d_dolive.member.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.member.MemberDao;
import com.sist.d_dolive.member.MemberVO;
import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.member.MemberDao;

/**
 * @author sist
 *
 */
@Repository
public class MemberDaoImple implements MemberDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE= "com.sist.d_dolive.member";

	@Override
	public int doInsert(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
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
		MemberVO inVO = (MemberVO) dto;
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
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
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
		MemberVO inVO = (MemberVO) dto;
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
	public int idCount(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doFindId(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTO doFindPw(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTO getMember(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}



}
