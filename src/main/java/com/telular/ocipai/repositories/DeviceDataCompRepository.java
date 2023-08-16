package com.telular.ocipai.repositories;

import org.springframework.stereotype.Repository;

import com.telular.ocipai.entity.DeviceDataComp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DeviceDataCompRepository extends JpaRepository<DeviceDataComp,Long> {
	@Query(nativeQuery =true,value="select distinct device_id from org_device_v where serial_num =:serialNum")
	long getdevice_id(String serialNum); 
}  
