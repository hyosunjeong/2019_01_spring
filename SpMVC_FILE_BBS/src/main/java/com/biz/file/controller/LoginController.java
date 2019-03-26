package com.biz.file.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;
import com.biz.file.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * JAVA DOCS : 개발이 완료되고 문서화를 시킬 때
 * 문서화 Tools를 활용할 수 있도록 작성하는 주석
 * 
 * @author : 컴퓨터 사용자 이름이 자동으로 생성됨
 * @since : 2019-03-01
 * @see : 이 컨트롤러는 사용자 로그인, 로그아웃을 처리하기 위한 파일
 * @
 */

/*
 * sessionAttributes를 사용한 login을 HttpSession으로 변경
 */
@Slf4j
@Controller
@SessionAttributes({"memberVO"})
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService lService;
	
	/*
	 * @ModelAttribute로 login_info를 선언하고
	 * @login_info 초기화 method
	 */
	@ModelAttribute("memberVO")
	public MemberVO login_info() {
		log.debug("NEW memberVO");
		return new MemberVO(); 
	}
	
	/**
	 * 	
	 * @param memberVO
	 * @param model
	 * @param session
	 * @param s
	 * @return
	 * @see 로그인 폼을 싱행하는 method
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(
			@RequestParam(required=false) String LOGIN_MSG,
			@ModelAttribute MemberVO memberVO, Model model) {
		
		log.debug("LOGIN:"+memberVO.toString());
		log.debug("LOGIN MSG:"+LOGIN_MSG);
		model.addAttribute("LOGIN_MSG", LOGIN_MSG);
		model.addAttribute("BODY", "LOGIN_FORM");
		return "home";
	}
	
	/*
	 * @ModelAttribute만 사용하면 지정된 객체가 실제 이름이 된다.
	 * Controller에서 form으로 부터 데이터를 받는 용도로만 사용할 때는
	 * 아무런 문제가 없다.
	 * 
	 * 하지만 지금 프로젝트에서는 memberVO 객체를 
	 * Controller와 view(jsp)에서 공유해서 사용하고 있다.
	 * 
	 * 이럴때는 반드시 이름을 강제로 지정해주는것이 좋다.
	 * 예) @ModelAttribute("login_info")
	 * 
	 * 이제 login() method에서 제어권이 다른곳으로 이동되는 순간
	 * memberVO는 마치 이름이 login_info로 바뀌는 것과 같다.
	 * 
	 */
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO, Model model, HttpSession session) {

		// 만약 정상적인 로그인이면 vo에 member 정보가 있고
		// 그렇지 않으면 null이 있다.
		MemberVO vo = lService.getMemberInfo(memberVO);
		if(vo != null) {
			
		/*
		 * 기존에 sessionAttribute에 담았던 login_info를 
		 * HttpSession으로 분리
		 */
			session.setAttribute("login_info",vo);
			log.debug(memberVO.toString());
		}else {
			// 로그인 method가 호출되면
			// member의 로그인 관련 정보가 정상이 아니라도
			// session이 이미 시작되어 버린다.
			// 그래서 
			// 로그인에 실패했으면 session 정보를 반드시 지워줘야 안전하다.
			session.removeAttribute("login_info");
		}
		return "redirect:/"; 
	}

	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(@ModelAttribute MemberVO memberVO,HttpSession session, SessionStatus status) {
		log.debug("LOGOUT"); 
		//session을 제거
		// session완료, 만료 되었다 라고 표현
		session.removeAttribute("login_info");
		status.setComplete();
		return "redirect:/";
	}
}

/*
 * 로그인 정보를 sessionAttribute에서 뽑아내는 이유
 * 세션어트리뷰트는 폼과 연계해서 쉬운 업데이트를 위한 도구이다
 * 
 * 선택적으로 세션을 삭제하지 못하는 단점이 있다.
 * 한번 세션어트리뷰트를 삭제하면 모든 세션이 삭제된다.
 * 
 * 그래서 로그인정보만 httpAttribute로 뽑아낸다.
 * 
 */
