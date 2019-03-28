package com.biz.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.email.service.EmsService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	EmsService eService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		model.addAttribute("MAIL", eService.selectAll());

		return "home";
	}
	
	
	
	
}
