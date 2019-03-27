package com.biz.simple;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/*
	 * value="/" : rootPath
	 * 프로젝트에서 아무런 URI가 없이 호출되는 주소(path)
	 * localhost:8080/simple/
	 * 
	 * 프로젝트가 최초 시작되었을 때 views/home.jsp를 열어서 web brower로 보내라
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	// 문자열만 있으면 기본값 GET
	@RequestMapping("list") // list 키워드로 요청 
	public String list() { // 메소드 실행
		return "list"; // 보여줘라
		
		/*
		 * list keyword로 조회한 정보가 있으면 알려줘라
		 */
	}
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String write() {
		
		return "write";
	}
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String write1(InputVO inputVO, Model model) {
		// 받아야 할 매개변수가 많아지면 불편해지므로 
		// InputVO를 만들어서 InputVO inputVO로 매개변수로 만들어준다.
		// 입력폼에서 넘겨줘야 할 데이터가 몇개일지 모를 때 사용하기 위해 VO를 만든다.
		
		System.out.println(inputVO.getNum1());
		System.out.println(inputVO.getOp());
		System.out.println(inputVO.getNum2());
		
		int intNum1 = Integer.valueOf(inputVO.getNum1());
		int intNum2 = Integer.valueOf(inputVO.getNum2());
		
		String op = inputVO.getOp();
		
		int result = 0;
		if(op.equals("+")) {
			result=intNum1+intNum2;
		}
		if(op.equals("-")) {
			result=intNum1-intNum2;
		}
		
		if(op.equals("*")) {
			result=intNum1*intNum2;
		}
		
		model.addAttribute("result", "결과:"+result);
		/*
		 *  Java가 spring에게 스프링만의 규칙으로
		 *  result <="결과"+result 로 스프링에게 알려줌
		 *  
		 *   view 파일을 검사해서 result가 ${result}로 되어 있는것을 찾아서
		 *   "결과:" + result 로 보내서 보여준다. =>랜더링
		 *   
		 */
		return "view";
	}
	
	
}
