package com.sist.d_dolive.member.web;

import java.util.List;

import javax.inject.Qualifier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sist.d_dolive.cmn.DTO;
import com.sist.d_dolive.cmn.MessageVO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.cmn.StringUtil;
import com.sist.d_dolive.member.MemberService;
import com.sist.d_dolive.member.MemberVO;
import com.sist.d_dolive.member.imple.MemberServiceImple;

//@Controller
public class MemberCont {

	private final Logger  LOG = LoggerFactory.getLogger(MemberCont.class);
	
	//@Qualifier("dummyMailSender") : root-context.xml bean id
	@Autowired
	MemberService userService;

	@RequestMapping("/login.do")
	public ModelAndView login(MemberVO vo, HttpServletRequest request) {
		System.out.println("로그인  처리...");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
			MemberVO mem = (MemberVO) userService.getMember(vo);
			if (mem != null) {
				session.setAttribute("authUser", mem);
				mav.setViewName("index.jsp");
				return mav;
				
			} else
				mav.setViewName("login.jsp");
			mav.addObject("notExist", true);
			return mav;
		
	}

	
	@RequestMapping(value = "member/insert.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String insert(MemberVO user) {
		
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		
		int  flag = userService.doInsert(user);
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");
		
		//메시지 처리
		MessageVO message=new MessageVO();

		message.setMsgId(flag+"");
		//성공
		if(flag ==1) {
			message.setMsgMsg(user.getEmail()+"님이 등록 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(user.getEmail()+"님 등록 실패.");			
		}
		
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json); 
		LOG.debug("1.3===================");		
		
		return json;
	}
	
	
	
	@RequestMapping(value = "member/update.do",method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doUpdate(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		
		int  flag = userService.doUpdate(user);
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");
		
		//메시지 처리
		MessageVO message=new MessageVO();

		message.setMsgId(flag+"");
		//성공
		if(flag ==1) {
			message.setMsgMsg(user.getEmail()+"님이 수정 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(user.getEmail()+"님 등록 실패.");			
		}		
		
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json); 
		LOG.debug("1.3===================");		
		
		return json;
		
	}
	
	
	@RequestMapping(value = "member/idCount.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int idCount(MemberVO user) {
		
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		
		int  cnt = userService.idCount(user);
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=cnt="+cnt); 
		LOG.debug("1.2===================");
		
		return cnt;
	}
	
	@RequestMapping(value="member/find_id.do",method = RequestMethod.POST
		       ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doFindId(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) userService.doFindId(user);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		Gson gson=new Gson();
		String json = gson.toJson(outVO);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json);
		LOG.debug("1.3===================");		
		
		return json;
	}
		
	
	
	

	@RequestMapping(value="member/do_find_pw.do",method = RequestMethod.POST
		       ,produces = "application/json;charset=UTF-8")
    @ResponseBody	
	public MemberVO doFindPw(MemberVO user) {//이메일찾기 단건조회
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) userService.doFindPw(user);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		Gson gson=new Gson();
		String json = gson.toJson(outVO);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json);
		LOG.debug("1.3===================");		
		
		return outVO;
	}
	
	
	@RequestMapping(value="member/do_delete.do",method = RequestMethod.POST
			       ,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");		
		
		int flag = 0;
		flag = userService.doDelete(user);
		
		MessageVO message=new MessageVO();
		message.setMsgId(String.valueOf(flag));
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");	
		
		//성공
		if(flag ==1) {
			message.setMsgMsg(user.getEmail()+"님이 삭제 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(user.getEmail()+"삭제 실패.");
		}
		
		
		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json); 
		LOG.debug("1.3===================");		
		
		return json;	
	}
	
	
	@RequestMapping(value="member/do_getmember.do",method = RequestMethod.POST
		       ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public MemberVO getMember(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) userService.getMember(user);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		Gson gson=new Gson();
		String json = gson.toJson(outVO);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json);
		LOG.debug("1.3===================");		
		
		return outVO;
	}
	

	@RequestMapping(value="member/do_select_one.do",method = RequestMethod.POST
		       ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public MemberVO doSelectOne(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) userService.doSelectOne(user);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		Gson gson=new Gson();
		String json = gson.toJson(outVO);
		
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json);
		LOG.debug("1.3===================");		
		
		return outVO;
	}
	

	
}
