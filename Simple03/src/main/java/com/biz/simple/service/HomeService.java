package com.biz.simple.service;

import org.springframework.stereotype.Service;

// bean 등록
@Service
public class HomeService {

	public int calc(String num1, String op, String num2) {
		
		int intSum=0;
		
		
		try {

			int intNum1 = Integer.valueOf(num1);
			int intNum2 = Integer.valueOf(num2);
			
			if(op.equals("P")) {
				intSum = intNum1 + intNum2;
			}
			
			if(op.equals("T")) {
				intSum =intNum1*intNum2; 
			}
			
			if(op.equals("M")) {
				intSum = intNum1-intNum2;
			}
			
			
		} catch(Exception E) {
			
		}
		
		System.out.println(num1);
		System.out.println(op);
		System.out.println(num2);
		
		return intSum;
	}

}
