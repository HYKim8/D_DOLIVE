/**
 * 
 */
package com.sist.d_dolive.iamport.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.sist.d_dolive.cmn.MessageVO;

/**
 * @author sist
 *
 */
@Controller
public class IamportCancel {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "iamport/do_cancel.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String cancelPaymentAlreadyCancelledImpUid(HttpServletRequest req) {
		LOG.debug("==========");
		LOG.debug("=asd=");
		LOG.debug("==========");
		
		String test_api_key = "imp_apikey";
		String test_api_secret = "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f";
		
		IamportClient client = new IamportClient(test_api_key, test_api_secret);
		
		String test_already_cancelled_imp_uid = req.getParameter("imp_uid");
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소
		
		try {
			IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		} catch (IamportResponseException e) {
			LOG.debug(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(1));
		message.setMsgMsg("환불 성공했습니다.");
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(message);
		LOG.debug("2==================");
		LOG.debug("2=gsonStr="+gsonStr);
		LOG.debug("2==================");
		
		return gsonStr;
	}
}
