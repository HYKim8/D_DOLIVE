/**
 * 
 */
package com.sist.d_dolive.member.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import com.sist.d_dolive.member.MemberDao;
import com.sist.d_dolive.member.MemberVO;
import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.member.MemberDao;

/**
 * @author sist
 *
 */
@Repository
public class MemberDaoImple implements MemberDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	@Qualifier("mailSender")
	private MailSender mailSender;
	
	private final String NAMESPACE= "com.sist.d_dolive.member";

	public MemberDaoImple() {}
	
	public int passCheck(DTO dto) {
		int cnt = 0;
		MemberVO inVO = (MemberVO) dto;

		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");

		// namespace+id = com.sist.ehr.user.doUpdate
		String statement = NAMESPACE+".passCheck";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");

		cnt = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=cnt="+cnt);
		LOG.debug("3==============================");

		LOG.debug("=cnt= "+cnt);
		return cnt;
	}
	
	
	public int idCheck(DTO dto) {
		int cnt = 0;
		MemberVO inVO = (MemberVO) dto;

		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");

		// namespace+id = com.sist.ehr.user.doUpdate
		String statement = NAMESPACE+".idCheck";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");

		cnt = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=cnt="+cnt);
		LOG.debug("3==============================");

		LOG.debug("=cnt= "+cnt);
		return cnt;
	}
	
	
	
	
	
	@Override
	public int doInsert(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==========================");
		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==========================");
		
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}
	
	public DTO doSelectOne1(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doSelectOne1";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
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
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==========================");
		
		return flag;
	}

	@Override
	public int idCount(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".idCount";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		int outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}

	@Override
	public DTO doFindId(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doFindId";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}

	@Override
	public DTO doFindPw(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".doFindPw";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}

	@Override
	public DTO getMember(DTO dto) {
		MemberVO inVO = (MemberVO) dto;
		LOG.debug("1==========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==========================");
		
		// namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE + ".getMember";
		LOG.debug("2==========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==========================");
		
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==========================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==========================");
		
		return outVO;
	}
	
	
	@Override
	public void sendEmail(DTO dto) {
		/*
		 * POP 서버명 : pop.naver.com SMTP 서버명 : smtp.naver.com POP 포트 : 995, 보안연결(SSL) 필요
		 * SMTP 포트 : 465, 보안 연결(SSL) 필요 아이디 : jamesol 비밀번호 : 네이버 로그인 비밀번호
		 */

		// ------------------------------------------
		// 받는사람
		// 제목
		// 내용
		// ------------------------------------------
		// 받는사람
		String recipient = ((MemberVO) dto).getEmail();
		// 제목
		String title = "비밀번호찾기";
		// 내용
		String contents = "비밀번호:"+((MemberVO) dto).getPw() ;

		// ------------------------------------------
		// Message에,받는사람,제목,내용,인증
		// 전송:Java
		// ------------------------------------------

		SimpleMailMessage mimeMessage = new SimpleMailMessage();

		// 보내는 사람
		mimeMessage.setFrom("bealright6@naver.com");

		// 받는사람
		mimeMessage.setTo(recipient);
		// 제목
		mimeMessage.setSubject(title);
		// 내용
		mimeMessage.setText(contents);

		// 전송
		mailSender.send(mimeMessage);

		LOG.debug("===================");
		LOG.debug("=mail send to=" + recipient);
		LOG.debug("===================");
	}

	
	
	



}
