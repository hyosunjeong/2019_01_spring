package com.biz.email.controller;

import java.time.LocalDate;

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
	
	@RequestMapping(value="mail",method=RequestMethod.GET)
	public String email(Model model) {
		EmsVO emsVO = new EmsVO();
		LocalDate ld = LocalDate.now();
		emsVO.setS_date(ld.toString());
		model.addAttribute("EMS", emsVO);
		
		return "include/mail_write";
	}
	
	@RequestMapping(value="mail",method=RequestMethod.POST)
	public String email(@ModelAttribute EmsVO emsVO) {
		int ret = eService.insert(emsVO);
		return "include/mail_write";
	}
	
	
	
	
	
	
	
}
