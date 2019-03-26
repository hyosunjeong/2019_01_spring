package com.biz.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.file.mapper.BoardDao;
import com.biz.file.model.BoardVO;

@Service
public class BBSServiceImp implements BBSService {

	@Autowired
	BoardDao bDao;
	
	@Override
	public List<BoardVO> selectAll() {
		
		List<BoardVO> bbsList = bDao.selectAll();
		
		return bbsList;
	}

	@Override
	public BoardVO findById(long id) {
		
		BoardVO vo = bDao.findById(id);
		return vo;
	}

	@Override
	public List<BoardVO> findByUserId(String b_userid) {
	
		return null;
	}

	@Override
	public int insert(BoardVO boardVO) {
		int ret = bDao.insert(boardVO);
		return ret;
	}

	@Override
	public int update(BoardVO boardVO) {
		
		return bDao.update(boardVO);
	}

	@Override
	public int delete(long id) {
		
		return bDao.delete(id);
	}

	/*
	 * 2번 이상의 SQL문이 실행되는 경우
	 * SQL 실행이 모두 완료되기 전에 
	 * 다른 사용자(또는 접속)에 의해서 메서드가 실행되면
	 * 데이터 신뢰도에 문제가 발생할 수 있다.
	 * 그러한 문제를 막기위해서 RDMBS에서는
	 * 2번 이상의 SQL문을 Transaction이라는 작업그룹으로 묶어주어야한다.
	 * 
	 * Spring과 mybatis 프로젝트에서는
	 * mybatis-context.xml 또는 MybatisConfig에서 
	 * DataTransactionManager를 bean으로 설정 해 두고
	 * transaction이 필요한 method에서 @Transactional을 설정해 두면
	 * 나머지는 Spring, Mybatis, DataSource들까지 서로 협력하여
	 * 모든 처리를 대신 해 준다.
	 * 
	 * Config에서 transactionManager라는 이름으로 method를 설정해야 하고
	 * Config.java로 설정할 때는 @EnableTransactionManager를 설정한다.
	 * 
	 * MySQL은 기본 DB엔진에서 자체적으로 transaction을 지원하지 않는다.
	 * 그래서 MySQL을 처음 설치할 때 DB엔진은 innoDB로 설정을 해야한다.
	 * 
	 * DataSource를 설정할 때 commons-dbcp2를 사용하면
	 * 가장 매칭이 잘 된다.
	 */
	@Override
	@Transactional
	public BoardVO UpdateHit(long id, String b_userid) {
		
		BoardVO vo = bDao.findById(id);
		if(!vo.getB_userid().equalsIgnoreCase(b_userid)) {
			bDao.boadHit(id);
		}
		
		return vo;
	}

}
