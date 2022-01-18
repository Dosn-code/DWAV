package com.pcwk.ehr.member.domain;

import com.pcwk.ehr.cmn.DTO;

public class HostVO extends DTO{
	/** 호스트 IDX */
	private int hostIdx;
	
	/** 유저 ID */
	private String uId;      
	
	/** 숙소 IDX */
	private int homeIdx;
	
	/** 호스트 가입 날짜 */
	private String hostDate;

	/** default생성자 */
	public HostVO() {}

	//constructor 생성
	public HostVO(int hostIdx, String uId, int homeIdx, String hostDate) {
		super();
		this.hostIdx = hostIdx;
		this.uId = uId;
		this.homeIdx = homeIdx;
		this.hostDate = hostDate;
	}

	//getter, setter 생성
	public int getHostIdx() {
		return hostIdx;
	}

	public void setHostIdx(int hostIdx) {
		this.hostIdx = hostIdx;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public int getHomeIdx() {
		return homeIdx;
	}

	public void setHomeIdx(int homeIdx) {
		this.homeIdx = homeIdx;
	}

	public String getHostDate() {
		return hostDate;
	}

	public void setHostDate(String hostDate) {
		this.hostDate = hostDate;
	}

	//to.string() 추가
	@Override
	public String toString() {
		return "HostVO [hostIdx=" + hostIdx + ", uId=" + uId + ", homeIdx=" + homeIdx + ", hostDate=" + hostDate
				+ ", toString()=" + super.toString() + "]";
	}

	
		
	// 추가
	// ex) Null처리 등등
}
