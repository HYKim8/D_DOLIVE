/**
 * 
 */
package com.sist.d_dolive.member.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.member.UserDao;
import com.sist.d_dolive.member.UserVO;

/**
 * @author sist
 *
 */
@Repository("userDao")
public class UserDaoImple implements UserDao {
	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	  
	
	RowMapper<UserVO> rowMapper = new RowMapper<UserVO>() {

		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO outData=new UserVO();
			outData.setEmail(rs.getString("email"));
			outData.setPw(rs.getString("pw"));
			outData.setGender(rs.getString("gender"));
			outData.setName(rs.getString("name"));
			outData.setIhidnum(rs.getString("ihidnum"));
			outData.setAddr(rs.getString("addr"));
			outData.setAddr2(rs.getString("addr2"));
			outData.setZipno(rs.getString("zipno"));
			outData.setTel(rs.getString("tel"));
			
			return outData;
		}

	};
	

	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImple() {}
	


	public int doInsert(DTO dto) {// 회원가입
		int flag = 0;
		UserVO inVO = (UserVO) dto;
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" INSERT INTO member ( \n");
		sb.append("     email,           \n");
		sb.append("     pw,              \n");
		sb.append("     gender,          \n");
		sb.append("     ihidnum,         \n");
		sb.append("     name,            \n");
		sb.append("     tel,             \n");
		sb.append("     zipno,           \n");
		sb.append("     addr,            \n");
		sb.append("     addr2,           \n");
		sb.append("     regid,           \n");
		sb.append("     regdt,           \n");
		sb.append("     modid,           \n");
		sb.append("     moddt            \n");
		sb.append(" ) VALUES (           \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     sysdate,         \n");
		sb.append("     ?,               \n");
		sb.append("     sysdate          \n");
		sb.append(" )                    \n");
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.toString());
		Object[] args= {inVO.getEmail()
				       ,inVO.getPw()
				       ,inVO.getGender()
				       ,inVO.getIhidnum()
				       ,inVO.getName()
				       ,inVO.getTel()
				       ,inVO.getZipno()
				       ,inVO.getAddr()
				       ,inVO.getAddr2()
				       ,inVO.getRegid()
				       ,inVO.getModid()
				       
		};
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		
		LOG.debug("==============================");
		
		return flag;
	}

	public int doPwUpdate(DTO dto) { //비밀번호 수정
		int flag = 0;
		UserVO inVO = (UserVO) dto;
		StringBuilder sb=new StringBuilder();
		sb.append(" UPDATE member \n");
		sb.append(" SET pw=?      \n");
		sb.append(" WHERE email=? \n");
		
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		Object[] args= {inVO.getPw()
				      ,inVO.getEmail()
				      };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag= "+flag);
		LOG.debug("==============================");
		return flag;
	}
	
	
	public int doTelUpdate(DTO dto) { //전화번호수정
		int flag = 0;
		UserVO inVO = (UserVO) dto;
		StringBuilder sb=new StringBuilder();
		sb.append(" UPDATE member \n");
		sb.append(" SET pw=?      \n");
		sb.append(" WHERE email=? \n");
		
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		Object[] args= {inVO.getPw()
				      ,inVO.getEmail()
				      };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag= "+flag);
		LOG.debug("==============================");
		return flag;
	}
	
	
	public int doAddrUpdate(DTO dto) { //주소 수정
		int flag = 0;
		UserVO inVO = (UserVO) dto;
		StringBuilder sb=new StringBuilder();
		sb.append(" UPDATE member   \n");
		sb.append(" SET zipno=?,    \n");
		sb.append("     addr=?,     \n");
		sb.append("     addr2=?     \n");
		sb.append(" WHERE email=?   \n");
		
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		Object[] args= {inVO.getZipno()
				      ,inVO.getAddr()
				      ,inVO.getAddr2()
				      ,inVO.getEmail()
				      };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag= "+flag);
		LOG.debug("==============================");
		return flag;
	}
	
	
	
	
	public int idCount(DTO dto) { //아이디 중복체크
		int cnt = 0;
		UserVO inVO = (UserVO) dto;
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT COUNT(*) \n");
		sb.append(" FROM member     \n");
		sb.append(" WHERE email= ?  \n");
		
		
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		cnt = this.jdbcTemplate.queryForObject(sb.toString()
				, new Object[] {"%"+inVO.getEmail()+"%"}
		        , Integer.class);
		
		LOG.debug("=cnt= "+cnt);
		return cnt;
	}
	

	public DTO doFindId(DTO dto) {//아이디찾기 단건조회
		UserVO outVO = null;        //return UserVO
		UserVO inVO  = (UserVO) dto;//Param UserVO
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT email  \n");
		sb.append(" FROM member   \n");
		sb.append(" WHERE name=?  \n");
		sb.append(" AND IHIDNUM=? \n");
		
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.getEmail());
		
		Object []args = {inVO.getName(), inVO.getIhidnum() };
		outVO = this.jdbcTemplate.queryForObject(sb.toString()
				,args
				,rowMapper); 
		LOG.debug("=outVO=\n"+outVO);
		LOG.debug("==============================");
		
		return outVO;
	}
	
	
	public DTO doFindPw(DTO dto) {//비밀번호찾기 단건조회
		UserVO outVO = null;        //return UserVO
		UserVO inVO  = (UserVO) dto;//Param UserVO
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT pw		\n");
		sb.append(" FROM member     \n");
		sb.append(" WHERE email =?  \n");
		sb.append(" AND name =?     \n");
		sb.append(" AND IHIDNUM=?   \n");
		
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.getEmail());
		
		Object []args = {inVO.getEmail(), inVO.getName(), inVO.getIhidnum() };
		outVO = this.jdbcTemplate.queryForObject(sb.toString()
				,args
				,rowMapper); 
		LOG.debug("=outVO=\n"+outVO);
		LOG.debug("==============================");
		
		return outVO;
	}
	

	public int doDelete(DTO dto) {
		int flag = 0;
		UserVO inVO = (UserVO) dto;
		StringBuilder  sb=new StringBuilder();
		sb.append(" DELETE FROM member \n");
		sb.append(" WHERE email = ?    \n");
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param="+inVO);
		
		Object[] args = {inVO.getEmail()};
		flag = jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("=flag="+flag);		
		LOG.debug("==============================");	
		return flag;
	}

	/**
	 * 
	 *Method Name:getAll
	 *작성일: 2020. 4. 8.
	 *작성자: sist
	 *설명: 전체 조회
	 *@param dto
	 *@return
	 */
	@Override
	public List<UserVO> doRetrieve(DTO dto) { //마이페이지 회원정보출력
		UserVO inVO = (UserVO) dto;
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT email,						\n");
		sb.append("        gender,                      \n");
		sb.append("        SUBSTR(IHIDNUM,1,6),         \n");
		sb.append("        name,                        \n");
		sb.append("        tel,                         \n");
		sb.append("        addr,                        \n");
		sb.append("        addr2                        \n");
		sb.append(" FROM member                         \n");
		sb.append(" WHERE email=?                       \n");
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param="+inVO);
		//new Object[] {"%"+inVO.getU_id()+"%"}
		List<UserVO> list = this.jdbcTemplate.query(sb.toString()
				               , new Object[] {"%"+inVO.getEmail()+"%"}
				               , rowMapper);
		LOG.debug("=list="+list);
		LOG.debug("==============================");
		return list;
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
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}



	
//	public List<?> doRetrieve(DTO dto) {
//		SearchVO  inVO= (SearchVO) dto;
//		//검색구분
//		  //ID : 10
//		  //이름: 20
//		//검색어
//		StringBuilder whereSb=new StringBuilder();
//		
//		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
//			if(inVO.getSearchDiv().equals("10")) {
//				whereSb.append("WHERE u_id like '%' || ? ||'%'   \n");
//			}else if(inVO.getSearchDiv().equals("20")) {
//				whereSb.append("WHERE name like '%' || ? ||'%'   \n");
//			}
//		}
//		
//		
//		StringBuilder sb=new StringBuilder();
//		sb.append("SELECT T1.*,T2.*                                              \n");
//		sb.append("FROM(                                                         \n");
//		sb.append("    SELECT  B.u_id,                                           \n");
//		sb.append("            B.name,                                           \n");
//		sb.append("            B.passwd,                                         \n");
//		sb.append("            B.u_level,                                        \n");
//		sb.append("            B.login,                                          \n");
//		sb.append("            B.recommend,                                      \n");
//		sb.append("            B.mail,                                           \n");
//		sb.append("            TO_CHAR(B.reg_dt,'YYYY/MM/DD') reg_dt,            \n");
//		sb.append("            rnum                                              \n");		
//		sb.append("    FROM(                                                     \n");
//		sb.append("        SELECT ROWNUM rnum,                                   \n");
//		sb.append("               A.*                                            \n");
//		sb.append("        FROM (                                                \n");
//		sb.append("            SELECT *                                          \n");
//		sb.append("            FROM hr_member                                    \n");
//		sb.append("            --검색조건                                                                               \n");
//		//--검색----------------------------------------------------------------------
//		sb.append(whereSb.toString());
//		//--검색----------------------------------------------------------------------				
//		sb.append("        )A --10                                               \n");
//		//sb.append("        WHERE ROWNUM <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE) \n");
//		sb.append("        WHERE ROWNUM <= (?*(?-1)+?) \n");
//		sb.append("    )B --1                                                    \n");
//		//sb.append("    WHERE B.RNUM >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)              \n");
//		sb.append("    WHERE B.RNUM >= (?*(?-1)+1)              \n");
//		sb.append("    )T1 CROSS JOIN                                            \n");
//		sb.append("    (                                                         \n");
//		sb.append("    SELECT count(*) total_cnt                                 \n");
//		sb.append("    FROM hr_member                                            \n");
//		sb.append("    --검색조건                                                   \n");
//		//--검색----------------------------------------------------------------------
//		sb.append(whereSb.toString());
//		//--검색----------------------------------------------------------------------
//		sb.append("    )T2                                                       \n");
//
//		//param 
//		List<Object> listArg = new ArrayList<Object>();
//		
//		
//		//param set
//		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
//			listArg.add(inVO.getSearchWord());
//			listArg.add(inVO.getPageSize());
//			listArg.add(inVO.getPageNum());
//			listArg.add(inVO.getPageSize());
//			listArg.add(inVO.getPageSize());
//			listArg.add(inVO.getPageNum());				
//			listArg.add(inVO.getSearchWord());
//			
//		}else {
//			listArg.add(inVO.getPageSize());
//			listArg.add(inVO.getPageNum());
//			listArg.add(inVO.getPageSize());
//			listArg.add(inVO.getPageSize());
//			listArg.add(inVO.getPageNum());			
//		}
//		List<UserVO> retList = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
//		LOG.debug("query \n"+sb.toString());
//		LOG.debug("param:"+listArg);
//		return retList;
//	}
//
}















