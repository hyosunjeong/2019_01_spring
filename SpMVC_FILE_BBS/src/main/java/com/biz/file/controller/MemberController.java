package com.biz.file.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;
import com.biz.file.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/*
 * Controller에 Requestmapping을 설정하면
 * 페이지를 호출할 주소를 그룹으로 묶어서 관리할 수 있다.
 * 단, Mapping 주소앞에 반드시 /로 시작해야 한다.
 */
@Controller
@RequestMapping("/member")
/*
 * @SessionAttributes는 @ModelAttribute로 선언된 객체를
 * Session 정보안에 포함시켜서 
 * 서로 다른 method에서 값을 참조할 수 있도록 도와주는 지시어
 * 
 * memberVO를 sessionAttribute에 추가함으로써 
 * member 정보의 update를 쉽게 처리할 수 있다.
 * 
 */
@Slf4j
@SessionAttributes({"memberVO"})
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	/*
	 * 위의 @Autowired는 MemberService Interface로 선언이 되고
	 * MemberServiceImp 클래스로 초기화 된다.
	 
		public MemberService mService() {
			return new MemberServiceImp();
		}
		
	*/
	
	/*
	 * 이 컨트롤러 내에 있는 어떤 method에서 
	 * @ModelAttribute("memberVO")라는 코드가 있는데
	 * memberVO라는 객체가 혹시 생성이 안되어서 
	 * null 값이면 해당 객체를 생성(new)해서 사용가능한 상태로 만들어라 라고하는 지시어
	 */
	@ModelAttribute("memberVO")
	public MemberVO newMemberVO() {
		// return new MemberVO();
		MemberVO vo = new MemberVO();
		// vo.setM_userid("test");
		return vo;
	}
	
	// form을 열기 위한 method
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") MemberVO memberVO, Model model, SessionStatus session) {
		
		session.setComplete();
		model.addAttribute("BODY","JOIN_FORM");
		return "home";
	}
	
	// form에서 데이터를 받기 위한 method
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute("memberVO") @Valid MemberVO memberVO, BindingResult result, Model model, SessionStatus session) {
		
		// vo에 설정된 contraint 조건에 위배된 값이 form으로 부터 
		// 전송되어 오면 hasErrors()는 true를 갖고
		// 조건에 맞는 값이 오면 false를 갖게 된다.
		
		if(result.hasErrors()) {
			log.debug("HasError");
			model.addAttribute("BODY", "JOIN_FORM");
			return "home";
		}else {
			
			// 새로운 회원이면 insert를 수행하고
			// 기존 회원이면 update를 수행해야한다.
			
			int ret = mService.save(memberVO);
			
			// mService.insert(memberVO);
			
			// 가입이 완료된 후 자동으로 로그인이 되지 않도록
			// 회원가입 정책을 설정한다.
			session.setComplete(); // 가입이 완료된 후 memberVO를 session으로 부터 제거하라

			log.debug("No Error");
			
			return "redirect:/";
			// redirect member/join으로 대신 엔터를 쳐줘라?
			// redirect 하면 controller에게 값을 넘기기가 어려움
			
		}
		
	}
	
	
	@RequestMapping(value="/join1",method=RequestMethod.GET)
	public String join(Model model) {
		
		// memberVO를 생성해서
		// form:form tag로 이루어진 폼에 비어있는 데이터를 덫씌워서 
		// 새로 작성하는 화면으로 구성
		MemberVO vo = new MemberVO();
		model.addAttribute("memberVO",vo);
		
		return "body/join_form";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.GET)
	public String join() {
		
		return "body/join_form";
	}
	
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String my_page(
			@ModelAttribute("memberVO") MemberVO memberVO,
			Model model,
			HttpSession session) {
		
		model.addAttribute("memberVO", (MemberVO)session.getAttribute("login_info"));
		model.addAttribute("ACTION", "UPDATE");
		model.addAttribute("BODY", "JOIN_FORM");
		
		return "home";
		
	}
}
