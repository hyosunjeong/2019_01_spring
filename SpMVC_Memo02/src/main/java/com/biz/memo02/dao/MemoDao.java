package com.biz.memo02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.memo02.vo.MemoVO;

public interface MemoDao {
	@Select(MemoSQL.MEMO_SELECT_ALL)
	public List<MemoVO> selectAll(); // 전체 읽어오기 (DB로 부터 읽어서 List로 가져온다.)
	
	@Select(MemoSQL.MEMO_FIND_BY_ID)
	public MemoVO findById(long id); // 하나만 읽어 오기 (id값을 가져와서 MemoVO를 리턴받는다.)
	
	@Insert(MemoSQL.MEMO_INSERT)
	public int insert(MemoVO vo);
	
	@Update(MemoSQL.MEMO_UPDATE)
	public int update(MemoVO vo);
	
	@Delete(MemoSQL.MEMO_DELETE)
	public int delete(long id);
	

}
