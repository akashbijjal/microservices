package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.employee;

public interface emprepository extends MongoRepository<employee, Long>{

}
