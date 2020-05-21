/**
 * 
 */
package com.sist.d_dolive.pharmacy.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.d_dolive.cmn.SearchVO;
import com.sist.d_dolive.cmn.StringUtil;
import com.sist.d_dolive.code.CodeService;
import com.sist.d_dolive.code.CodeVO;
import com.sist.d_dolive.notice.NoticeVO;
import com.sist.d_dolive.pharmacy.PharmacyService;
import com.sist.d_dolive.pharmacy.PharmacyVO;

/**
 * @author sist
 *
 */
@Controller
public class PharmacyCont {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PharmacyService pharmacyService;
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "pharmacy/do_retrieve.do", method = RequestMethod.GET)
	public String doRetrieve(SearchVO search, Model model) {
		//param 기본값 처리
		if(search.getPageNum() == 0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize() == 0) {
			search.setPageSize(10);
		}
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		LOG.debug("1==================");
		LOG.debug("1=param="+search);
		LOG.debug("1==================");
		
		//검색 조건 화면으로 전달
		model.addAttribute("vo", search);
		
		//TODO: codeTable : 검색 조건, 페이지 사이즈
		CodeVO code = new CodeVO();
		
		//페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PHARMACY_SEARCH");
		List<CodeVO> pharmacySearch = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.2=pharmacySearch="+pharmacySearch);
		model.addAttribute("pharmacySearch", pharmacySearch);
		
		List<PharmacyVO> list = (List<PharmacyVO>) this.pharmacyService.doRetrieve(search);
	
		//조회 결과 화면 전달
		model.addAttribute("list", list);
		
		for(PharmacyVO vo : list) {
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
		
		return "pharmacy/pharmacy_list";
	}
}
