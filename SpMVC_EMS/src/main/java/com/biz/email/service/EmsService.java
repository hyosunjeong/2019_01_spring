package com.biz.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.email.mapper.EmsDao;
import com.biz.email.model.EmsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmsService {

	
	@Autowired
	EmsDao dDao;
	
	
	public List<EmsVO> selectAll() {
		
		return dDao.selectAll();
	}

	public EmsVO findById(long id) {

		return dDao.findById(id);
	}

	public int insert(EmsVO emsVO) {
		int ret = dDao.insert(emsVO);
		return ret;
	}

	public int update(EmsVO emsVO) {
		int ret = dDao.update(emsVO);
		return ret;
	}

	public int delete(long id) {
		
		return dDao.delete(id);
	}

}
