package com.sist.d_dolive.reservation.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.sist.d_dolive.cmn.MessageVO;
import com.sist.d_dolive.reservation.ReservService;
import com.sist.d_dolive.reservation.ReservVO;

public class ReservCont {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReservService reservService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String doInsert(ReservVO reserv, Locale locale) {

		LOG.debug("Cont 1.==========================");
		LOG.debug("Cont 1.=param="+reserv);
		LOG.debug("Cont 1.==========================");
		
		//TODO 다국어 메시지 처리
		
		int flag = this.reservService.doInsert(reserv);
		LOG.debug("Cont 2.==========================");
		LOG.debug("Cont 2.=flag="+flag);
		LOG.debug("Cont 2.==========================");
		
		//3. Message 처리
		MessageVO message = new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("예약 성공");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("예약 실패");
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
}
