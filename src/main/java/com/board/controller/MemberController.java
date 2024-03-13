package com.board.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.MemberDTO;
import com.board.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "/member/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String regi(Locale locale, Model model, MemberDTO dto, HttpSession session)throws Exception{
		
		MemberDTO dto2 = service.login(dto);
		
		if(dto != null) {
			String loginMbrId = dto2.getMbrId();
			session.setAttribute("sessionId", loginMbrId);
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request)throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
	
		return "/member/login";
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String getJoin(Locale locale, Model model) throws Exception {
		return "/member/join";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String postJoin(Locale locale, Model model, MemberDTO memberDto) throws Exception {
		int result = -1;
		result = service.join(memberDto);
		
		if( result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
}
