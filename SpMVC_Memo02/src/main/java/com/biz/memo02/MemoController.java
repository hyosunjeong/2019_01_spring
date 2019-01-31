package com.biz.memo02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.vo.MemoVO;

@Controller
public class MemoController {
	
	
	// 폼을 열때 사용할 reqPath
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo() {
		return "memo_write";
	}
	
	// 폼으로 부터 데이터를 전달받을 때 사용할 reqPath
	@RequestMapping(value="memo",method=RequestMethod.POST)
	public String memo(MemoVO vo, Model model) {
		return "memo_write";
	}
	
}
