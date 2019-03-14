package com.biz.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.memo.model.MemberVO;
import com.biz.memo.service.MemberService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		return "bodys/join_form";
	}

	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO) {
		mService.insert(memberVO);
		return "redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping(value="id_check",
				method=RequestMethod.POST,
				produces="text/html;charset=utf8")
	public String user_id_check(@RequestParam String m_userid) {
		String ret = "" ;
		
		/*
		 * 만약 m_userid에 해당하는 member가 있을 경우는 
		 *	mService.id_check()메서드는 MemberVO를 return할 것이다
		 *
		 * 하지만 m_userid에 해당하는 member가 없으면
		 * 	mService.id_check() 메서드는 null을 return할 것이다.
		 * 
		 * 결국 m_userid가 table에 있으면 vo는 not null이 되고
		 *  없으면 null이 된다.	
		 */
		
		MemberVO vo = mService.id_check(m_userid);
		if(vo == null) { // id가 없으니 가입 가능
			ret = "사용가능한 아이디 입니다";
		} else {
			ret = " 이미 가입된 아이디 입니다 \n 아이디를 다시 입력해 주세요" ;
		}
		return ret;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "bodys/login_form";
	}
	
	
	/*
	 * login을 실행하거나 login과 관련된 method에서는 HttpSession 클래스를 매개변수로 선언해 둔다
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO, 
				HttpSession session,Model model) {
		
		List<MemberVO> retVO = mService.findByUserId(memberVO);
		// m_usrid로 조회를 한 후 List가 없으면 size를 0으로 return
		// 그렇지 않으면 size()>0값을 return한다
		
		log.debug(retVO.toString());
		if(retVO.size() > 0) { // 가입된 사용자 id이면 비밀번호 체크
			for(MemberVO vo : retVO) {
				if(vo.getM_password().equals(memberVO.getM_password())) {
					memberVO=vo;
					session.setAttribute("LOGIN_INFO", memberVO);
					// return "redirect:/";
					return null; // 강제로 ajax의 오류 발생
					// break;
				}
			}
			// 비밀번호를 검사하기 위한 for문이 모두 끝나면 비밀번호 오류
			model.addAttribute("LOGIN_FAIL", "PASS");
			return "bodys/login_form";
			
		} 
		else { //가입되지 않은 ID
				model.addAttribute("LOGIN_FAIL","ID");
				return "bodys/login_form";
			
		//return "redirect:/";
	
		}
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		// LOGIN_INFO 정보만 삭제, 초기화 하는 방법
		session.setAttribute("LOGIN_INFO", null);
		session.removeAttribute("LOGIN_INFO");
		
		// 모든 session 삭제
		// session.invalidate();
	
		return "redirect:/";
	}
	/*
	 * ResponseBody가 있으면 문자열을 그대로 (가공하지 않고) 웹 브라우저로 res 해라
	 */	

}

