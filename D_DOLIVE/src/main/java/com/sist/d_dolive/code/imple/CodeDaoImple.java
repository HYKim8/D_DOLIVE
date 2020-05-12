/**
 * 
 */
package com.sist.d_dolive.code.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.code.CodeDao;
import com.sist.d_dolive.code.CodeVO;

/**
 * @author sist
 *
 */
@Repository
public class CodeDaoImple implements CodeDao {
Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private final String NAME_SPACE = "com.sist.d_dolive.code";

	@Override
	public List<?> doRetrieve(DTO dto) {
		//1. PARAM
		CodeVO inVO = (CodeVO) dto;
		LOG.debug("1================");
		LOG.debug("1=param="+inVO);
		LOG.debug("1================");
		
		//1.1. statement
		String statement = NAME_SPACE + ".doRetrieve";
		LOG.debug("1.1================");
		LOG.debug("1.1=statement="+statement);
		LOG.debug("1.1================");
		
		//2. sqlSessionTemplate
		List<CodeVO> list = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("2================");
		LOG.debug("2=list="+list);
		LOG.debug("2================");
		
		//3. RETURN
		return list;
	}

}
