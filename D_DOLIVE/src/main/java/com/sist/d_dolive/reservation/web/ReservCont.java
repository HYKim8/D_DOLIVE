package com.sist.d_dolive.reservation.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.sist.d_dolive.reservation.ReservService;
import com.sist.d_dolive.reservation.ReservVO;

public class ReservCont {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReservService reservService;
	
	@Autowired
	MessageSource messageSource;
	
	public String doInsert(ReservVO reserv, Locale locale) {
		String a = null;
		return a;
	}
}
