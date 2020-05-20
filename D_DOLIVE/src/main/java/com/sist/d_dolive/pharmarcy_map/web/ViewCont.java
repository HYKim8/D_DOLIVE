package com.sist.d_dolive.pharmarcy_map.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.d_dolive.bizmember.BizMemberService;

@Controller
public class ViewCont {
Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BizMemberService bizMemberService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "covidmap/sidomap.do", method = RequestMethod.GET)
	public String doSelectOne() {
		LOG.debug("=아아아아아=");
		
		
		return "covidmap/sidomap";
	}
	
	@RequestMapping(value = "pharmacymap/main_test.do", method = RequestMethod.GET)
	public String doSelectTwo() {
		LOG.debug("=아아아아아=");
		
		return "pharmacymap/main_test";
	}
	
	@RequestMapping(value = "pharmacymap/pharmacy_map_test.do", method = RequestMethod.GET)
	public String doStart() {
		LOG.debug("=아아아아아=");
		
		return "pharmacymap/pharmacy_map_test";
	}
}
