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
	RowMapper<ReservVO> rowMapper = new RowMapper<ReservVO>() {
		
		public ReservVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReservVO outData = new ReservVO();
			
			outData.setrNo(rs.getString("rno"));
			outData.setpCode(rs.getString("pcode"));
			outData.setMaskCnt(rs.getInt("mask_cnt"));
			outData.setApproval(rs.getString("approval"));
			outData.setPay(rs.getInt("pay"));
			outData.setRegId(rs.getString("reg_id"));
			outData.setRegDt(rs.getString("reg_dt"));
			outData.setModId(rs.getString("mod_id"));
			outData.setModDt(rs.getString("mod_dt"));
			
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
		sb.append("INSERT INTO reservation (								\n");
		sb.append("    rno,                                                 \n");
		sb.append("    pcode,                                               \n");
		sb.append("    mask_cnt,                                            \n");
		sb.append("    approval,                                            \n");
		sb.append("    pay,                                                 \n");
		sb.append("    reg_id,                                              \n");
		sb.append("    reg_dt,                                              \n");
		sb.append("    mod_id,                                              \n");
		sb.append("    mod_dt                                               \n");
		sb.append(") VALUES (                                               \n");
		sb.append("    TO_CHAR(SYSDATE,'YYMMDD')||'_'||RESERV_SEQ.NEXTVAL,  \n");
		sb.append("    ?,                                                   \n");
		sb.append("    ?,                                                   \n");
		sb.append("    ?,                                                   \n");
		sb.append("    ?,                                                   \n");
		sb.append("    ?,                                                   \n");
		sb.append("    SYSDATE,                                             \n");
		sb.append("    ?,                                                   \n");
		sb.append("    SYSDATE                                              \n");
		sb.append(")                                                        \n");
		
		LOG.debug("================================");
		
		LOG.debug("=!!query!!=\n"+sb.toString());
		LOG.debug("=!!param!!=\n"+inVO.toString());
		Object[] args = {inVO.getrNo()
						,inVO.getpCode()
						,inVO.getMaskCnt()
						,inVO.getApproval()
						,inVO.getPay()
						,inVO.getRegId()
						,inVO.getRegDt()
						,inVO.getModId()
						,inVO.getModDt()
						};
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=!!flag!!="+flag);
		LOG.debug("================================");
		
		return flag;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
