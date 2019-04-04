package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.DeptVO;
import com.biz.iolist.service.DeptService;
/*
 * 거래처 관리 컨트롤러
 */

@SessionAttributes("deptVO")
@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptService deptService;

	// deptVO SessionAttribute를 생성할 초기화 method를 만든다.
	// Session에 deptVO가 아예 없거나 내용이 제거 되었을 경우 실행되어서 
	// deptVO를 새로 만들어 주는 method
	@ModelAttribute("deptVO")
	public DeptVO newDeptVO() {
		
		DeptVO deptVO = new DeptVO();
		return deptVO;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<DeptVO> deptList = deptService.selectAll();
		
		model.addAttribute("LIST", deptList);
		model.addAttribute("BODY", "D_LIST");
		return "home";
		
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("deptVO") DeptVO deptVO, Model model) {
		
		model.addAttribute("deptVO", deptVO);
		model.addAttribute("BODY", "D_WRITE");
		return "home";
		
	}
	
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute ("DeptVO")DeptVO deptVO, Model model, SessionStatus session) {

		// TODO insert 테스트 케이스
		// deptService 클래스의 insert method를 수행 
		// 조건 : deptVO 객체를 매개변수로 전달하고
		// 결과 : tbl_dept 테이블에 해당 데이터가 저장되도록 한다.
		int ret = deptService.insert(deptVO);
		
		if(ret > 0) { // 정상적으로 insert가 수행되었다
			session.setComplete(); // 세션삭제
			return "redirect:/dept/list";
		}else {
			// insert가 정상적으로 수행되지 않으면 다시 입력 폼으로 되돌아간다.
			model.addAttribute("deptVO", deptVO);
			model.addAttribute("BODY", "D_WRITE");
			return "home";
		}
		
		
//		model.addAttribute("MSG", "데이터 추가 성공");
//		return "home";
		
	
	}
	
	
}
