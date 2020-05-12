package com.sist.d_dolive.bizmember;

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

import com.sist.d_dolive.bizmember.imple.BizMemberDaoImple;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestBizMemberControllerWeb {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	private List<BizMemberVO> bizMemberList;
	
	@Autowired
	BizMemberService bizMemberService;
	
	@Autowired
	BizMemberDaoImple bizMemberDaoImple;
	 
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		bizMemberList = Arrays.asList(
				new BizMemberVO("이메일1", "비밀번호1", "1", "박종훈1", "920826", "서울시 노원구", "안알랴줌동", "12345", "010-0000-0000", "123-45-67891", "010-1111-1111", "PCODE_12345", "admin01", "2020/05/11", "admin01", "2020/05/11")
				, new BizMemberVO("이메일2", "비밀번호2", "2", "박종훈2", "920826", "서울시 노원구", "안알랴줌동", "12345", "010-0000-0000", "123-45-67891", "010-1111-1111", "PCODE_12345", "admin01", "2020/05/11", "admin01", "2020/05/11")
				, new BizMemberVO("이메일3", "비밀번호3", "1", "박종훈3", "920826", "서울시 노원구", "안알랴줌동", "12345", "010-0000-0000", "123-45-67891", "010-1111-1111", "PCODE_12345", "admin01", "2020/05/11", "admin01", "2020/05/11")
		);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=====================");		
	}
	
	@Test
	public void doUpdate() throws Exception {
		//1. 전체 삭제
		bizMemberDaoImple.doDeleteAll();
		
		//2. 단건 입력
		int flag = bizMemberDaoImple.doInsert(bizMemberList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회: bizMember 조회
		BizMemberVO bizMember = (BizMemberVO) bizMemberDaoImple.doSelectOne(bizMemberList.get(0));
		LOG.debug("=====================");
		LOG.debug("=bizMember="+bizMember);
		LOG.debug("=====================");
		
		//3.1. 단건 수정
		bizMember.setEmail(bizMember.getEmail());
		bizMember.setPw(bizMember.getPw() + "_U");
		bizMember.setGender("2");
		bizMember.setName(bizMember.getName() + "_U");
		bizMember.setBirth("123456");
		bizMember.setAddr(bizMember.getAddr() + "_U");
		bizMember.setAddr2(bizMember.getAddr2() + "_U");
		bizMember.setZipNo("96548");
		bizMember.setTel("010-8888-8888");
		bizMember.setBizRno("987-65-43210");
		bizMember.setBizTel("010-9999-9999");
		bizMember.setPcode(bizMember.getPcode() + "_U");
		bizMember.setModId(bizMember.getModId() + "_U");
		
		//4. 수정
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.post("/bizmember/do_update.do")
				.param("email", bizMember.getEmail())
				.param("pw", bizMember.getPw())
				.param("gender", bizMember.getGender())
				.param("name", bizMember.getName())
				.param("birth", bizMember.getBirth())
				.param("addr", bizMember.getAddr())
				.param("addr2", bizMember.getAddr2())
				.param("zipNo", bizMember.getZipNo())
				.param("tel", bizMember.getTel())
				.param("bizRno", bizMember.getBizRno())
				.param("bizTel", bizMember.getBizTel())
				.param("pcode", bizMember.getPcode())
				.param("modId", bizMember.getModId())
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
		
		//5. 수정 데이터 조회
		BizMemberVO vsVO = (BizMemberVO) bizMemberDaoImple.doSelectOne(bizMember);
		
		//6. 비교
		checkSameUser(bizMember, vsVO);
	}
	
	@Test
	public void doDelete() throws Exception {
		//1. 전체 삭제
		bizMemberDaoImple.doDeleteAll();
		
		//2. 단건 입력
		int flag = bizMemberDaoImple.doInsert(bizMemberList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회: email 조회
		BizMemberVO email = (BizMemberVO) bizMemberDaoImple.doSelectOne(bizMemberList.get(0));
		LOG.debug("=====================");
		LOG.debug("=email="+email);
		LOG.debug("=====================");
		
		//4. 삭제
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.post("/bizmember/do_delete.do")
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
	public void doSelectOne() throws Exception {
		//1. 전체 삭제
		bizMemberDaoImple.doDeleteAll();
		
		//2. 단건 입력
		int flag = bizMemberDaoImple.doInsert(bizMemberList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.get("/bizmember/do_selectone.do")
				.param("email", bizMemberList.get(0).getEmail())
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
	public void doInsert() throws Exception {
		bizMemberDaoImple.doDeleteAll();
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/bizmember/do_insert.do")
				.param("email", bizMemberList.get(0).getEmail())
				.param("pw", bizMemberList.get(0).getPw())
				.param("gender", bizMemberList.get(0).getGender())
				.param("name", bizMemberList.get(0).getName())
				.param("birth", bizMemberList.get(0).getBirth())
				.param("addr", bizMemberList.get(0).getAddr())
				.param("addr2", bizMemberList.get(0).getAddr2())
				.param("zipNo", bizMemberList.get(0).getZipNo())
				.param("tel", bizMemberList.get(0).getTel())
				.param("bizRno", bizMemberList.get(0).getBizRno())
				.param("bizTel", bizMemberList.get(0).getBizTel())
				.param("pcode", bizMemberList.get(0).getPcode())
				.param("regId", bizMemberList.get(0).getRegId())
				.param("modId", bizMemberList.get(0).getModId())
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
	
	public void checkSameUser(BizMemberVO orgVO, BizMemberVO vsVO) {
		//assertTrue(orgVO.equals(vsVO));
		assertThat(orgVO.getEmail(), is(vsVO.getEmail()));
		assertThat(orgVO.getPw(), is(vsVO.getPw()));
		assertThat(orgVO.getName(), is(vsVO.getName()));
	}
	
	@Test
	@Ignore
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		LOG.debug("=====================");
		LOG.debug("=bizMemberService="+bizMemberService);
		LOG.debug("=bizMemberDaoImple="+bizMemberDaoImple);
		LOG.debug("=====================");		
		assertNotNull(bizMemberService);
		assertNotNull(bizMemberDaoImple);
		assertThat(1, is(1));
	}
	
}
