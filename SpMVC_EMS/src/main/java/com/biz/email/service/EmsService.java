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
	EmsDao dao;
	
	
	public List<EmsVO> selectAll() {
		
		return dao.selectAll();
	}

	public EmsVO findById(long id) {

		return dao.findById(id);
	}

	public int insert(EmsVO emsVO) {
		int ret = dao.insert(emsVO);
		return ret;
	}

	public int update(EmsVO emsVO) {
		int ret = dao.update(emsVO);
		return ret;
	}

	public int delete(long id) {
		
		return dao.delete(id);
	}

}
