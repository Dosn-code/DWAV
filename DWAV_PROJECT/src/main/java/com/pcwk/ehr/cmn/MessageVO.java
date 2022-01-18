package com.pcwk.ehr.cmn;

public class MessageVO extends DTO {
	/**메시지 ID */
	private String msgId;
	
	/**메시지 */
	private String msgContents;
	
	
	public MessageVO() {}


	public MessageVO(String msgId, String msgContents) {
		super();
		this.msgId = msgId;
		this.msgContents = msgContents;
	}


	public String getMsgId() {
		return msgId;
	}


	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}


	public String getMsgContents() {
		return msgContents;
	}


	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}


	@Override
	public String toString() {
		return "MessageVO [msgId=" + msgId + ", msgContents=" + msgContents + ", toString()=" + super.toString() + "]";
	}
	
	
}
