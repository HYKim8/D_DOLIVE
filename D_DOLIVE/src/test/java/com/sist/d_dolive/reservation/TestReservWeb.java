package com.sist.d_dolive.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sist.d_dolive.reservation.imple.ReservDaoImple;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
									})
public class TestReservWeb {

	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ReservService reservService;
	
	@Autowired
	ReservDaoImple reservDaoImple;
	
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	//
	private List<ReservVO> reservList;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		reservList = Arrays.asList(
				new ReservVO("200518_141","code_1",3,"1","imp_111",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일","이름1","주민1","약국명","약국주소")
				,new ReservVO("200515_61","code_1",3,"1","imp_111",4500,"bealright6@naver.com","등록일","bealright6@naver.com","수정일","이름2","주민2","약국명","약국주소")        
				,new ReservVO("200515_62","code_12",3,"1","imp_111",4500,"bealright6@naver.com2","등록일","bealright6@naver.com","수정일","이름3","주민3","약국명","약국주소")       
				);
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("========================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("========================");		
	}
	
	@Test
	@Ignore
	public void doRetrieve() throws Exception {
		//1. 전체 삭제
		reservDaoImple.doDeleteAll();
		
		//2. 3건 입력
		int flag = reservDaoImple.doInsert(reservList.get(0));
		flag += reservDaoImple.doInsert(reservList.get(1));
		flag += reservDaoImple.doInsert(reservList.get(2));
		assertThat(flag, is(3));
		
		//3. 조회
		//url+param
		MockHttpServletRequestBuilder createMesage 
			= MockMvcRequestBuilders.get("/reserv/do_retrieve.do")
				.param("pageNum", "1")
				.param("pageSize", "10")
	            .param("searchDiv", "20")
	            .param("searchWord", "code_1")
		;
		
		ResultActions resultActions = mockMvc.perform(createMesage)
				.andExpect(status().is2xxSuccessful())
		;
				
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
		;
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");
	}
	
	@Test
	@Ignore
	public void doInsert() throws Exception {
		//1. 전체 삭제
		reservDaoImple.doDeleteAll();
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/reserv/do_insert.do")
				.param("rno", reservList.get(0).getRno())
				.param("pcode", reservList.get(0).getPcode())
				.param("maskCnt", String.valueOf(reservList.get(0).getMaskCnt()))
				.param("approval", reservList.get(0).getApproval())
				.param("amount", String.valueOf(reservList.get(0).getAmount()))
				.param("regId", reservList.get(0).getRegId())
				.param("modId", reservList.get(0).getModId())
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")))
				;
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;
		
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");
	}
	
	@Test
	public void doSelectOne() throws Exception {
		MockHttpServletRequestBuilder createMesage = MockMvcRequestBuilders.get("/reserv/do_select_one.do")
			.param("rno", reservList.get(0).getRno())
			;		
	
	//MediaType.APPLICATION_JSON_UTF8 ==application/json;charset=UTF-8
	ResultActions resultActions = mockMvc.perform(createMesage)
		.andExpect(status().is2xxSuccessful())	
	;
			
	String result = resultActions.andDo(print())
			.andReturn()
			.getResponse().getContentAsString()
	;
	LOG.debug("=====================");
	LOG.debug("=result="+result);
	LOG.debug("=====================");  		
	}
	
	
	@Test
	@Ignore
	public void doUpdate() throws Exception {
		//1. 전체 삭제
		//reservDaoImple.doDeleteAll();
		
		//2. 단건 입력
		//int flag = reservService.doInsert(reservList.get(0));
		//assertThat(flag, is(1));
		
		//3. 단건 수정
		reservList.get(0).setApproval("2");
		reservList.get(0).setModId("수정자");
		
		//4. Mock 테스트
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/reserv/do_update.do")
													
													.param("approval", reservList.get(0).getApproval())
													.param("modId", reservList.get(0).getModId())
													.param("rno", reservList.get(0).getRno());
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")))
				;
		
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString()
				;
		
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
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
