package com.pcwk.ehr.cmn;

/**
 * 모든 Value Object 조상
 * @author HKEDU
 *
 */
public class DTO {

	/** 글번호 */
	private int num;
	
	/** 총글수*/
	private int totalCnt;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public DTO(int num, int totalCnt) {
		super();
		this.num = num;
		this.totalCnt = totalCnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	@Override
	public String toString() {
		return "DTO [num=" + num + ", totalCnt=" + totalCnt + "]";
	}
	
	

}
