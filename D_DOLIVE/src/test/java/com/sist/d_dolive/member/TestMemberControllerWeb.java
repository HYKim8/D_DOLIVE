package com.sist.d_dolive.member;

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
import com.sist.d_dolive.member.imple.MemberDaoImple;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestMemberControllerWeb {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	private List<MemberVO> memberList;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberDaoImple memberDaoImple;
	 
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		memberList = Arrays.asList(
				new MemberVO("이메일1", "비밀번호1", "1", "박종훈1", "920826", "서울시 노원구", "안알랴줌동", "12345", "010-0000-0000", "admin01", "2020/05/11", "admin01", "2020/05/11")
				, new MemberVO("이메일2", "비밀번호2", "2", "박종훈2", "920826", "서울시 노원구", "안알랴줌동", "12345", "010-0000-0000", "admin01", "2020/05/11", "admin01", "2020/05/11")
				, new MemberVO("이메일3", "비밀번호3", "1", "박종훈3", "920826", "서울시 노원구", "안알랴줌동", "12345", "010-0000-0000", "admin01", "2020/05/11", "admin01", "2020/05/11")
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
		memberDaoImple.doDeleteAll();
		
		//2. 단건 입력
		int flag = memberDaoImple.doInsert(memberList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회: Member 조회
		MemberVO member = (MemberVO) memberDaoImple.doSelectOne1(memberList.get(0));
		LOG.debug("=====================");
		LOG.debug("=Member="+member);
		LOG.debug("=====================");
		
		//3.1. 단건 수정
		
		member.setPw(member.getPw() + "_U");
		member.setGender("2");
		member.setName(member.getName() + "_U");
		member.setIhidnum(member.getIhidnum() + "_U");
		member.setAddr(member.getAddr() + "_U");
		member.setAddr2(member.getAddr2() + "_U");
		member.setZipno("96548");
		member.setTel("010-8888-8888");
		member.setModid(member.getModid() + "_U");
		member.setEmail(member.getEmail());
		
		//4. 수정
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.post("/member/update.do")
				.param("pw", member.getPw())
				.param("gender", member.getGender())
				.param("name", member.getName())
				.param("ihidnum", member.getIhidnum())
				.param("addr", member.getAddr())
				.param("addr2", member.getAddr2())
				.param("zipno", member.getZipno())
				.param("tel", member.getTel())
				.param("modid", member.getModid())
				.param("email",member.getEmail())
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
		MemberVO vsVO = (MemberVO) memberDaoImple.doSelectOne1(member);
		
		//6. 비교
		checkSameUser(member, vsVO);
	}
	
	
	
	
	
	@Test
	public void doDelete() throws Exception {
		//1. 전체 삭제
		memberDaoImple.doDeleteAll();
		//2. 단건 입력
		int flag = memberDaoImple.doInsert(memberList.get(0));
		assertThat(flag, is(1));
		
		//3. 단건 조회: email 조회
		MemberVO email = (MemberVO) memberDaoImple.doSelectOne1(memberList.get(0));
		LOG.debug("=====================");
		LOG.debug("=email1="+email);
		LOG.debug("=====================");
		
		//4. 삭제
		//url+param
		MockHttpServletRequestBuilder createMesage
			= MockMvcRequestBuilders.post("/member/do_delete.do")
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
	
//	@Test
//	public void doSelectOne() throws Exception {
//		//1. 전체 삭제
//		memberDaoImple.doDeleteAll();
//		
//		//2. 단건 입력
//		int flag = memberDaoImple.doInsert(memberList.get(0));
//		assertThat(flag, is(1));
//		
//		//3. 단건 조회
//		//url+param
//		MockHttpServletRequestBuilder createMesage
//			= MockMvcRequestBuilders.get("/member/idCount.do")
//				.param("email", memberList.get(0).getEmail())
//		;		
//		
//		//MediaType.APPLICATION_JSON_UTF8 ==application/json;charset=UTF-8
//		ResultActions resultActions = mockMvc.perform(createMesage)
//			.andExpect(status().is2xxSuccessful())	
//		;
//				
//		String result = resultActions.andDo(print())
//				.andReturn()
//				.getResponse().getContentAsString()
//		;
//		LOG.debug("=====================");
//		LOG.debug("=result="+result);
//		LOG.debug("=====================");  		
//	}
	
	
	@Test
	public void doInsert() throws Exception {
		//memberDaoImple.doDeleteAll();
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/member/insert.do")
				.param("email", memberList.get(0).getEmail())
				.param("pw", memberList.get(0).getPw())
				.param("gender", memberList.get(0).getGender())
				.param("name", memberList.get(0).getName())
				.param("ihidnum", memberList.get(0).getIhidnum())
				.param("addr", memberList.get(0).getAddr())
				.param("addr2", memberList.get(0).getAddr2())
				.param("zipno", memberList.get(0).getZipno())
				.param("tel", memberList.get(0).getTel())
				.param("regid", memberList.get(0).getRegid())
				.param("regdt", memberList.get(0).getRegdt())
				.param("modid", memberList.get(0).getModid())
				.param("moddt", memberList.get(0).getModdt())
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
	
	public void checkSameUser(MemberVO orgVO, MemberVO vsVO) {
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
		LOG.debug("=memberService="+memberService);
		LOG.debug("=memberService="+memberDaoImple);
		LOG.debug("=====================");		
		assertNotNull(memberService);
		assertNotNull(memberDaoImple);
		assertThat(1, is(1));
	}
	
}
