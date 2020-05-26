package com.sist.d_dolive.pharmarcy_map.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.d_dolive.bizmember.BizMemberService;
import com.sist.d_dolive.notice.NoticeService;

@Controller
public class ViewCont {
Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BizMemberService bizMemberService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value = "covidmap/sidomap.do", method = RequestMethod.GET)
	public String doSidomap() {
		//LOG.debug("=아아아아아=");
		
		
		return "covidmap/sidomap";
	}
	
	@RequestMapping(value = "countdown/count_down.do", method = RequestMethod.GET)
	public String doCountdown() {
		//LOG.debug("=아아아아아=");
		
		return "countdown/count_down";
	}
	
	@RequestMapping(value = "pharmacymap/main.do", method = RequestMethod.GET)
	public String doSelectTwo() {
		//LOG.debug("=아아아아아=");
		
		return "pharmacymap/main";
	}
	
	@RequestMapping(value = "pharmacymap/pharmacy_map.do", method = RequestMethod.GET)
	public String doStart(HttpServletRequest req, HttpServletResponse res) {
		//LOG.debug("=아아아아아=");
		String p_address = req.getParameter("p_address");
		LOG.debug("p_address="+p_address);
		req.setAttribute("p_address", p_address);
		return "pharmacymap/pharmacy_map";
	}
}
