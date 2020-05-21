/**
 * 
 */
package com.sist.d_dolive.pharmacy.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.notice.NoticeVO;
import com.sist.d_dolive.pharmacy.PharmacyDao;

/**
 * @author sist
 *
 */
@Repository
public class PharmacyDaoImple implements PharmacyDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE= "com.sist.d_dolive.pharmacy";

	@Override
	public int doInsert(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int idCheck(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pwCheck(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
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

}
