package com.biz.memo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.memo.model.MemberVO;

public class LoginAuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
		
		// request 정보중에 login 정보가 있는가 검사해 보고
		// login 정보가 있으면(not null) Controller에게 제어권을 넘기고
		// 그렇지 않으면 login_form을 보여서 login을 하도록 하겠다.
		
		// 1. HttpServletRequest에서 필요한 session정보만 추출
		// preHandler는 Override된 method이기 때문에
		// 마음대로 매개변수를 바꿀 수 없어서 선행작업이 필요하다
		
		HttpSession session = request.getSession();
		// 가. 혹시 Login 정보에 ROLE 정보가 필요할 때
		MemberVO memberVO = (MemberVO) session.getAttribute("LOGIN_INFO");// memberVO정보
		
		// 나 .그냥 Login 되었는지만 알고 싶을 때
		Object object = session.getAttribute("LOGIN_INFO");
		
		// 2. 추출한 Login 정보가 null이 아닌가 검사
		if(memberVO == null) { // login이 안되어 있으면
			//login_form으로 redirect
			
			response.sendRedirect("login");
			return false;
			
		}else {
			// memberVO의 ROLE 항목이 있다면
			// 해당 ROLE을 검사해서 
			/*
			 * if(memberVO.getM_role() == "USER"){
			 * 	// 일반 사용자
			 *	// 만약 관리자와 관련된 것을 요청했으면
			 *	login_form으로 redirect
			 * } else (memberVO.getM_role() == "ADMIN")
			 *	// 관리자이면 계속 진행
			 *	}
			 */ 
		}
		
		// 최종 return 값이 true이면 Controller에게 req정보를 전달해서
		// 계속 업무를 수행 
		// 최종 return 값이 false이면 더이상 진행하지 말고 
		// 모든 것을 멈춰라
		return true;
	}
	

}
