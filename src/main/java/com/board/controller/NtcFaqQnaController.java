package com.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.BbsSrchDTO;
import com.board.domain.NtcFaqQnaDTO;
import com.board.domain.PageDTO;
import com.board.service.NtcFaqQnaService;
import com.board.comm.Util;

@Controller
@RequestMapping(value="/nfq/*")
public class NtcFaqQnaController {
	
private static final Logger logger = LoggerFactory.getLogger(NtcFaqQnaController.class);
	
	@Inject
	private NtcFaqQnaService ntcFaqQnaService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET) 
	public String list(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String result = null;
		Map<String, Object> param = new HashMap<String, Object>();
		int nfqType = Integer.parseInt(request.getParameter("nfqType"));
		param.put("nfqType", nfqType);
		
		int pageNum = 1; 
		int amount = 10; 
		int total = ntcFaqQnaService.getTotalByType(param);
	  
		if(request.getParameter("pageNum")!= null && request.getParameter("amount")!= null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
			amount = Integer.parseInt(request.getParameter("amount")); }//페이징
		  
		PageDTO pageDto = new PageDTO();
		int strtIndx = amount * (pageNum - 1);
		pageDto.setStrtIndx(strtIndx); 
		pageDto.setAmount(amount);
		param.put("pageDto", pageDto);
		
		List nfqList = ntcFaqQnaService.list(param);
		pageDto.setTotal(total);
		
		model.addAttribute("nfqList", nfqList);
		request.setAttribute("pageDto", pageDto);
		
		switch (nfqType) {
			case 1:	result = "/nfq/ntcList";
			break;
			case 2:	result = "/nfq/faqList";
			break;
			case 3:	result = "/nfq/qnaList";
			break;
		default:
			break;
		}
		return result;
	}
	
	@RequestMapping(value="/regiView", method=RequestMethod.GET)
	public String regiView(Locale locale, Model model, HttpServletRequest request) throws Exception{
		String result = null;
		String nfqType = (request.getParameter("nfqType")).toString();
		switch (nfqType) {
			case "1":	result = "/nfq/regiNtc";
			break;
			case "2":	result = "/nfq/regiFaq";
			break;
			case "3":	result = "/nfq/regiQstn";
			break;
		default:
			break;
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Locale locale, Model model, NtcFaqQnaDTO dto) throws Exception{
		int result = -1;
		
		result = ntcFaqQnaService.regi(dto);
		
		if(result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value="/view/*", method=RequestMethod.POST)
	public String view(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		String result;
		String mbrId = (String)session.getAttribute("sessionId");
		int nfqSeq = Integer.parseInt((String)request.getParameter("nfqSeq"));
		
		NtcFaqQnaDTO nfqDto = ntcFaqQnaService.view(nfqSeq);
		Util.prtParams(request);
		int nfqType = nfqDto.getNfqType();
		
		switch (nfqType) {
			case 1:	result = "/nfq/ntcView";
			break;
			case 2:	result = "/nfq/faqView";
			break;
			case 3:	result = "/nfq/qnaView";
			break;
		default:	result = null;
			break;
		}
		
		model.addAttribute("view", nfqDto);
		
		return result;//수정해서 사용
	}
	
	@RequestMapping(value="/goUpdateView", method=RequestMethod.GET)
	public String updateView(Locale locale, Model model, HttpServletRequest request) throws Exception{
		NtcFaqQnaDTO dto = ntcFaqQnaService.view(Integer.parseInt((String)request.getParameter("nfqSeq")));
		model.addAttribute("view", dto);
		return "/nfq/update";
	}
	

	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Locale locale, Model model, NtcFaqQnaDTO dto) throws Exception{
		
		int result = ntcFaqQnaService.update(dto);
		if( result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(Locale locale, Model model, HttpServletRequest request) throws Exception{
		int result = ntcFaqQnaService.delete(Integer.parseInt(request.getParameter("nfqSeq")));
		if(result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value="/nfqSrch", method=RequestMethod.POST)
	public String nfqSrch(Locale locale, Model model, HttpServletRequest request) throws Exception{
		
		List list;
		String rgtrId = request.getParameter("rgtrId");
		String title = request.getParameter("title");
		String keyWd = request.getParameter("keyWd");
		Map<String, Object> param = new HashMap<String, Object>();
		
		if (rgtrId != null) {
			param.put("rgtrId", rgtrId);
		} else if ( title != null) {
			param.put("title", title);
		} else {
			logger.info("다시 검색");
		}
		System.out.println(param);
		System.out.println("rrr");
		

		Map<Map, PageDTO> aa = new HashMap<Map, PageDTO>();
		
		int pageNum = 1;
		int amount = 10;
		
		
		if(request.getParameter("pageNum")!= null && request.getParameter("amount")!= null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}//페이징
		
		
		BbsSrchDTO srchDTO = new BbsSrchDTO();
		PageDTO pageDto = new PageDTO();
		int strtIndx = amount * (pageNum - 1);
		pageDto.setStrtIndx(strtIndx);
		pageDto.setAmount(amount);
		
		//.put(param, pageDto);
		param.put("pageDto", pageDto);
		
		list = ntcFaqQnaService.nfqSrch(param);
		int total = list.size();
		pageDto.setTotal(total);
		
		model.addAttribute("list", list);
		request.setAttribute("nfqSrchDTO", srchDTO);
		request.setAttribute("pageDto", pageDto);

		return "/nfq/list";
	}
	
	@RequestMapping(value="/nfqMng", method=RequestMethod.GET)
	public String nfqMng(Locale locale, Model model, HttpServletRequest request) throws Exception{
		
		int pageNum = 1; 
		int amount = 10; 
	  
		if(request.getParameter("pageNum")!= null && request.getParameter("amount")!= null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
			amount = Integer.parseInt(request.getParameter("amount")); }//페이징
		  
		PageDTO pageDto = new PageDTO();
		int strtIndx = amount * (pageNum - 1);
		pageDto.setStrtIndx(strtIndx); 
		pageDto.setAmount(amount);
		
		List mngList = ntcFaqQnaService.mngList(pageDto);
		int total = mngList.size();
		pageDto.setTotal(total);
		
		model.addAttribute("mngList", mngList);
		request.setAttribute("pageDto", pageDto);
		
		return "/nfq/nfqMng";
	}
	

}
