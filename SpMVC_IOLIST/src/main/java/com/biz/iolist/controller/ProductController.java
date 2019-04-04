package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;
/*
 * 상품정보 컨트롤러
 */
@SessionAttributes("productVO")
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@ModelAttribute("productVO")
	public ProductVO newProductVO() {
		
		ProductVO productVO = new ProductVO();
		
		return productVO; 
	}

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<ProductVO> productList = productService.selectAll();
		model.addAttribute("LIST", productList);		
		model.addAttribute("BODY", "P_LIST");
		return "home";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(@ModelAttribute("ProductVO")ProductVO productVO, Model model) {
		
		model.addAttribute("productVO", productVO);
		model.addAttribute("BODY", "P_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute ("ProductVO")ProductVO productVO, Model model, SessionStatus session) {
		
		
		int ret = productService.insert(productVO);
		if(ret>0) {
			session.setComplete();
			return "redirect:/product/list";
		}else {
			model.addAttribute("ProdcutVO", productVO);
			model.addAttribute("BODY", "P_WIRTE");
			return "home";
		}
		
		
		
//		model.addAttribute("MSG", "데이터 추가 성공");
//		
//		return "redirect:/";
		
	
	}
	
}

