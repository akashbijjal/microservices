package com.location.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.location.model.location;

public interface locrepository extends MongoRepository<location, Long> {

}
