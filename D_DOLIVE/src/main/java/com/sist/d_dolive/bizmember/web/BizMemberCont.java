/**
 * 
 */
package com.sist.d_dolive.bizmember.web;

import java.util.Locale;

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

import com.google.gson.Gson;
import com.sist.d_dolive.bizmember.BizMemberService;
import com.sist.d_dolive.bizmember.BizMemberVO;
import com.sist.d_dolive.cmn.MessageVO;

/**
 * @author sist
 *
 */
@Controller
public class BizMemberCont {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BizMemberService bizMemberService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "bizmember/do_update.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(BizMemberVO bizMemberVO, Locale locale) {
		LOG.debug("1==================");
		LOG.debug("1=param="+bizMemberVO);
		LOG.debug("1==================");
		
		if(null==bizMemberVO.getEmail() || bizMemberVO.getEmail().equals("")) {
			throw new IllegalArgumentException("Email을 확인 하세요.");
		}
		
		if(null==bizMemberVO.getPw() || bizMemberVO.getPw().equals("")) {
			//다국어 메시지 처리
			String pw = messageSource.getMessage("message.bizmember.pw", null, locale);
			Object[] args = new String[]{pw};			
			String commMsg = messageSource.getMessage("message.common.message.save", args, locale);
			LOG.debug("1.1==================");
			LOG.debug("1.1=commMsg="+commMsg);
			LOG.debug("1.1==================");
			
			throw new IllegalArgumentException(commMsg);
		}
		
		if(null==bizMemberVO.getName() || bizMemberVO.getName().equals("")) {
			//다국어 메시지 처리
			String name = messageSource.getMessage("message.bizmember.name", null, locale);
			Object[] args = new String[]{name};			
			String commMsg = messageSource.getMessage("message.common.message.save", args, locale);
			LOG.debug("1.1==================");
			LOG.debug("1.1=commMsg="+commMsg);
			LOG.debug("1.1==================");
			
			throw new IllegalArgumentException(commMsg);
		}
		
		int flag = this.bizMemberService.doUpdate(bizMemberVO);
		
		MessageVO message = new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 성공.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 실패.");
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2==================");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2==================");
		
		return jsonStr;
	}
	
	@RequestMapping(value = "bizmember/do_delete.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doDelete(BizMemberVO bizMemberVO, Locale locale) {
		//param board_id
		LOG.debug("1==================");
		LOG.debug("1=param="+bizMemberVO);
		LOG.debug("1==================");
		
		if(null==bizMemberVO.getEmail() || bizMemberVO.getEmail().equals("")) {
			throw new IllegalArgumentException("Email을 확인 하세요.");
		}
		
		int flag = this.bizMemberService.doDelete(bizMemberVO);
		
		MessageVO message = new MessageVO();
		//삭제 성공
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("탈퇴 되었습니다.");
		//실패
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("탈퇴 실패.");
		}
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(message);
		LOG.debug("2==================");
		LOG.debug("2=gsonStr="+gsonStr);
		LOG.debug("2==================");
		
		return gsonStr;
	}
	
	@RequestMapping(value = "bizmember/do_select_one.do", method = RequestMethod.GET)
	public String doSelectOne(BizMemberVO bizMemberVO, Locale locale, Model model) {
		//board_id
		LOG.debug("1==================");
		LOG.debug("1=param="+bizMemberVO);
		LOG.debug("1==================");
		
		if(null==bizMemberVO.getEmail() || bizMemberVO.getEmail().equals("")) {
			throw new IllegalArgumentException("Email을 확인 하세요.");
		}
		
		BizMemberVO outVO = (BizMemberVO) this.bizMemberService.doSelectOne(bizMemberVO);
		LOG.debug("1.1==================");
		LOG.debug("1.1=outVO="+outVO);
		LOG.debug("1.1==================");
		
		model.addAttribute("vo", outVO);
		
		String url = "";
		
		if(bizMemberVO.getOptionDiv().equals("1")) {
			url = "bizmember/bizmember_select_one";
		}else if(bizMemberVO.getOptionDiv().equals("2")) {
			url = "bizmember/bizmember_update";
		}
		
		return url;
	}
	
	@RequestMapping(value = "bizmember/do_login.do", method = RequestMethod.POST
			, produces ="application/json; charset=UTF-8")
	@ResponseBody
	public String doLogin(BizMemberVO bizMemberVO, Locale locale, Model model, HttpSession session) {
		LOG.debug("1===================");
		LOG.debug("1=param="+bizMemberVO);
		LOG.debug("1===================");
		String message = "";
		if(null == bizMemberVO.getEmail() || "".equals(bizMemberVO.getEmail().trim())) {
			message="이메일을 입력 하세요.";
			throw new IllegalArgumentException(message);
		}

		if(null == bizMemberVO.getPw() || "".equals(bizMemberVO.getPw().trim())) {
			message="비번을 입력 하세요.";
			throw new IllegalArgumentException(message);
		}

		int flag = this.bizMemberService.idPwCheck(bizMemberVO);
		MessageVO messageVO = new MessageVO();
		messageVO.setMsgId(String.valueOf(flag));

		if(10==flag) {//ID CHECK
			messageVO.setMsgMsg("아이디를 확인 하세요.");
		}else if(20==flag) {// pass CHECK
			messageVO.setMsgMsg("비번를 확인 하세요.");
		}else if(30==flag) {// 성공
			messageVO.setMsgMsg("로그인 성공.");
			//사용자 정보 조회
			BizMemberVO userInfo = (BizMemberVO) this.bizMemberService.doSelectOne(bizMemberVO);
			LOG.debug("2===================");
			LOG.debug("2=userInfo="+userInfo);
			LOG.debug("2===================");

			session.setAttribute("bizMember", userInfo);
		}

		Gson gson = new Gson();
		String json = gson.toJson(messageVO);
		LOG.debug("2===================");
		LOG.debug("2=json="+json);
		LOG.debug("2===================");

		return json;
	}
	
	@RequestMapping(value = "bizmember/do_insert.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(BizMemberVO bizMemberVO, Locale locale) {
		LOG.debug("1==================");
		LOG.debug("1=param="+bizMemberVO);
		LOG.debug("1==================");
		
		if(null == bizMemberVO.getEmail() || "".equals(bizMemberVO.getEmail().trim())) {
			//다국어 메시지 처리
			String email = messageSource.getMessage("message.bizmember.email", null, locale);
			Object[] args = new String[]{email};			
			String commMsg = messageSource.getMessage("message.common.message.save", args, locale);
			LOG.debug("1.1==================");
			LOG.debug("1.1=commMsg="+commMsg);
			LOG.debug("1.1==================");
			
			throw new IllegalArgumentException(commMsg);
		}
		
		if(null == bizMemberVO.getPw() || "".equals(bizMemberVO.getPw().trim())) {
			//다국어 메시지 처리
			String pw = messageSource.getMessage("message.bizmember.pw", null, locale);
			Object[] args = new String[]{pw};			
			String commMsg = messageSource.getMessage("message.common.message.save", args, locale);
			LOG.debug("1.1==================");
			LOG.debug("1.1=commMsg="+commMsg);
			LOG.debug("1.1==================");
			
			throw new IllegalArgumentException(commMsg);
		}
		
		int flag = this.bizMemberService.doInsert(bizMemberVO);
		
		MessageVO message = new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 성공.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 실패.");
		}
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2==================");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2==================");
		
		return jsonStr;
	}

}
