package com.sist.d_dolive.member.web;

import java.util.List;
import java.util.Locale;

import javax.inject.Qualifier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

@Controller
public class MemberCont {

	private final Logger  LOG = LoggerFactory.getLogger(MemberCont.class);
	
	//@Qualifier("dummyMailSender") : root-context.xml bean id
	@Autowired
	MemberService memberService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "member/insert.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(MemberVO memberVO, Locale locale) {
		
		LOG.debug("1===================");
		LOG.debug("1=memberVO11="+memberVO);
		LOG.debug("1===================");
		
		int  flag = this.memberService.doInsert(memberVO);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 성공.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 실패.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2=================");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2=================");		
		return jsonStr;
	}
	
	
	
	@RequestMapping(value = "member/update.do",method = RequestMethod.POST ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doUpdate(MemberVO memberVO, Locale locale) {
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");
		
		int  flag = this.memberService.doUpdate(memberVO);
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");
		
		//메시지 처리
		MessageVO message=new MessageVO();

		message.setMsgId(flag+"");
		//성공
		if(flag ==1) {
			message.setMsgMsg(memberVO.getEmail()+"님이 수정 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(memberVO.getEmail()+"님 등록 실패.");			
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
	public int idCount(MemberVO memberVO, Locale locale) {
		
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");
		
		int  cnt = memberService.idCount(memberVO);
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=cnt="+cnt); 
		LOG.debug("1.2===================");
		
		return cnt;
	}
	
	@ResponseBody
	@RequestMapping(value="member/find_id.do",method = RequestMethod.GET
		       ,produces = "application/json;charset=UTF-8")
	public String doFindId(MemberVO MemberVO,Locale locale, Model model ) {
		LOG.debug("1===================");
		LOG.debug("1=param="+MemberVO);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) this.memberService.doFindId(MemberVO);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");
		model.addAttribute("vo", outVO);
		if (outVO != null) {
			return outVO.getEmail();
		} else {
			return "x";
		}
		
	}
		
	
	
	

	@RequestMapping(value="member/do_find_pw.do",method = RequestMethod.POST
		       ,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doFindPw(MemberVO memberVO,Locale locale, Model model ) {//이메일찾기 단건조회
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) memberService.doFindPw(memberVO);
		memberService.sendEmail(outVO);
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		model.addAttribute("vo", outVO);
		
		return "member/id_pw_find";
	}
	
	
	@RequestMapping(value="member/do_delete.do",method = RequestMethod.POST
			       ,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(MemberVO memberVO, Locale locale) {
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");		
		
		int flag = 0;
		flag = this.memberService.doDelete(memberVO);
		
		MessageVO message=new MessageVO();
		message.setMsgId(String.valueOf(flag));
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");	
		
		//성공
		if(flag ==1) {
			message.setMsgMsg(memberVO.getEmail()+"님이 삭제 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(memberVO.getEmail()+"삭제 실패.");
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
	public MemberVO getMember(MemberVO memberVO,Locale locale, Model model) {
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");		
		
		MemberVO outVO = (MemberVO) this.memberService.getMember(memberVO);
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
	

	@RequestMapping(value="member/do_select_one.do",method = RequestMethod.GET)
	public String doSelectOne(MemberVO memberVO,Locale locale, Model model) {
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");		
		if(null==memberVO.getEmail() || memberVO.getEmail().equals("")) {
			throw new IllegalArgumentException("Email을 확인 하세요.");
		}
		MemberVO outVO = (MemberVO) this.memberService.doSelectOne(memberVO);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		model.addAttribute("vo", outVO);
		
		return "member/member_update";
	}
	
	@RequestMapping(value="member/do_select_one1.do",method = RequestMethod.GET)
	public String doSelectOne1(MemberVO memberVO,Locale locale, Model model) {
		LOG.debug("1===================");
		LOG.debug("1=memberVO="+memberVO);
		LOG.debug("1===================");		
		if(null==memberVO.getEmail() || memberVO.getEmail().equals("")) {
			throw new IllegalArgumentException("Email을 확인 하세요.");
		}
		MemberVO outVO = (MemberVO) this.memberService.doSelectOne1(memberVO);
		//outVO.setLevel(outVO.getLevel().intValue());
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");		
		
		model.addAttribute("vo", outVO);
		
		return "member/member_select_one";
	}
	
	   @RequestMapping(value="member/login.do",method = RequestMethod.POST)
	   public String doLogin(HttpServletRequest req, Model model) {
	      LOG.debug("=======================================");
	      LOG.debug("=doLogin/param");
	      LOG.debug("=doLogin/memberId:"+req.getParameter("email"));
	      LOG.debug("=doLogin/password:"+req.getParameter("pw"));
	      LOG.debug("=======================================");
	      
	      MemberVO inVO=new MemberVO();
	      inVO.setEmail(req.getParameter("email"));
	      inVO.setPw(req.getParameter("pw"));
	      
	      MemberVO outVO=(MemberVO)this.memberService.getMember(inVO);
	      if(outVO.getEmail()==null || "".equals(outVO.getEmail())) {
	         model.addAttribute("loginFailure","아이디와 비밀번호를 확인해주세요.");
	         return "webapp/member/login";
	      }else {
	         MemberVO memVO=new MemberVO();
	         memVO.setEmail(outVO.getEmail());
	         HttpSession session=req.getSession();
	         StringBuilder out=new StringBuilder();
	         model.addAttribute("memberVO", outVO);
	         session.setAttribute("memberEmail", outVO.getEmail());
	         return "pharmacymap/Main";

	      }
	   }	

	
}
