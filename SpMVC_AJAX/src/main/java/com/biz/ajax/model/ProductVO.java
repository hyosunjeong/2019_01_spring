package com.biz.ajax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data 가급적 사용하지 말기
// => 내부 metohd를 생성해서 vo를 상당히 무겁게 만든다.
@Setter
@Getter
@AllArgsConstructor // member 생성자
@NoArgsConstructor 	// super 생성자
@ToString
public class ProductVO {
	
	private String p_ccode;  // 상품코드 
	private String p_cname; // 상품이름
	private String p_vat; 	// 1:과세 2:면세
	private int p_iprice; // 매입단가
	private int p_oprice; // 판매단가
	
}
