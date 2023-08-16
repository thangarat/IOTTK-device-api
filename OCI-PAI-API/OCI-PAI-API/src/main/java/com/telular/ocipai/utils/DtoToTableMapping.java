package com.telular.ocipai.utils;
import com.telular.ocipai.entity.DeviceDataComp;
import com.telular.ocipai.service.DeviceDataCompService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HexFormat;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.telular.ocipai.dto.OciResponse;

@Component
public class DtoToTableMapping {
    
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DeviceDataCompService.class);
    public DeviceDataComp mapOciPushDtoToDeviceDataComp(OciResponse item,Long msgId,Long deviceID)
    {
        DeviceDataComp deviceDataComp;
		try {
			deviceDataComp = new DeviceDataComp();
			deviceDataComp.setMsgId(msgId);
			deviceDataComp.setDeviceId(deviceID);
			deviceDataComp.setDataDt(convertStringToLocalDateTime(item.dataDt));
			deviceDataComp.setDevNbr(item.devNum);
			deviceDataComp.setDevMsgId((long)0);
			deviceDataComp.setDataSz((long)item.data.length()/2);
			//deviceDataComp.setData((item.data.getBytes()));
			deviceDataComp.setData(HexFormat.of().parseHex(item.data));
			deviceDataComp.setLastChgDt(convertStringToLocalDateTime(item.lastChgDt));
			return deviceDataComp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
        return null;
    }
    
    public LocalDateTime convertStringToLocalDateTime(String date)
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return LocalDateTime.parse(date, formatter);
    }
}
