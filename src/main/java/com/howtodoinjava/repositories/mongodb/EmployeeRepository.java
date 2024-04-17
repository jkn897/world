package com.howtodoinjava.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.howtodoinjava.model.mongo.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
