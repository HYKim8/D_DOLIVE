package com.sist.d_dolive.reservation.web;

import java.util.List;
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
import com.sist.d_dolive.bizmember.BizMemberVO;
import com.sist.d_dolive.cmn.MessageVO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.cmn.StringUtil;
import com.sist.d_dolive.code.CodeService;
import com.sist.d_dolive.code.CodeVO;
import com.sist.d_dolive.member.MemberVO;
import com.sist.d_dolive.pharmacy.PharmacyVO;
import com.sist.d_dolive.reservation.ReservService;
import com.sist.d_dolive.reservation.ReservVO;

@Controller
public class ReservCont {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReservService reservService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value = "reserv/do_retrieve.do", method = RequestMethod.GET)
	public String doRetrieve(SearchVO search, Model model, HttpSession session) {
		//param 기본값 처리
		if(search.getPageNum() == 0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize() == 0) {
			search.setPageSize(10);
		}
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		
		if(search.getOptionDiv().equals("1")) {
			MemberVO memberVO = (MemberVO) session.getAttribute("member");
			search.setSearchWord(StringUtil.nvl(memberVO.getEmail()));
		}else if(search.getOptionDiv().equals("2")) {
			BizMemberVO bizMemberVO = (BizMemberVO) session.getAttribute("bizMember");
			search.setSearchWord(StringUtil.nvl(bizMemberVO.getPcode()));
		}
		
		LOG.debug("1==================");
		LOG.debug("1=param="+search);
		LOG.debug("1==================");
		
		//검색 조건 화면으로 전달
		model.addAttribute("vo", search);
		
		//TODO: codeTable : 검색 조건, 페이지 사이즈
		CodeVO code = new CodeVO();
		
		//검색 조건
		code.setCodeTypeId("APPROVAL");
		List<CodeVO> searchList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=searchList="+searchList);
		model.addAttribute("searchList", searchList);
		
		//페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PAGE_SIZE");
		List<CodeVO> pageSizeList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.2=pageSizeList="+pageSizeList);
		model.addAttribute("pageSizeList", pageSizeList);
		
		List<ReservVO> list = (List<ReservVO>) this.reservService.doRetrieve(search);
	
		//조회 결과 화면 전달
		model.addAttribute("list", list);
		
		for(ReservVO vo : list) {
			LOG.debug("1.1=out="+vo);
		}
		
		//총건수
		int totalCnt = 0;
		if(null!=list && list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		LOG.debug("1.2==================");
		LOG.debug("1.2=totalCnt="+totalCnt);
		LOG.debug("1.2==================");

		//조회 결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		
		String url = "";
		
		if(search.getOptionDiv().equals("1")) {
			url = "member/member_reservation";
		}else if(search.getOptionDiv().equals("2")) {
			url = "bizmember/bizmember_reservation";
		}
		
		return url;
	}
	
	@RequestMapping(value = "reserv/do_insert.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(ReservVO reservVO, Locale locale, HttpSession session) {
		
		//1. param
		LOG.debug("Cont 1.==========================");
		LOG.debug("Cont 1.=param="+reservVO);
		LOG.debug("Cont 1.==========================");
		
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		reservVO.setRegId(memberVO.getEmail());
		
		//2. doInsert
		int flag = this.reservService.doInsert(reservVO);
		LOG.debug("Cont 2.==========================");
		LOG.debug("Cont 2.=flag="+flag);
		LOG.debug("Cont 2.==========================");
		
		//3. message 처리
		MessageVO message = new MessageVO();
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("예약에 성공하였습니다.");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("예약에 실패했습니다.");
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
	public String doUpdate(ReservVO reservVO, Locale locale, HttpSession session) {
		
		//1. param
		LOG.debug("Cont 1.==========================");
		LOG.debug("Cont 1.=param="+reservVO);
		LOG.debug("Cont 1.==========================");
		
		if(reservVO.getApproval() == null || reservVO.getApproval().equals("")) {
			throw new IllegalArgumentException("예약건을 확인하세요.");
		}

		if(reservVO.getOptionDiv().equals("1")) {
			MemberVO memberVO = (MemberVO) session.getAttribute("member");
			reservVO.setModId(memberVO.getEmail());
		} else if(reservVO.getOptionDiv().equals("2")) {
			BizMemberVO bizMemberVO = (BizMemberVO) session.getAttribute("bizMember");
			reservVO.setModId(bizMemberVO.getEmail());
		}
		
		//2. doUpdate
		int flag = this.reservService.doUpdate(reservVO);
		LOG.debug("Cont 2.==========================");
		LOG.debug("Cont 2.=flag="+flag);
		LOG.debug("Cont 2.==========================");
		
		//3. message 처리
		MessageVO message = new MessageVO();
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("예약상태 변경에 성공하였습니다.");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("예약상태 변경에 실패하였습니다.");
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
			throw new IllegalArgumentException("예약건을 확인하세요.");
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
	
	@RequestMapping(value = "reserv/reserv_insert_page.do", method = RequestMethod.GET)
	public String goInsertPage(PharmacyVO vo, Model model) {
		LOG.debug("=아아아아아=");
		model.addAttribute("vo", vo);
		
		return "reserv/reserv_insert";
	}
}
