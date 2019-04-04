package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	SqlSession session;
	
	public List<ProductVO> selectAll(){
			
			ProductDao pDao = session.getMapper(ProductDao.class);
			List<ProductVO>productVO = pDao.selectAll();
			
			return productVO;
		}
	
	public int insert(ProductVO productVO) {
		
		ProductDao pDao = session.getMapper(ProductDao.class);
		int ret = pDao.insert(productVO);
		
		return ret;
		
		
	}
	
	
}
