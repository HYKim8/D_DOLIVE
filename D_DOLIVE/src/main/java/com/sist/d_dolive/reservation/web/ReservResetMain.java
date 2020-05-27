package com.sist.d_dolive.reservation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.d_dolive.reservation.ReservVO;
import com.sist.d_dolive.reservation.imple.ReservDaoImple;

@Component
public class ReservResetMain {
	private static final String[] SPRING_CONFIG_XML = new String[] {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
            "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"};

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_XML);
		System.out.println("ReservResetMain");
		System.out.println("ctx:"+ctx);
		System.out.println("ReservResetMain");
		ReservResetMain main = ctx.getBean(ReservResetMain.class);
		main.start();
	}
	
	@Autowired
	private ReservDaoImple reservDaoImple;
	
	private void start() {
		ReservVO reservVO = new ReservVO();
		System.out.println("reservDaoImple:"+reservDaoImple);
		reservVO.setSearchDiv("20");
		reservVO.setModId("SYSTEM");
		reservVO.setImpuid("0");
		reservDaoImple.doUpdate(reservVO);
	}

}
