package com.biz.email.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmsVO {
	
	private long id;
	private String from_email;
	private String to_email;
	private String s_date;
	private String s_time;
	private String s_subject;
	private String s_content;
	private String s_file1;
	private String s_file2;

}
