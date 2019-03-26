package com.biz.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.file.mapper.LoginDao;
import com.biz.file.model.MemberVO;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	LoginDao lDao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public MemberVO getMemberInfo(MemberVO loginVO) {

		/*
		 * 정상적인 로그인인지 확인하기 위해
		 * userid와 password를 조회해서 일치하는지 알아보아야 하지만
		 * password를 암호화하였고 지금 암호화 한 password는 단방향 암호화 방식이다
		 * 
		 * 단방향 암호화된 비밀번호가 일치하는지 알아보는 방법
		 *  로그인할 때 입력한 비밀번호를 다시 암호화 한다
		 *  생성된 암호문자열을 DB에서 가져온 문자열과 비교해서 일치하는지 알아본다.
		 * 
		 * 그런데 
		 * BCryp.... 암호화 방식에서는 모든것을 내장된(기본제공되는)
		 * method를 통해서만 가능하다. 
		 */
		String m_userid = loginVO.getM_userid();
		MemberVO vo = lDao.getMemberInfo(m_userid);
		
		String crypPass = vo.getM_password();
		String encodedPassword = vo.getM_password();
		
		String plainPass = loginVO.getM_password();
		String rawPassword = loginVO.getM_password();

		boolean math = encoder.matches(rawPassword, encodedPassword);
		
		// math == true : 비밀번호 일치
		if(math) {
			// 비밀번호가 일치했다면 DB에서 읽어온 member의 정보를
			// controller에게 return하고 
			return vo;
		}else {
			// 그렇지 않으면 
			// null을 return 한다.
			return null;
		}
		
		
	}

}
