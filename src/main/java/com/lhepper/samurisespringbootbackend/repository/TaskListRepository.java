package com.lhepper.samurisespringbootbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhepper.samurisespringbootbackend.entity.TaskList;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {
    
}
