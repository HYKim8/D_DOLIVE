package com.sist.d_dolive.reservation.web;

import java.util.Locale;

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
import com.sist.d_dolive.cmn.MessageVO;
import com.sist.d_dolive.reservation.ReservService;
import com.sist.d_dolive.reservation.ReservVO;

@Controller
public class ReservCont {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReservService reservService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "reserv/do_insert.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(ReservVO reservVO, Locale locale) {
		
		//1. param
		LOG.debug("Cont 1.==========================");
		LOG.debug("Cont 1.=param="+reservVO);
		LOG.debug("Cont 1.==========================");
		
		//TODO 다국어 메시지 처리
		
		//2. doInsert
		int flag = this.reservService.doInsert(reservVO);
		LOG.debug("Cont 2.==========================");
		LOG.debug("Cont 2.=flag="+flag);
		LOG.debug("Cont 2.==========================");
		
		//3. message 처리
		MessageVO message = new MessageVO();
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 성공");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 실패");
		}
		LOG.debug("Cont 3.==========================");
		LOG.debug("Cont 3.=message="+message.getMsgMsg());
		LOG.debug("Cont 3.==========================");
		
		//4. Json 처리
		Gson gson = new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("Cont 4.==========================");
		LOG.debug("Cont 4.=jsonStr="+jsonStr);
		LOG.debug("Cont 4.==========================");
		
		return jsonStr;
	}
	
	
	@RequestMapping(value = "reserv/do_update.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(ReservVO reservVO, Locale locale) {
		
		//1. param
		LOG.debug("Cont 1.==========================");
		LOG.debug("Cont 1.=param="+reservVO);
		LOG.debug("Cont 1.==========================");
		
		if(reservVO.getApproval() == null || reservVO.getApproval().equals("")) {
			throw new IllegalArgumentException("에약건을 확인하세요.");
		}
		
		//TODO 다국어 메시지 처리
		
		//2. doUpdate
		int flag = this.reservService.doUpdate(reservVO);
		LOG.debug("Cont 2.==========================");
		LOG.debug("Cont 2.=flag="+flag);
		LOG.debug("Cont 2.==========================");
		
		//3. message 처리
		MessageVO message = new MessageVO();
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("상태 변경 성공");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("상태 변경 실패");
		}
		LOG.debug("Cont 3.==========================");
		LOG.debug("Cont 3.=message="+message.getMsgMsg());
		LOG.debug("Cont 3.==========================");
		
		//4. Json 처리
		Gson gson = new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("Cont 4.==========================");
		LOG.debug("Cont 4.=jsonStr="+jsonStr);
		LOG.debug("Cont 4.==========================");
		
		return jsonStr;
	}
	
	
	@RequestMapping(value = "reserv/do_select_one.do", method = RequestMethod.GET)
	public String doSelectOne(ReservVO reservVO, Locale locale, Model model) {
		
		//1. param
		LOG.debug("Cont 1.==========================");
		LOG.debug("Cont 1.=param="+reservVO);
		LOG.debug("Cont 1.==========================");
		
		if(reservVO.getRno() == null || reservVO.getRno().equals("")) {
			throw new IllegalArgumentException("에약건을 확인하세요.");
		}
		
		//2. doSelectOne
		ReservVO outVO = (ReservVO) this.reservService.doSelectOne(reservVO);
		LOG.debug("Cont 2.==========================");
		LOG.debug("Cont 2.=outVO="+outVO);
		LOG.debug("Cont 2.==========================");
		
		//3. addAttribute
		model.addAttribute("vo", outVO);
		
		String url = "";
		
		return url;
	}
}
