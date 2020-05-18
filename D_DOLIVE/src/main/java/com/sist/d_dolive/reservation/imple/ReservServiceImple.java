package com.sist.d_dolive.reservation.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.reservation.ReservService;
import com.sist.d_dolive.reservation.ReservVO;

@Service
public class ReservServiceImple implements ReservService {

	@Autowired
	ReservDaoImple dao;
	
	@Override
	public int doInsert(DTO dto) {
		
		return dao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		
		return dao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		
		ReservVO outVO = (ReservVO) dao.doSelectOne(dto); 
		
		return outVO;
	}
	
	@Override
	public int doDelete(DTO dto) {
		
		return dao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		
		return dao.doRetrieve(dto);
	}

	@Override
	public List<?> getAll(DTO dto) {
		
		return dao.getAll(dto);
	}

}
