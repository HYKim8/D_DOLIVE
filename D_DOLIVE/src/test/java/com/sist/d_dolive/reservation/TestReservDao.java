package com.sist.d_dolive.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.reservation.imple.ReservDaoImple;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
									})
public class TestReservDao {

	private final Logger LOG = LoggerFactory.getLogger(TestReservDao.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ReservDaoImple dao;
	
	ReservVO reserv01;
	ReservVO reserv02;
	ReservVO reserv03;
	
	ReservVO reserv04;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("~~~~~~~~~~~~~~~~~~~~~~~~");
		LOG.debug("~~webApplicationContext~~"+webApplicationContext);
		LOG.debug("~~~~~~~~~~~~~~~~~~~~~~~~");
		
		reserv01 = new ReservVO("200515_60","code_1",3,"1",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일");
		reserv02 = new ReservVO("2","code_2",3,"1",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일");
		reserv03 = new ReservVO("3","code_3",3,"1",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일");
		
		reserv04 = new ReservVO();
	}

	@Test
	@Ignore
	public void doInsert() {
		
		//1. 입력
		
		int flag = dao.doInsert(reserv01);
		flag += dao.doInsert(reserv02);
		flag += dao.doInsert(reserv03);
		
		LOG.debug("---------------------");
		LOG.debug("-flag:-"+flag);
		LOG.debug("---------------------");
		assertThat(flag, is(3));
		
	}
	
	@Test
	public void doUpdate() {
		
		reserv01.setApproval("2");
		
		int flag = dao.doUpdate(reserv01);
		
		LOG.debug("---------------------");
		LOG.debug("-flag:-"+flag);
		LOG.debug("---------------------");
		assertThat(flag, is(1));
	}
	
	@Test
	public void doSelectOne() {
		
		ReservVO vsVO = (ReservVO) dao.doSelectOne(reserv01);
		
		LOG.debug("----------------------");
		LOG.debug("-doSelectOne vsVO-"+vsVO);
		LOG.debug("----------------------");
	}
	
	@Test
	public void getAll() {
		
		reserv04.setRegId("bealright6@naver.com");
		
		List<ReservVO> list = (List<ReservVO>) dao.getAll(reserv04);
		
		for(ReservVO vo :list) {
			LOG.debug("=vo="+vo);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("~~~~~~~~~~~~~~~~~~~~~~~~");
		LOG.debug("~~tearDown()~~");
		LOG.debug("~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Test
	public void test() {
		LOG.debug("===================");
		LOG.debug("=test()=");
		LOG.debug("===================");
		
		LOG.debug("===================");
		LOG.debug("=dao="+dao);
		LOG.debug("===================");
		
		assertNotNull(dao);
		assertThat(1, is(1));
	}

}
