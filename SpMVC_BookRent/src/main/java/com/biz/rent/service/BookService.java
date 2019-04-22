package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.BookDao;
import com.biz.rent.model.BookVO;

@Service
public class BookService {
/*
 * CRUD 구현 method
 */
	@Autowired
	BookDao bDao;

	public List<BookVO> selectAll() {
		
		List<BookVO> bookList = bDao.selectAll();
		
		return bookList;
	}
	
	public BookVO findById(long book_seq) {
		
		BookVO vo = bDao.findById(book_seq);
		
		return vo;
	}
	
	public int insert(BookVO bookVO) {
		
		int ret = bDao.insert(bookVO);
		
		return ret;
	}
	
	public int update(BookVO bookVO) {
		int ret = bDao.insert(bookVO);
		
		return ret;
	}
	
	public int delete(long book_seq) {
		int ret = bDao.delete(book_seq);
		
		return ret;
	}

	/*
	 * 도서검색 method
	 */
	
	public List<BookVO> getSearchList(String s_string) {
		
		try {
			// 넘겨받은 s_string을 long형으로 바꾸려고 시도
			Long.valueOf(s_string);
			
			// 만약 오류가 발생하지 않았다면
			// s_string은 숫자로 변환이 가능한 문자열
			// 9791162540770 이런 형식의 ISBN
			
			return bDao.getSearchListByIsbn(s_string);
			
		}catch(Exception e) {
			
		}
		
		return bDao.getSearchList(s_string);
	}
}
