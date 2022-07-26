package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.dept;

public interface deptrepository extends MongoRepository<dept, Long>{

}
