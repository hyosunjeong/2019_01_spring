package com.biz.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.model.EmsVO;
import com.biz.email.service.SaveService;

@Controller
public class SaveController {
	
	@Autowired
	SaveService sService;
	
	/*
	 * form에서 저장을 하면 input tag에 입력된 내용은 EmsVO가 받고
	 * file tag에서 선택된 파일정보는 files가 받는다.
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(@ModelAttribute EmsVO emsVO, MultipartHttpServletRequest files) {
		
		sService.save(emsVO,files);
		return "redirect:/"; // 리스트보기로 가기
		
	}
}
