package com.pcwk.ehr.member.domain;

public enum MakeHost {
	
	HOST(3,null),ENLIST(2,HOST), USER(1,null); 
	
	private final int value;
	
	private final MakeHost next;
	
	MakeHost(int value, MakeHost next){
		this.value = value;
		this.next  = next;
	}
	
	/**
	 * 특정 유저가 호스트가 될 수 있는지 여부, 될 수 있을 경우 return : HOST,
	 * 이미 호스트인 경우 null
	 * @return
	 */
	public MakeHost canHost() {
		return this.next;
	}
	
	/**
	 *값을 가져오는 메서드, 1:Host, 0:User 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	public static MakeHost valueOf(int value) {
		switch(value) {
		case 1: return USER;
		case 2: return ENLIST;
		case 3: return HOST;
		default: throw new AssertionError("Unknown value:"+value);
		}
	}
		
}
