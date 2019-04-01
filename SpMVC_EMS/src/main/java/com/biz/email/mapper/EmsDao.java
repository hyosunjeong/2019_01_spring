package com.biz.email.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.email.model.EmsVO;

public interface EmsDao {

	@Select(" SELECT * FROM tbl_emails ORDER BY s_date DESC, s_time DESC")
	public List<EmsVO> selectAll();
	
	@Select(" SELECT * FROM tbl_emails WHERE id=#{id} ")
	public EmsVO findById(long id);
	
	@SelectKey(statement=" SELECT SEQ_EMAIL.NEXTVAL FROM DUAL ", keyProperty = "id", before=true,resultType=Long.class)
	@InsertProvider(type=EmsSQL.class, method="email_insert_sql")
	public int insert(EmsVO emsVO);
	
	@UpdateProvider(type=EmsSQL.class,method="email_update_sql")
	public int update(EmsVO emsVO);
	
	@Delete(" DELETE FROM tbl_emails WHERE id=#{id} ")
	public int delete(long id);
}
