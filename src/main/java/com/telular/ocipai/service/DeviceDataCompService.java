package com.telular.ocipai.service;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telular.ocipai.entity.DeviceDataComp;
import com.telular.ocipai.repositories.DeviceDataCompRepository;

@Service
public class DeviceDataCompService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DeviceDataCompService.class);
	
	@Autowired
	public DeviceDataCompRepository repo;
	
	public void saveItem(DeviceDataComp deviceDataComp )
	{
//		try {
			repo.save(deviceDataComp);
			logger.info("inserted msg_id" +deviceDataComp.deviceId);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error(e.getMessage());
//		}
	}
	public long getRowCount()
	{
		return repo.count()+ 1;
	}
	
	public Long getdevice_id(String serialNum)
	{

		return repo.getdevice_id(serialNum);
	}

	

}
