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

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.member.UserDao;
import com.sist.d_dolive.member.UserService;
import com.sist.d_dolive.member.UserVO;



/**
 * @author sist
 *
 */
@Service
public class UserServiceImple implements UserService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	/*
	 * case BASIC: return user.getLogin()>=50; case SILVER:return
	 * user.getRecommend()>=30;
	 */

	public static final int MIN_LOGINCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMENDCOUNT_FOR_GOLD = 30;

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("dummyMailSender")
	private MailSender mailSender;


	public UserServiceImple() {

	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int doInsert(DTO dto) {
		return userDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return userDao.doUpdate(dto);
	}

	@Override
	public int idCount(DTO dto) {
		return userDao.idCount(dto);
	}
	
	@Override
	public DTO doFindId(DTO dto) {
		return userDao.doFindId(dto);
	}
	
	@Override
	public DTO doFindPw(DTO dto) {
		return userDao.doFindPw(dto);
	}
	
	@Override
	public int doDelete(DTO dto) {
		return userDao.doDelete(dto);
	}
	
	public DTO getMember(DTO dto) {
		return userDao.getMember(dto);
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		return userDao.doSelectOne(dto);
	}

}









