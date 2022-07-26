package com.location.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.model.location;
import com.location.repository.locrepository;

@RestController
public class controller {
	@Autowired
	private locrepository repo;
	
    @GetMapping("/location")
	public List<location> allEmployee() 
	{
		List<location> list=new ArrayList<>();
		Iterator<location> it=repo.findAll().iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
		
	}
	@GetMapping("/location/{id}")
	public location getEmployee(@PathVariable Long id) {
		return repo.findById(id).get();
	}
	@PostMapping("/adddlocation")
	public void addEmployee(@RequestBody location loc) {
		repo.save(loc);
	}
}
