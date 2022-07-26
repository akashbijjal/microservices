package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.employee;
import com.example.demo.repository.emprepository;


@RestController
@RequestMapping("/emp")
public class controller {
	
    @Autowired
	private emprepository repo;
	
    @GetMapping("/Employees")
	public List<employee> allEmployee() 
	{
		List<employee> list=new ArrayList<>();
		Iterator<employee> it=repo.findAll().iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
		
	}
	@GetMapping("/Employee/{id}")
	public employee getEmployee(@PathVariable Long id) {
		return repo.findById(id).get();
	}
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody employee employee) {
		repo.save(employee);
	}
}
