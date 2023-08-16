package com.telular.ocipai.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telular.ocipai.dto.OciResponse;
import com.telular.ocipai.dto.PushItemToRdsApiResponse;
import com.telular.ocipai.entity.DeviceDataComp;
import com.telular.ocipai.service.DeviceDataCompService;
import com.telular.ocipai.utils.DtoToTableMapping;

@RestController
public class DeviceDataCompController 
{
	@Autowired
	public DeviceDataCompService service;
	@Autowired
	public DtoToTableMapping dto;

	
	public List<PushItemToRdsApiResponse> responseList;
	DeviceDataComp item;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DeviceDataCompService.class);
	
	@PostMapping("/device/message")
	public List<PushItemToRdsApiResponse> pushItemToRDS(@RequestBody List<OciResponse> ociresponse)
	{	
		PushItemToRdsApiResponse response = new PushItemToRdsApiResponse();	
		responseList = new ArrayList<>();
		for (OciResponse res : ociresponse)
		{		
			
			try 
			{
	 			Long deviceId = service.getdevice_id(res.serialNum) ;
				Long msgId = service.getRowCount();
				item =  dto.mapOciPushDtoToDeviceDataComp(res,msgId,deviceId);
				if(item.dataDt != null && item.dataSz !=null && item.deviceId !=null && item.devMsgId != null && item.devNbr != null && item.lastChgDt !=null)
				{
					service.saveItem(item);
					response.setAssetId(res.assetId);
					response.setMsgId(item.msgId);
                    response.setStatusPassOrFail("success");
					responseList.add(response);		
					response = new PushItemToRdsApiResponse();
				}
			} 
			catch (Exception e) 
			{
				logger.error(e.getMessage()+" asset id: "+res.assetId);
				response.setAssetId(res.assetId);
				response.setMsgId(item.msgId);
				response.setStatusPassOrFail("failed");
				responseList.add(response);
				response = new PushItemToRdsApiResponse();
				//return new ResponseEntity<>(responseList, HttpStatus.BAD_REQUEST);
			}
		}
		
		return responseList; 
	}
	@GetMapping("/health-check")
        public String getHealthCheck() {
    		return "Success";
	}
}
