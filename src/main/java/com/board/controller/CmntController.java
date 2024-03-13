package com.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.comm.Util;
import com.board.domain.BoardDTO;
import com.board.domain.CmntDTO;
import com.board.service.BoardService;
import com.board.service.CmntService;

@Controller
@RequestMapping(value="comment/*")
public class CmntController {
	
	@Inject
	private BoardService boardService;
	@Inject
	private CmntService cmntService;
	
	@ResponseBody
	@RequestMapping(value="/regiCmnt", method=RequestMethod.POST)
	public String regi(Locale locale, Model model, CmntDTO cmntDto) throws Exception{
		
		int result;
		
		result = cmntService.regiCmnt(cmntDto);
		if( result == 1) {
			return "Y";
		}else {
			return "N";
		}
	}

}
