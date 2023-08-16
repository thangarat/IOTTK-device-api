package com.telular.ocipai.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="device_data_comp")
public class DeviceDataComp 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="msg_id")
	public Long msgId;
	@Column(name="device_id")
	public Long deviceId;
	@Column(name="data_dt")
	public LocalDateTime  dataDt;
	@Column(name="dev_nbr")
	public Long devNbr;
	@Column(name="dev_msg_id")
	public Long devMsgId;
	@Column(name="data_sz")
	public Long dataSz;
	@Column(name="data")
	public byte[] data;
	@Column(name="last_chg_dt")
	public LocalDateTime  lastChgDt;
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		 this.msgId =msgId;
	}
	
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public LocalDateTime getDataDt() {
		return dataDt;
	}
	public void setDataDt(LocalDateTime dataDt) {
		this.dataDt = dataDt;
	}
	public Long getDevNbr() {
		return devNbr;
	}
	public void setDevNbr(long devNum) {
		this.devNbr = devNum;
	}
	public Long getDevMsgId() {
		return devMsgId;
	}
	public void setDevMsgId(Long devMsgId) {
		this.devMsgId = devMsgId;
	}
	public Long getDataSz() {
		return dataSz;
	}
	public void setDataSz(Long dataSz) {
		this.dataSz = dataSz;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public LocalDateTime getLastChgDt() {
		return lastChgDt;
	}
	public void setLastChgDt(LocalDateTime lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
}
