package com.telular.ocipai.dto;

public class PushItemToRdsApiResponse {
	public String assetId;
	public Long msgId;
	public String statusPassOrFail;
	
	public String getStatusPassOrFail() {
		return statusPassOrFail;
	}
	public void setStatusPassOrFail(String statusPassOrFail) {
		this.statusPassOrFail = statusPassOrFail;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

}
