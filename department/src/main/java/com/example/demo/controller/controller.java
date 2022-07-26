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

import com.example.demo.model.dept;
import com.example.demo.repository.deptrepository;


@RestController
@RequestMapping("/dept")
public class controller {
	   @Autowired
		private deptrepository repo;
		
	    @GetMapping("/department")
		public List<dept> allEmployee() 
		{
			List<dept> list=new ArrayList<>();
			Iterator<dept> it=repo.findAll().iterator();
			while(it.hasNext()) {
				list.add(it.next());
			}
			return list;
			
		}
		@GetMapping("/department/{id}")
		public dept getEmployee(@PathVariable Long id) {
			return repo.findById(id).get();
		}
		@PostMapping("/adddept")
		public void addEmployee(@RequestBody dept department) {
			repo.save(department);
		}
}
