package com.sist.d_dolive.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
									})
public class TestReservWeb {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ReservService reservService;
	
	//setUp용 list변수 선언
	private List<ReservVO> reservList;
	
	//브라우저 대신 테스트
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		reservList = Arrays.asList(
				new ReservVO("200515_60","code_1",3,"1",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일")
				,new ReservVO("1","code_2",3,"1",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일")
				,new ReservVO("2","code_3",3,"1",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일")
				);
				
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=========================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=========================");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=reservService="+reservService);
		LOG.debug("=====================");		
		
		assertNotNull(reservService);
	
		assertThat(1, is(1));
	}

}
