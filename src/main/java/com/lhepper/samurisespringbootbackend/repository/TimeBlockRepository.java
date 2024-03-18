package com.lhepper.samurisespringbootbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhepper.samurisespringbootbackend.entity.TimeBlock;

public interface TimeBlockRepository extends CrudRepository<TimeBlock, Long>{
    
}
