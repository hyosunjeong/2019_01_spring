package com.biz.iolist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.IolistVO;
import com.biz.iolist.service.IolistService;

/*
 * 매입매출 컨트롤러
 */

@SessionAttributes("iolistVO")
@Controller
@RequestMapping("/iolist")
public class IolistController {
	
	@Autowired
	IolistService ioService;
	
	@ModelAttribute("iolistVO")
	public IolistVO newIolistVO() {
		
		IolistVO vo = new IolistVO();
		LocalDateTime lt = LocalDateTime.now();
		
		DateTimeFormatter fdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		DateTimeFormatter ftime = DateTimeFormatter.ofPattern("HH:mm:ss");
		vo.setIo_date(fdate.format(lt));
		vo.setIo_time(ftime.format(lt));
		
		return vo; 
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<IolistVO> io_List = ioService.selectAll();
		
		model.addAttribute("LIST", io_List);		
		model.addAttribute("BODY", "IO_LIST");
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("iolistVO") IolistVO iolistVO, Model model) {
		
		model.addAttribute("iolistVO", iolistVO);
		model.addAttribute("BODY", "IO_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("iolistVO") IolistVO iolistVO, Model model, SessionStatus session) {

		
		int ret = ioService.insert(iolistVO);
		if(ret > 0) {
			session.setComplete(); // 세션삭제
			return "redirect:/iolist/list";
		}else {
			model.addAttribute("iolistVO", iolistVO);
			model.addAttribute("BODY", "IO_WRITE");
			return "home";
		}
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@ModelAttribute("iolistVO")IolistVO iolistVO, Model model) {
		
		long io_id = iolistVO.getIo_id();
		iolistVO = ioService.findByID(io_id);
		
		model.addAttribute("iolistVO", iolistVO);
		
		model.addAttribute("BODY", "IO_WRITE");
		
		
		return "home";
		
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("iolistVO")IolistVO iolistVO, Model model, SessionStatus session) {
	
		int ret = ioService.update(iolistVO);
		
		return "redirect:/iolist/list";
	}
	
	
}
