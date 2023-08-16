package com.telular.ocipai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telular.ocipai.entity.Org;
import com.telular.ocipai.repositories.OrgRepository;

@Service
public class OrgService {
 	@Autowired
	OrgRepository orgRepo;
 	
 	public List<Org> getAllOrg()
 	{
 		List<Org> org = orgRepo.findAll();
 		return org;
 	}
 	
 	public Optional<Org> getByOrgid( int id)
 	{
 		Optional<Org> org = orgRepo.findById(id);
 		return org;
 	}
 	
 	public void createUpdateOrg(Org org)
 	{
 		orgRepo.save(org);
 	}
 	
 	public void deleteOrg(Org org)
 	{
 		orgRepo.delete(org);
 	}
 	
}
