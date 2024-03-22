package com.lhepper.samurisespringbootbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;

import jakarta.transaction.Transactional;

public interface TaskItemRepository extends CrudRepository<TaskItem, Long>{
    
    @Transactional
    @Query("SELECT t FROM TaskItem t WHERE t.taskList.id = :id")
    List<TaskItem> getTaskItems(long id);
}
