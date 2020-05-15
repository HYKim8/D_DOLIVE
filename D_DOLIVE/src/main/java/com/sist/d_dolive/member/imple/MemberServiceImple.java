/**
 * 
 */
package com.sist.d_dolive.member.imple;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.sist.d_dolive.member.MemberVO;
import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.member.MemberDao;
import com.sist.d_dolive.member.MemberService;
import com.sist.d_dolive.member.MemberVO;



/**
 * @author sist
 *
 */
@Service
public class MemberServiceImple implements MemberService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MemberDao memberDao;

	@Autowired
	@Qualifier("dummyMailSender")
	private MailSender mailSender;


	
	
	@Override
	public int doInsert(DTO dto) {
		return memberDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return memberDao.doUpdate(dto);
	}

	@Override
	public int idCount(DTO dto) {
		return memberDao.idCount(dto);
	}
	
	@Override
	public DTO doFindId(DTO dto) {
		MemberVO outVO =  (MemberVO)memberDao.doFindId(dto);
		return outVO;
	}
	
	@Override
	public DTO doFindPw(DTO dto) {
		MemberVO outVO =  (MemberVO)memberDao.doFindPw(dto);
		return outVO;
	}
	
	@Override
	public int doDelete(DTO dto) {
		return memberDao.doDelete(dto);
	}
	
	public DTO getMember(DTO dto) {
		MemberVO outVO =  (MemberVO)memberDao.getMember(dto);
		return outVO;
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		MemberVO outVO =  (MemberVO)memberDao.doSelectOne(dto);
		return outVO;
	}
	public DTO doSelectOne1(DTO dto) {
		MemberVO outVO =  (MemberVO)memberDao.doSelectOne1(dto);
		return outVO;
	}
	public void sendEmail(DTO dto) {
		memberDao.sendEmail(dto);
	}
	
	
	
	
	
	

}









