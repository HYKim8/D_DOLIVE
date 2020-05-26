/**
 * 
 */
package com.sist.d_dolive.notice.web;

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
import com.sist.d_dolive.cmn.MessageVO;
import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.cmn.StringUtil;
import com.sist.d_dolive.notice.NoticeService;
import com.sist.d_dolive.notice.NoticeVO;
import com.sist.d_dolive.code.CodeVO;
import com.sist.d_dolive.member.MemberVO;
import com.sist.d_dolive.code.CodeService;

/**
 * @author sist
 *
 */
@Controller
public class NoticeCont {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "notice/do_retrieve.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doRetrievePcode(SearchVO search, Model model, HttpSession session) {
		//param 기본값 처리
		if(search.getPageNum() == 0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize() == 0) {
			search.setPageSize(10);
		}
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		search.setSearchWord(StringUtil.nvl(memberVO.getEmail()));
		LOG.debug("1==================");
		LOG.debug("1=param="+search);
		LOG.debug("1==================");
		
		List<NoticeVO> list = (List<NoticeVO>) this.noticeService.doRetrieve(search);
	
		for(NoticeVO vo : list) {
			LOG.debug("1.1=out="+vo);
		}
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(list);
		LOG.debug("2==================");
		LOG.debug("2=gsonStr="+gsonStr);
		LOG.debug("2==================");
		
		return gsonStr;
	}
	
	@RequestMapping(value = "notice/do_retrieve.do", method = RequestMethod.GET)
	public String doRetrieve(SearchVO search, Model model, HttpSession session) {
		//param 기본값 처리
		if(search.getPageNum() == 0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize() == 0) {
			search.setPageSize(10);
		}
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		search.setSearchWord(StringUtil.nvl(memberVO.getEmail()));
		LOG.debug("1==================");
		LOG.debug("1=param="+search);
		LOG.debug("1==================");
		
		//검색 조건 화면으로 전달
		model.addAttribute("vo", search);
		
		//TODO: codeTable : 검색 조건, 페이지 사이즈
		CodeVO code = new CodeVO();
		
		//페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PAGE_SIZE");
		List<CodeVO> pageSizeList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.2=pageSizeList="+pageSizeList);
		model.addAttribute("pageSizeList", pageSizeList);
		
		List<NoticeVO> list = (List<NoticeVO>) this.noticeService.doRetrieve(search);
	
		//조회 결과 화면 전달
		model.addAttribute("list", list);
		
		for(NoticeVO vo : list) {
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
		
		return "notice/notice_list";
	}
	
	@RequestMapping(value = "notice/do_delete.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doDelete(NoticeVO noticeVO, Locale locale, HttpSession session) {
		//param board_id
		LOG.debug("1==================");
		LOG.debug("1=param="+noticeVO);
		LOG.debug("1==================");
		
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		noticeVO.setEmail(memberVO.getEmail());
		
		int flag = this.noticeService.doDelete(noticeVO);
		
		MessageVO message = new MessageVO();
		//삭제 성공
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 되었습니다.");
		//실패
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 실패.");
		}
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(message);
		LOG.debug("2==================");
		LOG.debug("2=gsonStr="+gsonStr);
		LOG.debug("2==================");
		
		return gsonStr;
	}
	
	@RequestMapping(value = "notice/do_insert.do", method = RequestMethod.POST
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(NoticeVO noticeVO, Locale locale, HttpSession session) {
		LOG.debug("1==================");
		LOG.debug("1=param="+noticeVO);
		LOG.debug("1==================");
		
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		noticeVO.setEmail(memberVO.getEmail());
		
		int flag = this.noticeService.doInsert(noticeVO);
		
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
	
	@RequestMapping(value = "notice/do_select_one.do", method = RequestMethod.GET
			, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doSelectOne(NoticeVO noticeVO, Locale locale, Model model) {
		//board_id
		LOG.debug("1==================");
		LOG.debug("1=param="+noticeVO);
		LOG.debug("1==================");
		
		if(null==noticeVO.getPcode() || noticeVO.getPcode().equals("")) {
			throw new IllegalArgumentException("Pcode를 확인 하세요.");
		}
		
		if(null==noticeVO.getEmail() || noticeVO.getEmail().equals("")) {
			throw new IllegalArgumentException("Email을 확인 하세요.");
		}
		
		NoticeVO outVO = (NoticeVO) this.noticeService.doSelectOne(noticeVO);
		LOG.debug("1.1==================");
		LOG.debug("1.1=outVO="+outVO);
		LOG.debug("1.1==================");
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(outVO);
		LOG.debug("1.2==================");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2==================");
		
		return jsonStr;
	}
	
	
}
