package com.lhepper.samurisespringbootbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;

public interface TaskItemRepository extends CrudRepository<TaskItem, Long>{
    
}
