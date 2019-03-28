package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.PageDao;
import com.biz.file.model.BoardVO;

@Service
public class PageService {

	@Autowired
	PageDao pDao;
	
	public long getCount() {
		
		return pDao.getCount(); 
	}
	
	public List<BoardVO> pageList(long start, long end){
		
		start = 1;
		end = 10;
		
		List<BoardVO> bbsList = pDao.pageList(start, end);
		return bbsList;
		
	}
	
}
