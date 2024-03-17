package com.lhepper.samurisespringbootbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhepper.samurisespringbootbackend.entity.TestObject;

public interface SamuriseRepository extends CrudRepository<TestObject, Integer> {
    
}