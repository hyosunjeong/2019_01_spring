package com.biz.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rent.mapper.UserDao;
import com.biz.rent.model.UserVO;

@Service
public class UserService {

	@Autowired
	UserDao uDao;
	
	public List<UserVO> selectAll() {
		
		return uDao.selectAll();
	}
	
	public UserVO findById(long user_seq) {
		
		return uDao.findById(user_seq);
	}
	
	public int insert(UserVO userVO) {
		int ret = uDao.insert(userVO);
		
		return ret;
	}
	
	public int update(UserVO userVO) {
		int ret = uDao.update(userVO);
		
		return ret;
	}
	
	public int delete(long user_seq) {
		int ret = uDao.delete(user_seq);
		
		return ret;
	}

	
	/*
	 * 회원정보 검색
	 */
	public List<UserVO> getSearchList(String s_string) {
		
		return uDao.getSearchList(s_string);
	}

}
