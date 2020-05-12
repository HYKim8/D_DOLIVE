package com.sist.d_dolive.notice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

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

import com.sist.d_dolive.notice.imple.NoticeDaoImple;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNoticeControllerWeb {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	private List<NoticeVO> noticeList;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	NoticeDaoImple noticeDaoImple;
	 
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		noticeList = Arrays.asList(
				new NoticeVO("판매처코드1", "이메일1", "1", "0")
				, new NoticeVO("판매처코드2", "이메일2", "0", "1")
				, new NoticeVO("판매처코드3", "이메일3", "1", "0")
		);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=====================");		
	}
	
	@Test
	public void doRetrieve() throws Exception {
		//1. 전체 삭제
		noticeDaoImple.doDeleteAll();
		
		//2. 3건 입력
		int flag = noticeDaoImple.doInsert(noticeList.get(0));
		flag += noticeDaoImple.doInsert(noticeList.get(1));
		flag += noticeDaoImple.doInsert(noticeList.get(2));
		assertThat(flag, is(3));
		
		//3. 조회
		//url+param
		MockHttpServletRequestBuilder createMesage 
			= MockMvcRequestBuilders.get("/notice/do_retrieve.do")
				.param("pageNum", "1")
				.param("pageSize", "10")
	            .param("searchDiv", "")
	            .param("searchWord", " ")
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
	public void doDelete() throws Exception {
		//1. 전체 삭제
		noticeDaoImple.doDeleteAll();
		
		//2. 단건 입력
		int flag = noticeDaoImple.doInsert(noticeList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회: email 조회
		NoticeVO email = (NoticeVO) noticeDaoImple.doSelectOne(noticeList.get(0));
		LOG.debug("=====================");
		LOG.debug("=email="+email);
		LOG.debug("=====================");
		
		//4. 삭제
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.post("/notice/do_delete.do")
				.param("pcode", email.getPcode())
				.param("email", email.getEmail())
		;		
		
		//MediaType.APPLICATION_JSON_UTF8 ==application/json;charset=UTF-8
		ResultActions resultActions = mockMvc.perform(createMesage)
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
	
	@Test
	@Ignore
	public void doSelectOne() throws Exception {
		//1. 전체 삭제
		noticeDaoImple.doDeleteAll();
		
		//2. 단건 입력
		int flag = noticeDaoImple.doInsert(noticeList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.get("/notice/do_selectone.do")
				.param("pcode", noticeList.get(0).getPcode())
				.param("email", noticeList.get(0).getEmail())
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
	public void doInsert() throws Exception {
		noticeDaoImple.doDeleteAll();
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/notice/do_insert.do")
				.param("pcode", noticeList.get(0).getPcode())
				.param("email", noticeList.get(0).getEmail())
				.param("remainStockYn", noticeList.get(0).getRemainStockYn())
				.param("emptyStockYn", noticeList.get(0).getEmptyStockYn())
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
	
	public void checkSameUser(NoticeVO orgVO, NoticeVO vsVO) {
		//assertTrue(orgVO.equals(vsVO));
		assertThat(orgVO.getPcode(), is(vsVO.getPcode()));
		assertThat(orgVO.getEmail(), is(vsVO.getEmail()));
		assertThat(orgVO.getRemainStockYn(), is(vsVO.getRemainStockYn()));
		assertThat(orgVO.getEmptyStockYn(), is(vsVO.getEmptyStockYn()));
	}
	
	@Test
	@Ignore
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		LOG.debug("=====================");
		LOG.debug("=noticeService="+noticeService);
		LOG.debug("=noticeDaoImple="+noticeDaoImple);
		LOG.debug("=====================");		
		assertNotNull(noticeService);
		assertNotNull(noticeDaoImple);
		assertThat(1, is(1));
	}
	
}
