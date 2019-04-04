package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.IolistDao;
import com.biz.iolist.model.IolistVO;

@Service
public class IolistService {

	@Autowired
	SqlSession session;
	
	public List<IolistVO> selectAll(){
		
		IolistDao iDao = session.getMapper(IolistDao.class);
		List<IolistVO> io_List = iDao.selectAll();
		
		return io_List;
	}

public int insert(IolistVO iolistVO) {
	
	IolistDao iDao = session.getMapper(IolistDao.class);
	int ret = iDao.insert(iolistVO);
	
	return ret;
	
	
}

public IolistVO findByID(long io_id) {

	IolistDao iDao = session.getMapper(IolistDao.class);
	IolistVO vo = iDao.findById(io_id);
	
	return vo;
}

public int update(IolistVO iolistVO) {
	IolistDao iDao = session.getMapper(IolistDao.class);
	int ret = iDao.update(iolistVO);
	
	return ret;
}
	
}
