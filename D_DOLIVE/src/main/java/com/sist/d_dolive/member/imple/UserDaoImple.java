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

	public int doUpdate(DTO dto) { //회원정보 수정
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
	
	
//	public int doTelUpdate(DTO dto) { //전화번호수정
//		int flag = 0;
//		UserVO inVO = (UserVO) dto;
//		StringBuilder sb=new StringBuilder();
//		sb.append(" UPDATE member \n");
//		sb.append(" SET pw=?      \n");
//		sb.append(" WHERE email=? \n");
//		
//		LOG.debug("==============================");
//		LOG.debug("=Query=\n"+sb.toString());
//		LOG.debug("=Param= "+inVO.toString());
//		Object[] args= {inVO.getPw()
//				      ,inVO.getEmail()
//				      };
//		flag = this.jdbcTemplate.update(sb.toString(), args);
//		LOG.debug("=flag= "+flag);
//		LOG.debug("==============================");
//		return flag;
//	}
//	
//	
//	public int doAddrUpdate(DTO dto) { //주소 수정
//		int flag = 0;
//		UserVO inVO = (UserVO) dto;
//		StringBuilder sb=new StringBuilder();
//		sb.append(" UPDATE member   \n");
//		sb.append(" SET zipno=?,    \n");
//		sb.append("     addr=?,     \n");
//		sb.append("     addr2=?     \n");
//		sb.append(" WHERE email=?   \n");
//		
//		LOG.debug("==============================");
//		LOG.debug("=Query=\n"+sb.toString());
//		LOG.debug("=Param= "+inVO.toString());
//		Object[] args= {inVO.getZipno()
//				      ,inVO.getAddr()
//				      ,inVO.getAddr2()
//				      ,inVO.getEmail()
//				      };
//		flag = this.jdbcTemplate.update(sb.toString(), args);
//		LOG.debug("=flag= "+flag);
//		LOG.debug("==============================");
//		return flag;
//	}
	
	
	
	
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
	

	public int doDelete(DTO dto) { //회원탈퇴
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
	
	public DTO getMember(DTO dto) {//로그인
		UserVO outVO = null;        //return UserVO
		UserVO inVO  = (UserVO) dto;//Param UserVO
		StringBuilder  sb = new StringBuilder();
		sb.append(" select * from member  \n");
		sb.append(" where email= ?        \n");
		sb.append(" and pw= ?             \n");
		
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.getEmail());
		
		Object []args = {inVO.getEmail(),
						 inVO.getPw()
						 };
		outVO = this.jdbcTemplate.queryForObject(sb.toString()
				,args
				,rowMapper); 
		LOG.debug("=outVO=\n"+outVO);
		LOG.debug("==============================");
		
		return outVO;
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
	public DTO doSelectOne(DTO dto) {//마이페이지 회원정보출력
		UserVO outVO = null;        //return UserVO
		UserVO inVO  = (UserVO) dto;//Param UserVO
		StringBuilder  sb = new StringBuilder();
		sb.append(" SELECT email,						\n");
		sb.append("        gender,                      \n");
		sb.append("        SUBSTR(IHIDNUM,1,6),         \n");
		sb.append("        name,                        \n");
		sb.append("        tel,                         \n");
		sb.append("        addr,                        \n");
		sb.append("        addr2                        \n");
		sb.append(" FROM member                         \n");
		sb.append(" WHERE email=?                       \n");
		
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.getEmail());
		
		Object []args = {inVO.getEmail(),
						 inVO.getPw()
						 };
		outVO = this.jdbcTemplate.queryForObject(sb.toString()
				,args
				,rowMapper); 
		LOG.debug("=outVO=\n"+outVO);
		LOG.debug("==============================");
		
		return outVO;
	}







}














