package com.biz.file.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageVO {
	long listPerPage; // 페이지당 리스트 개수
	long firstPageNo; // 첫번째 페이지 번호
	long prePageNo; // 이전 페이지 번호
	long startUpPageNo; // 시작 페이지
	long currentPageNo;  // 현재 페이지
	long endPageNo; // 끝 페이지
	long nextPageNo; // 다음 페이지
	long finalPageNo;
	long totalCount; // 전체 리스트 개수
	long pageCount; // 한번에 보여질 페이지 수
	
	public PageVO(long currentPage, long listPerPage) {
		this.currentPageNo = currentPage;
		this.pageCount = 10;
		this.listPerPage = (listPerPage != 0) ? listPerPage : this.pageCount;
		
	}
	

}
