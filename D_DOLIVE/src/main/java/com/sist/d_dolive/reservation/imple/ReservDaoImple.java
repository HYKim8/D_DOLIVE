package com.sist.d_dolive.reservation.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.reservation.ReservDao;
import com.sist.d_dolive.reservation.ReservVO;

@Repository
public class ReservDaoImple implements ReservDao {

	//Logger
	
	private final Logger LOG = LoggerFactory.getLogger(ReservDaoImple.class);
	
	//SqlSessionTemplate
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	//NAMESPACE 지정
	private final String NAMESPACE = "com.sist.d_dolive.reservation";
	
	//생성자
	public ReservDaoImple() {}
	
	@Override
	public int doInsert(DTO dto) {
		
		//1. param get
		ReservVO inVO = (ReservVO) dto;
		LOG.debug("dao 1.==========================");
		LOG.debug("dao 1.=inVO="+inVO);
		LOG.debug("dao 1.==========================");
		
		//2. statement 설정 -> NAMESPACE + "." + id = com.sist.d_dolive.reservation.doInsert
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("dao 2.==========================");
		LOG.debug("dao 2.=statement="+statement);
		LOG.debug("dao 2.==========================");
		
		//3. SqlSessionTemplate 처리
		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("dao 3.==========================");
		LOG.debug("dao 3.=flag="+flag);
		LOG.debug("dao 3.==========================");
		
		return flag;

	}

	@Override
	public int doUpdate(DTO dto) {
		//화면에서 받아오는 파라미터에 따라 승인상태값을 변경해주기!
		//1. 예약신청(회원)
		//2. 취소완료(회원)
		//3. 승인완료(업체)
		//4. 승인거절(업체)
		//5. 결제완료(회원)
		//6. 상품배정(업체)
		//7. 구매확정(업체)
		
		//1. param get
		ReservVO inVO = (ReservVO) dto;
		LOG.debug("dao 1.==========================");
		LOG.debug("dao 1.=inVO="+inVO);
		LOG.debug("dao 1.==========================");
		
		//2. statement 설정 -> NAMESPACE + "." + id = com.sist.d_dolive.reservation.doUpdate
		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("dao 2.==========================");
		LOG.debug("dao 2.=statement="+statement);
		LOG.debug("dao 2.==========================");
		
		//3. SqlSessionTemplate 처리
		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("dao 3.==========================");
		LOG.debug("dao 3.=flag="+flag);
		LOG.debug("dao 3.==========================");

		
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		//1. 결제
		//2. 취소 요청
		
		//1. param get
		ReservVO inVO = (ReservVO) dto;
		LOG.debug("dao 1.==========================");
		LOG.debug("dao 1.=inVO="+inVO);
		LOG.debug("dao 1.==========================");
		
		//2. statement 설정 -> NAMESPACE + "." + id = com.sist.d_dolive.reservation.doSelectOne
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("dao 2.==========================");
		LOG.debug("dao 2.=statement="+statement);
		LOG.debug("dao 2.==========================");
		
		//3. SqlSessionTemplate 처리
		ReservVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("dao 3.==========================");
		LOG.debug("dao 3.=flag="+outVO);
		LOG.debug("dao 3.==========================");

			
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
		//신청취소용 : 승인상태가 2(신청취소)로 변경
		
		int flag = 0;

		
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.d_dolive.reservation.doInsert
		String statement = NAMESPACE + ".doRetrieve";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		List<ReservVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outList="+outList);
		LOG.debug("3==========================");
		
		return outList;
	}

	@Override
	public List<?> getAll(DTO dto) {
		//전체 조회
		
		return null;
	}

}
