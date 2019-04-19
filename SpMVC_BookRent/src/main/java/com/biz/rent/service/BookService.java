package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.BookDao;
import com.biz.rent.model.BookVO;

@Service
public class BookService {

	@Autowired
	BookDao dao;

	public List<BookVO> selectAll() {
		
		List<BookVO> bookList = dao.selectAll();
		
		return bookList;
	}
	
	public BookVO findById(long book_seq) {
		
		BookVO vo = dao.findById(book_seq);
		
		return vo;
	}
	
	public int insert(BookVO bookVO) {
		
		int ret = dao.insert(bookVO);
		
		return ret;
	}
	
	public int update(BookVO bookVO) {
		int ret = dao.insert(bookVO);
		
		return ret;
	}
	
	public int delete(long book_seq) {
		int ret = dao.delete(book_seq);
		
		return ret;
	}

	
}
