package com.biz.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller /* spring에게 CalcController 사용을 대신 해줘라 */
public class CalcController {
	
	@RequestMapping(value="calc-ajax",method=RequestMethod.GET)
	public String calc_form(){
		return "calc-ajax";
	}
	
	
	@ResponseBody
	@RequestMapping(value="add-ajax",method=RequestMethod.POST)
	public String add_ajax(@RequestParam int intNum1, @RequestParam int intNum2) {
		
		System.out.println("intNum1 : " + intNum1);
		System.out.println("intNum2 : " + intNum2);
		return "" + (intNum1 + intNum2);
	}
	
	@ResponseBody
	@RequestMapping(value="add", method=RequestMethod.GET)/* RequestMapping은 Controller 내에서만 사용 가능 */
	public String add() {
		int intNum1 = 30;
		int intNum2 = 40;
		int intSum = intNum1 + intNum2;
		
		return ""+intSum; // 문자열 반환이기 때문에 ""+ 를 해줘야 한다.
	}
	
	
			
	
	@ResponseBody
	@RequestMapping(value="add1",method=RequestMethod.GET,produces="application/json;charset=utf8")
	public String add(@RequestParam("intNum1") String strNum1, 
						@RequestParam("intNum2") String strNum2) {
				/* RequestParam("intNum2") 은 사용자에게 intNum2를 사용하게 함*/
		
		
		int intNum1;
		int intNum2;
		
		try {
			intNum1 = Integer.valueOf(strNum1);
		} catch(Exception e) {
			return "intNum1은 숫자로 변환 할 수 없습니다";
		}
		
		try {
			intNum2 = Integer.valueOf(strNum2);
		} catch(Exception e) {
			return "intNum2은 숫자로 변환 할 수 없습니다";
		}
		
		int intSum = intNum1+intNum2;
		return "intNum1 = " + intNum1
				+ " intNum2 = " + intNum2 
				+ " 두수의 합 = " + intSum;
		
	}
	
	@ResponseBody
	@RequestMapping(value="add2",method=RequestMethod.GET,produces="application/json;charset=utf8")
	public String add2(@RequestParam("intNum1") String strNum1, 
						@RequestParam("intNum2") String strNum2) {
				/* RequestParam("intNum2") 은 사용자에게 intNum2를 사용하게 함*/
		
		
		int intNum1;
		int intNum2;
		
		try {
			intNum1 = Integer.valueOf(strNum1);
		} catch(Exception e) {
			return "intNum1은 숫자로 변환 할 수 없습니다";
		}
		
		try {
			intNum2 = Integer.valueOf(strNum2);
		} catch(Exception e) {
			return "intNum2은 숫자로 변환 할 수 없습니다";
		}
		
		int intSum = intNum1+intNum2;
		
		String strRet = "{ intNum1 : " + intNum1 + ","
				+ " intNum2 : " + intNum2 + ","
				+ " intSum : " + intSum + " }";
		
		return strRet;	
	}
	
	@ResponseBody // return 문자열을 바로 웹으로 보냄
	@RequestMapping(value="add3",method=RequestMethod.GET,
					produces="text/html; charset=utf8")
	public String add3(@RequestParam("intNum1") String strNum1, 
						@RequestParam("intNum2") String strNum2) {
				/* RequestParam("intNum2") 은 사용자에게 intNum2를 사용하게 함*/
		
		
		int intNum1;
		int intNum2;
		
		try {
			intNum1 = Integer.valueOf(strNum1);
		} catch(Exception e) {
			return "intNum1은 숫자로 변환 할 수 없습니다";
		}
		
		try {
			intNum2 = Integer.valueOf(strNum2);
		} catch(Exception e) {
			return "intNum2은 숫자로 변환 할 수 없습니다";
		}
		
		int intSum = intNum1+intNum2;
		
		String strRet = "<html>";
			strRet += "<body>";
			strRet +="<p><font color = blue> 숫자1 : " + intNum1 +"</font></p>";
			strRet +="<p><font color = red> 숫자2 : " + intNum2 +"</font></p>";
			strRet +="<p><font color = green> 합계 : "+ intSum +"</font></p>";
			strRet +="</body>";
			strRet +="</html>";
			
		return strRet;	
	}
}
