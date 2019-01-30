package com.biz.sp007.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.sp007.model.BookVO;

/* annotation한 후 서버 다시 실행하기*/
@Service
public class BookService {

	public BookVO changeAuth(BookVO vo) {

		String strAuth = vo.getB_auth();
		// vo로부터 auth를 가져온다.
		
		strAuth += ">> 이몽룡";
		
		return vo;
	}

	public List<BookVO> selectAll() {
		
		List<BookVO> bookList= new ArrayList();
		for(int i=0; i<10; i++) {
			BookVO vo = new BookVO();
			
			vo.setB_title("No" + i + " BOOK ");
			vo.setB_comp("Korea co.kr");
			vo.setB_auth("Hong Kil Dong");
			vo.setB_price(15000);
			
			bookList.add(vo);
			
		}
		
		return bookList;
	}

}
