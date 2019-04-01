package com.biz.email.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.email.model.EmsVO;
import com.biz.email.service.EmsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		
		
		
		return "body/mail_write";
	}
	
	
	
	@RequestMapping(value="mail",method=RequestMethod.POST)
	public String email_insert(@ModelAttribute EmsVO emsVO,
//			BindingResult result,
			MultipartFile file1,MultipartFile file2) {

//		for( FieldError s : result.getFieldErrors()) {
//			log.debug("ERROR: " + s.toString());
//		}
		
		log.debug("EMAILVO : " + emsVO.toString());
		int ret = eService.insert(emsVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String email_update(@ModelAttribute EmsVO emsVO) {
		int ret = eService.update(emsVO);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(@ModelAttribute("emsVO") EmsVO emsVO, Model model) {
		
		long id = emsVO.getId();
		log.debug("id:"+id);
		emsVO = eService.findById(id);
		
		model.addAttribute("emsVO", emsVO);
		
		return "body/mail_view";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam long id) {
		eService.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@ModelAttribute("emsVO")EmsVO emsVO, Model model) {
		long id = emsVO.getId();
		emsVO = eService.findById(id);
		
		model.addAttribute("MAIL", emsVO);
		
		return "body/mail_update";
	}

	
}
