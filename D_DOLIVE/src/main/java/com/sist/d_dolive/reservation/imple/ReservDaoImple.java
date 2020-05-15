package com.sist.d_dolive.reservation.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.reservation.ReservDao;
import com.sist.d_dolive.reservation.ReservVO;



@Repository("reservDao")
public class ReservDaoImple implements ReservDao {

	//Logger
	private final Logger LOG = LoggerFactory.getLogger(ReservDaoImple.class);
	
	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//rowMapper
	RowMapper<ReservVO> rowMapperSelectOne = new RowMapper<ReservVO>() {
		
		public ReservVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReservVO outData = new ReservVO();
			
			outData.setrNo(rs.getString("rno"));
			outData.setApproval(rs.getString("approval"));
			outData.setAmount(rs.getInt("amount"));
			outData.setEmail(rs.getString("email"));
			outData.setName(rs.getString("name"));
			outData.setTel(rs.getString("tel"));
			outData.setAddr(rs.getString("addr"));
			outData.setZipno(rs.getString("zipno"));
			
			
			return outData;
		}
			
	};
	
	RowMapper<ReservVO> rowMapperGetAll = new RowMapper<ReservVO>() {
		
		public ReservVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReservVO outData = new ReservVO();
			
			outData.setMaskCnt(rs.getInt("maskcnt"));
			outData.setApproval(rs.getString("approval"));
			outData.setAmount(rs.getInt("amount"));
			outData.setRegDt(rs.getString("regdt"));
			outData.setName(rs.getString("name"));
			
			return outData;
		}
			
	};
	
	//생성자
	public ReservDaoImple() {}
	
	@Override
	public int doInsert(DTO dto) {
		
		int flag = 0;
		ReservVO inVO = (ReservVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO reservation (								 \n");
		sb.append("     rno,                                                 \n");
		sb.append("     pcode,                                               \n");
		sb.append("     maskcnt,                                             \n");
		sb.append("     approval,                                            \n");
		sb.append("     amount,                                              \n");
		sb.append("     regid,                                               \n");
		sb.append("     regdt,                                               \n");
		sb.append("     modid,                                               \n");
		sb.append("     moddt                                                \n");
		sb.append(" ) VALUES (                                               \n");
		sb.append("     TO_CHAR(SYSDATE,'YYMMDD')||'_'||RESERV_SEQ.NEXTVAL,  \n");
		sb.append("     ?,                                                   \n");
		sb.append("     ?,                                                   \n");
		sb.append("     ?,                                                   \n");
		sb.append("     ?,                                                   \n");
		sb.append("     ?,                                                   \n");
		sb.append("     SYSDATE,                                             \n");
		sb.append("     ?,                                                   \n");
		sb.append("     SYSDATE                                              \n");
		sb.append(" )                                                        \n");
		
		LOG.debug("================================");
		
		LOG.debug("=!!query!!=\n"+sb.toString());
		LOG.debug("=!!param!!=\n"+inVO.toString());
		Object[] args = {inVO.getpCode()
						,inVO.getMaskCnt()
						,inVO.getApproval()
						,inVO.getAmount()
						,inVO.getRegId()
						,inVO.getModId()
						};
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=!!flag!!="+flag);
		
		LOG.debug("================================");
		
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
		
		int flag = 0;
		ReservVO inVO = (ReservVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE reservation	 \n");
		sb.append(" SET approval = ?     \n");
		sb.append(" WHERE rno = ?        \n");
		
		LOG.debug("================================");
		
		LOG.debug("=!!query!!=\n"+sb.toString());
		LOG.debug("=!!param!!=\n"+inVO.toString());
		Object[] args = {inVO.getApproval()
						,inVO.getrNo()
						};
		
		flag = this.jdbcTemplate.update(sb.toString(),args);
		LOG.debug("=!!flag!!="+flag);
		
		LOG.debug("================================");
		
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		//1. 결제
		//2. 취소 요청
		
		ReservVO outVO = null;//return ReservVO
		ReservVO inVO = (ReservVO) dto;//Param ReservVO
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT							 \n");
		sb.append("     t1.rno,                      \n");
		sb.append("     t1.approval,                 \n");
		sb.append("     t1.amount,                   \n");
		sb.append("     t2.email,                    \n");
		sb.append("     t2.name,                     \n");
		sb.append("     t2.tel,                      \n");
		sb.append("     t2.addr,                     \n");
		sb.append("     t2.zipno                     \n");
		sb.append(" FROM reservation t1, member t2   \n");
		sb.append(" WHERE t1.rno = ?                 \n");
		sb.append(" AND t1.regid = t2.email          \n");
		
		//query 수행
		LOG.debug("==============================");
		
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.getrNo());
		
		Object[] args = {inVO.getrNo()};
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapperSelectOne);
		LOG.debug("=outVO=\n"+outVO);
		
		LOG.debug("==============================");
			
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		//신청취소용 : 승인상태가 2(신청취소)로 변경
		
		int flag = 0;

		
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(DTO dto) {
		//전체 조회
		
		ReservVO inVO = (ReservVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT												 \n");
		sb.append("     t2.name,                                         \n");
		sb.append("     t1.approval,                                     \n");
		sb.append("     t1.maskcnt,                                      \n");
		sb.append("     t1.amount,        \n");
		sb.append("     TO_CHAR(t1.regdt, 'YYYY-MM-DD HH:MM:SS') regdt   \n");
		sb.append(" FROM reservation t1, pharmacy t2                     \n");
		sb.append(" WHERE t1.regid = ?	                                 \n");
		sb.append(" AND t1.pcode = t2.pcode	                             \n");
		sb.append(" ORDER BY regdt DESC	                            	 \n");
		
		LOG.debug("==============================");
		
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param="+inVO.getRegId());
		
		List<ReservVO> list = this.jdbcTemplate.query(sb.toString(), new Object[] {inVO.getRegId()}, rowMapperGetAll);
		LOG.debug("=list="+list);
		
		LOG.debug("==============================");
		
		return list;
	}

}
