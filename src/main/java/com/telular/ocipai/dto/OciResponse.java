package com.telular.ocipai.dto;

import lombok.Data;

@Data
public class OciResponse
{
	public String assetId;
    public String serialNum;
	public String dataDt;
	public String lastChgDt;
	public long devNum;
	public String data;
}
