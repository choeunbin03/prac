package com.board.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.SptInqCntDTO;
import com.board.service.SptInqCntService;

@Controller
@RequestMapping(value="/sptInqCnt/*")
public class SptInqCntController {
	
	@Inject
	private SptInqCntService sptInqCntService;
	
	@ResponseBody
	@RequestMapping(value="/insertBbsSpt", method=RequestMethod.POST)
	public String updateBbsSpt(Locale locale, Model model, HttpServletRequest request) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("bbsSeq", Integer.parseInt((String)request.getParameter("bbsSeq")));
		param.put("mbrId", "aaa");
		sptInqCntService.insertBbsSpt(param);

		return "reload";
	}
}
