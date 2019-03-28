package com.biz.email.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.email.model.EmsVO;
import com.biz.email.service.EmsService;

@Controller
public class EmsController {
	
	@Autowired
	EmsService eService;
	
	@ModelAttribute("emsVO")
	public EmsVO newEmsVO() {
		return new EmsVO();
	}
	
	
	/*
	 * home.jsp에서 #btn-mail(메일작성)을 클릭하면 실행되는 method
	 * 메일 보내기 화면으로 넘어감
	 */
	@RequestMapping(value="mail",method=RequestMethod.GET)
	public String email(Model model) {
		EmsVO emsVO = new EmsVO();
		
		LocalDateTime ld = LocalDateTime.now();
		DateTimeFormatter fd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		String today = ld.format(fd);
		String nt = ld.format(ft);
		
		emsVO.setS_date(today);
		emsVO.setS_time(nt);
		
		model.addAttribute("MAIL", emsVO);
		
		
		
		return "include/mail_write";
	}
	
	
	
	@RequestMapping(value="mail",method=RequestMethod.POST)
	public String email(@ModelAttribute EmsVO emsVO) {
		int ret = eService.insert(emsVO);
		return "include/mail_write";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@ModelAttribute("emsVO") EmsVO emsVO, Model model) {
		
		long id = emsVO.getId();
		emsVO = eService.findById(id);
		
		model.addAttribute("emsVO", emsVO);
		
		
		
		return "home";
	}
	
	
}
