package com.biz.ajax01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ajax01.mapper.DeptMapper;
import com.biz.ajax01.model.DeptVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptService {

	@Autowired
	DeptMapper dMapper;
	
	
	public List<DeptVO> getDeptAllList() {
		return dMapper.selectAll();
	}


	public DeptVO getDept(String d_code) {
		
		DeptVO deptVO = dMapper.findByDcode(d_code);
		return deptVO;
	}


	public List<DeptVO> getFindByDName(String d_name) {
		log.debug(d_name);
		
		// 검색 문자열의 앞뒤 빈칸 제거
		return dMapper.findByDname(d_name.trim());
	}


	public int save(DeptVO deptVO) {
		// 새로등록인지 아니면 수정(Update) 등록인지 확인
		
		int ret = 0;
		
		String d_code = deptVO.getD_code();
		DeptVO tvo = dMapper.findByDcode(d_code);
		if(tvo == null) {
			ret = dMapper.insert(deptVO);
		}else {
			ret = dMapper.update(deptVO);
		}
		return ret;
	}
	
	
	
}
