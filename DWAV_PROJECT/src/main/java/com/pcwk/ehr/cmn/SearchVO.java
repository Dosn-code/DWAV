package com.pcwk.ehr.cmn;

public class SearchVO extends DTO {
	/** 검색 구분 */
	private String searchDiv;

	/** 검색어 */
	private String searchWord;

	private int pageSize;// 10,20,50,100,200
	private int pageNum;// 1,2,3...10

	public SearchVO() {
	}

	public SearchVO(String searchDiv, String searchWord, int pageSize, int pageNum) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", toString()=" + super.toString() + "]";
	}
	
	

}
