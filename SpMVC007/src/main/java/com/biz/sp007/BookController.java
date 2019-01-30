package com.biz.sp007;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.sp007.model.BookVO;
import com.biz.sp007.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	/*
	 * public BookController(){
	 * 	bookService = new BookService();
	 * 와 같음
	 * 
	 * @Autowired가 작동이 되려면 Service클래스에 @Service가 설정되어 있어야한다.
	 * */
	
	@RequestMapping(value="book", method=RequestMethod.GET)
	public String book() {
		return "book_form";
	}
	
	@RequestMapping(value="book1", method=RequestMethod.POST)
	public String book(Model model, String b_title, String b_auth, String b_comp, String b_price) {
		return "book_result";	
		
		/*
		 * 매개변수가 많아지면 오류발생 확률이 높아진다.
		 * 매개변수 2개가 넘어가면 vo로 만든다.		 
		 */
	}
	
	@RequestMapping(value="book",method=RequestMethod.POST)
	public String book(Model model, @ModelAttribute BookVO vo) {
		
		vo = bookService.changeAuth(vo);
		
		List<BookVO> bookList = bookService.selectAll();
		
		
		model.addAttribute("BOOK",vo);
		// vo자체를 포함시킨다.
		
		model.addAttribute("BOOKS", bookList);
		
		
		return "book_result";
		
		/*
		 * @ModelAttribute
		 * vo를 분석해서 form으로 부터 데이터가 넘겨오면 알아서 vo에 채워준다. (3.5이상버전)
		 * 
		 * */
	}

}
