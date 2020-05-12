/**
 * 
 */
package com.sist.d_dolive.code.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.code.CodeDao;
import com.sist.d_dolive.code.CodeService;

/**
 * @author sist
 *
 */
@Service
public class CodeServiceImple implements CodeService {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CodeDao codeDao;

	@Override
	public List<?> doRetrieve(DTO dto) {
		return codeDao.doRetrieve(dto);
	}

}
