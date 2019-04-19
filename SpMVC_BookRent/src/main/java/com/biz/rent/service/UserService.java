package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.UserDao;
import com.biz.rent.model.UserVO;

@Service
public class UserService {

	@Autowired
	UserDao dao;
	
	public List<UserVO> selectAll() {
		
		return dao.selectAll();
	}
	
	public UserVO findById(long user_seq) {
		
		return dao.findById(user_seq);
	}
	
	public int insert(UserVO userVO) {
		int ret = dao.insert(userVO);
		
		return ret;
	}
	
	public int update(UserVO userVO) {
		int ret = dao.insert(userVO);
		
		return ret;
	}
	
	public int delete(long user_seq) {
		int ret = dao.delete(user_seq);
		
		return ret;
	}

}
