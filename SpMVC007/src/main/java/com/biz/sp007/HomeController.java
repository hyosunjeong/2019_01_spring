package com.biz.sp007;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	// RequestMapping에 단순히 문자열만 settiong하면
	// req(요청)하는 방식이 GET 이거나 POST 이거나
	// 상관없이 작동되어라 하는 설정
	@RequestMapping(value = "home")
	
	public String home() {
		return "home";
	}
	
	// method=...GET 이라고 settiong을 하면
	// req하는 방식이 GET일 경우에만 작동되어라 하는 설정
	// req가 GET인 경우 : 브라우저의 주소창에 직접 입력을 하고 
    //					  Enter를 눌렀을 경우가 해당된다.
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String calc() {
		return "calc_form";
		
		/*
		 * return 값이 반드시 String 이여야 한다.
		 */
		
		/*
		 * 원래 문법은 @RequestMapping(value="/", method=RequestMethod.GET) 이여야 
		 * @RequestMapping("/")여도 상관없다.
		 * 
		 * form으로 묶으면 GET 또는 POST로 요청할 수 있다.
		 * 문자열만 써 줬을 경우 GET이나 POST 요청 모두 받을 수 있다.
		 * 
		 */
		
		
	}
	
	
}


/*
 * HomeController 클래스는 web 브라우저를 통해 요청하면
 * 제일 먼저 수신하는 대상이다.
 * 
 *  클래스 이름과 관계없이 @Controller 이라는 어노테이션을 찾는다.
 *  @RequestMapping이라는 어노테이션이 있는지 찾고
 *  ("/")로 되어있는 것을 찾은 후 매소드를 확인한다.
 *  
 *  매소드에서 return "home"; 이 있기 때문에 home라는 문자열을 리턴해주면
 *  톰캣이 받는다.
 *  
 *  /WEB-INF/views/home.jsp 파일을 찾고 web 브라우저에 보여준다.
 *  
 */


/*
 * @RequestMapping("home")
	
	public String home() {
		return "home";
	}
 * 
 * @RequestMapping("/")
	public String calc() {
		return "calc_form";
 */
