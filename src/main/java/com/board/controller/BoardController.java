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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.BbsSrchDTO;
import com.board.domain.BoardDTO;
import com.board.domain.CmntDTO;
import com.board.domain.PageDTO;
import com.board.service.BoardService;
import com.board.service.BookmarkService;
import com.board.service.CmntService;
import com.board.service.SptInqCntService;
import com.board.comm.Util;



@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String ATCH_FILE_NM = ":D\\PJ\\JSP_T02\\bbs_atchFile";
	
	@Inject
	private BoardService boardService;
	@Inject
	private CmntService cmntService;
	@Inject
	private SptInqCntService sptInqCntService;
	@Inject
	private BookmarkService bookmarkService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Locale locale, Model model, HttpServletRequest request, HttpSession session) throws Exception{
		String mbrId = (String)session.getAttribute("sessionId");
		List bmkList = bookmarkService.getBmkList(mbrId);
		model.addAttribute("bmkList", bmkList);
		
		int pageNum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum")!= null && request.getParameter("amount")!= null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}//페이징
		
		PageDTO pageDto = new PageDTO();
		int strtIndx = amount * (pageNum - 1);
		pageDto.setStrtIndx(strtIndx);
		pageDto.setAmount(amount);
		
		List list = boardService.list(pageDto);
		
		int total = boardService.getTotal();
		pageDto.setTotal(total);
		
		model.addAttribute("list", list);
		request.setAttribute("pageDto", pageDto);
		
		
		return "/board/list";
	}
	
	@RequestMapping(value="/regiView", method=RequestMethod.GET)
	public String regiView(Locale locale, Model model) throws Exception{
		return "/board/regi";
	}
	
	@ResponseBody
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Locale locale, Model model, BoardDTO dto) throws Exception{
		int result = -1;
		
		result = boardService.regi(dto);
		
		if(result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	private void viewCountUp(String mbrId, int bbsSeq, HttpServletRequest req, HttpServletResponse res) {

        Cookie oldCookie = null;
        //Map<String, Object> params = new HashMap<String, Object>();
        //params.put("bbsSeq", bbsSeq);
        //params.put("mbrId", mbrId);

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
        	
        	
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("boardView")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
        	logger.info("boardView Value.{}", oldCookie.getValue());
        	
            if (!oldCookie.getValue().contains("[" + mbrId.toString() + "]")) {
            	//sptInqCntService.insertBbsInqCnt(params);
            	boardService.updateBbsInqCnt(bbsSeq);
                oldCookie.setValue(oldCookie.getValue() + "_[" + mbrId + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                res.addCookie(oldCookie);
            }else {
            	//Date mdfrDt = boardService.checkBbsInqCnt(Params);
            	//Date nowDate = new Date();
            	
            	
            }
        } else {
        	//sptInqCntService.insertBbsInqCnt(params);
        	boardService.updateBbsInqCnt(bbsSeq);
            Cookie newCookie = new Cookie("boardView","[" + mbrId + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            res.addCookie(newCookie);
        }
    }
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		String mbrId = (String)session.getAttribute("sessionId");
		int bbsSeq = Integer.parseInt((String)request.getParameter("bbsSeq"));
		viewCountUp(mbrId, bbsSeq, request, response);
		
		//boardService.updateBbsInqCnt(Integer.parseInt((String)request.getParameter("bbsSeq")));
		BoardDTO boardDto = boardService.view(bbsSeq);
		Util.prtParams(request);
		
		CmntDTO cmntDTO = new CmntDTO();
		cmntDTO.setBbsSeq(boardDto.getBbsSeq());
		
		
		List cmntList = cmntService.list(cmntDTO);
		
		model.addAttribute("view", boardDto);
		model.addAttribute("cmnt", cmntList);
		return "/board/view";
	}
	
	@RequestMapping(value="/goUpdateView", method=RequestMethod.POST)
	public String updateView(Locale locale, Model model, HttpServletRequest request) throws Exception{
		BoardDTO dto = boardService.view(Integer.parseInt((String)request.getParameter("bbsSeq")));
		model.addAttribute("view", dto);
		return "/board/update";
	}
	

	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Locale locale, Model model, BoardDTO dto) throws Exception{
		
		int result = boardService.update(dto);
		if( result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(Locale locale, Model model, HttpServletRequest request) throws Exception{
		if(boardService.delete(Integer.parseInt((String)request.getParameter("bbsSeq"))) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateBbsSpt", method=RequestMethod.POST) 
	public String updateBbsSpt(Locale locale, Model model, HttpServletRequest request, HttpSession session) throws Exception{ 
		
		int bbsSeq = Integer.parseInt((String)request.getParameter("bbsSeq"));
		String mbrId = (String)session.getAttribute("sessionId");
		String bbsSptYn = "";
		String result = "";
		BoardDTO boardDto;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bbsSeq", bbsSeq);
		params.put("mbrId", mbrId);
		
		bbsSptYn = boardService.checkBbsSptYn(params);
		
		if(!"Y".equals(bbsSptYn)) {
			boardService.updateBbsSpt(bbsSeq);
			sptInqCntService.insertBbsSpt(params);
		}
		
		return "reload";
	}
	
	@RequestMapping(value="/bbsSrch", method=RequestMethod.GET)
	public String bbsSrch(Locale locale, Model model, HttpServletRequest request) throws Exception{
		
		List list;
//		String rgtrId = request.getParameter("rgtrId");
//		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String keyWd = request.getParameter("keyWd");
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		if(type != null) {
			param.put(type, keyWd);
		}else {
			logger.info("다시 검색");
		}

		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
//		if(request.getParameter("pageNum")!= null && request.getParameter("amount")!= null) {
//			pageNum = Integer.parseInt(request.getParameter("pageNum"));
//			amount = Integer.parseInt(request.getParameter("amount"));
//		}//페이징
		
		
		BbsSrchDTO bbsSrchDTO = new BbsSrchDTO();
		bbsSrchDTO.setKeyWd(keyWd);
		/*
		 * PageDTO pageDto = new PageDTO(pageNum, amount, total);
		 */		
		PageDTO pageDto = new PageDTO();
		int strtIndx = amount * (pageNum - 1);
		pageDto.setStrtIndx(strtIndx);
		pageDto.setAmount(amount);
		
		//.put(param, pageDto);
		param.put("pageDto", pageDto);
		
		list = boardService.bbsSrch(param);
		
		//int total = list.size();
		int total = boardService.getTotal(param);
		pageDto.setTotal(total);
		
		model.addAttribute("list", list);
		request.setAttribute("bbsSrchDTO", bbsSrchDTO);
		request.setAttribute("pageDto", pageDto);

		return "/board/list";
	}
	
	 
}
