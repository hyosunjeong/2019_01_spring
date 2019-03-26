package com.biz.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @Controller는 WEB Browser의 요청(Request)을 수신할 bean임을 선언
 * 클래스의 이름은 중요하지 않다.
 * 단, 중복되지 않아야 한다.
 * 
 */
@Controller
public class HomeController {
	/*
	 * @RequestMapping은 controller로부터 할 일들을 세부 부여받은 method들이다.
	 * @RequestMapping이 없는 method는 그냥 평범한 method일 뿐이다.
	 */
	@RequestMapping("home")
	public String home(Model model) {
		System.out.println("홈 method 실행");
		return "home";
	}
	
	@RequestMapping("yes")
	public String yes() {
		System.out.println("YES method 실행");
		return "home";
	}
	
	@RequestMapping("no")
	public String no() {
		System.out.println("NO method 실행");
		return "home";
	}
	
	@ResponseBody 
	@RequestMapping("home1")
					// request path
	public String home1() {
		
		return "Welcome My Home";
	}
	
	@ResponseBody
	@RequestMapping("yes1")
	public String yes1() {
		
		return "YES OK!";
	}

	@ResponseBody
	@RequestMapping("no1")
	public String no1() {
		add("10","20");
		return "NO thankyou";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(String num1, String num2) {
		
		System.out.println(num1+num2);
		int intNum1 = Integer.valueOf(num1);
		int intNum2 = Integer.valueOf(num2);
		//return num1+num2;
		return ""+(intNum1+intNum2);
		
		// add?num1=30&num2=50 >> requestParam
	}
	
	/*
	 * Java(pojo)사용하려면 객체로 생성한 후 그 안에 있는 method를 호출하는 방식
	 * 
	 * spring에서 사용하는 클래스들은 Bean이 된다.
	 * 생성하지 않아도 클래스들은 bean이라는 것으로 등록이 됨
	 * 
	 * 컨트롤러 어노테이션은 web브라우저가 req를 수신할 bean이라고 선언
	 * 컨트롤러로 선언된 클래스들은 웹브라우저가 직접 만나는 클래스이다.
	 * 
	 */
}


