/**
 * 
 */
package com.sist.d_dolive.pharmacy.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.pharmacy.PharmacyDao;
import com.sist.d_dolive.pharmacy.PharmacyService;

/**
 * @author sist
 *
 */
@Service
public class PharmacyServiceImple implements PharmacyService {
	@Autowired
	PharmacyDao pharmacyDao;

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
	public int doDelete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return pharmacyDao.doRetrieve(dto);
	}

}
