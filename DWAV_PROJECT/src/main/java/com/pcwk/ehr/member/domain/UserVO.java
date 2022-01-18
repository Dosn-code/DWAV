package com.pcwk.ehr.member.domain;

import com.pcwk.ehr.cmn.DTO;

/**
 * @author Dosn
 *
 */
public class UserVO extends DTO {
	/** 유저 ID */
	private String userId      ;
	
	/** 비밀번호 */
	private String passwd   ;      
	
	/** 성 */
	private String firstNm;
	
	/** 이름 */
	private String lastNm;

	/** 생년월일 */
	private String birthDate;
	
	/** 이메일 */
	private String eMail;
	
	/** 이메일 */
	private String phoneNum;

	/** 유저 사진 */
	private String userImg;
	
	/** 유저 소개 */
	private String userIntro;
	
	/** 가입 날짜 */
	private String joinDate;
	
	/** 이메일 인증 여부 */
	private int emailAuth;
	
	/** 호스트 신청 여부 */
	private int enlistHost;
	
	/** 호스트 가능 상태 */
	private MakeHost makeHost;
	
	/** Mybatis */
	private int intMakeHost;
	



	public UserVO(String userId, String passwd, String firstNm, String lastNm, String birthDate, String eMail,
			String phoneNum, String userImg, String userIntro, String joinDate, int emailAuth, int enlistHost,
			MakeHost makeHost, int intMakeHost) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.firstNm = firstNm;
		this.lastNm = lastNm;
		this.birthDate = birthDate;
		this.eMail = eMail;
		this.phoneNum = phoneNum;
		this.userImg = userImg;
		this.userIntro = userIntro;
		this.joinDate = joinDate;
		this.emailAuth = emailAuth;
		this.enlistHost = enlistHost;
		this.makeHost = makeHost;
		this.intMakeHost = intMakeHost;
	}



	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", passwd=" + passwd + ", firstNm=" + firstNm + ", lastNm=" + lastNm
				+ ", birthDate=" + birthDate + ", eMail=" + eMail + ", phoneNum=" + phoneNum + ", userImg=" + userImg
				+ ", userIntro=" + userIntro + ", joinDate=" + joinDate + ", emailAuth=" + emailAuth + ", enlistHost="
				+ enlistHost + ", makeHost=" + makeHost + ", intMakeHost=" + intMakeHost + ", toString()="
				+ super.toString() + "]";
	}



	public int getIntMakeHost() {
		return intMakeHost;
	}



	public void setIntMakeHost(int intMakeHost) {
		this.intMakeHost = intMakeHost;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getFirstNm() {
		return firstNm;
	}



	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}



	public String getLastNm() {
		return lastNm;
	}



	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}



	public String getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	public String getPhoneNum() {
		return phoneNum;
	}



	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}



	public String getUserImg() {
		return userImg;
	}



	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}



	public String getUserIntro() {
		return userIntro;
	}



	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}



	public String getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}



	public int getEmailAuth() {
		return emailAuth;
	}



	public void setEmailAuth(int emailAuth) {
		this.emailAuth = emailAuth;
	}



	public int getEnlistHost() {
		return enlistHost;
	}



	public void setEnlistHost(int enlistHost) {
		this.enlistHost = enlistHost;
	}



	public MakeHost getMakeHost() {
		return makeHost;
	}



	public void setMakeHost(MakeHost makeHost) {
		this.makeHost = makeHost;
	}



	public void makeHost() {
		MakeHost canHost = this.makeHost.canHost();
		
		if(null==canHost) {
			throw new IllegalArgumentException(this.makeHost+"호스트 신청을 하지 않았거나, 혹은 이미 당신은 호스트입니다.");
		}else {
			this.makeHost = canHost;
		}
	}
		
	
	
}
