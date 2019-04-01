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
	EmsDao eDao;
	
	@Autowired
	SendMailService sMail;
	
	public List<EmsVO> selectAll() {
		
		return eDao.selectAll();
	}

	public EmsVO findById(long id) {

		return eDao.findById(id);
	}

	public int insert(EmsVO emsVO) {
		int ret = eDao.insert(emsVO);
		sMail.sendMail(emsVO);
		return ret;
	}

	public int update(EmsVO emsVO) {
		int ret = eDao.update(emsVO);
		return ret;
	}

	public int delete(long id) {
		
		return eDao.delete(id);
	}
	
	
	public int save(EmsVO emsVO) {
		int ret = 0;
		
		if(emsVO.getId()>0) {
			ret = eDao.update(emsVO);
		}else {
			ret = eDao.insert(emsVO);
		}
		return 0;
	}

	

}
