package com.telular.ocipai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telular.ocipai.entity.Org;
import com.telular.ocipai.service.OrgService;

@RestController
public class OrgController {

	@Autowired
	private OrgService service;
	
	@GetMapping("/getAllOrg")
	public List<Org> getAllOrg()
	{
		return service.getAllOrg();
	}
	
	@GetMapping("/getByOrgId/{id}")
	public Optional<Org> getByOrgId(@PathVariable(value = "id") int id)
	{
		if(service.getByOrgid(id) != null)
			return service.getByOrgid(id);
		else
			return Optional.empty();
	}
	
	@PostMapping("/createOrg")
	public ResponseEntity<String> createOrg(@RequestBody Org org)
	{
		service.createUpdateOrg(org);
		return new ResponseEntity<>("created org", HttpStatus.OK);
	}
	
	@PutMapping("/updateOrg")
	public ResponseEntity<String> updateOrg(@RequestBody Org org)
	{
		service.createUpdateOrg(org);
		return new ResponseEntity<>("created org", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOrg")
	public ResponseEntity<String> deleteOrg(Org org)
	{
		service.deleteOrg(org);
		return new ResponseEntity<>("created org", HttpStatus.OK);
	}
	
}
