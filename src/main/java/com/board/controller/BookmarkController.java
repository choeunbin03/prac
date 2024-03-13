package com.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.BookmarkDTO;
import com.board.service.BookmarkService;

@Controller
public class BookmarkController {
		
	@Inject
	private BookmarkService bookmarkService;

	
	@ResponseBody
	@RequestMapping(value="/saveBookmark", method=RequestMethod.POST)
	public String regi(Locale locale, Model model, BookmarkDTO bookMarkDto, HttpSession session, HttpServletRequest request) throws Exception{
		String mbrId = (String)session.getAttribute("sessionId");
		bookMarkDto.setMbrId(mbrId);
		
		int result = -1;
		
		bookmarkService.saveBookmark(bookMarkDto);
		
		List bmkList = bookmarkService.list(bookMarkDto);
		
		model.addAttribute("bmkList", bmkList);
		
		return bookMarkDto.getBmkUrl();
		
	}
	
	@RequestMapping(value="/getBmkList", method=RequestMethod.GET)
	public void getBmkList(Locale locale, Model model, BookmarkDTO bookMarkDto, HttpSession session, HttpServletRequest request) throws Exception{
		String mbrId = (String)session.getAttribute("sessionId");
		int result = -1;
		
		List bmkList = bookmarkService.getBmkList(mbrId);
		
		model.addAttribute("bmkList", bmkList);
		
	}
	
}
