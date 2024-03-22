package com.lhepper.samurisespringbootbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.entity.TaskList;

import jakarta.transaction.Transactional;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM TaskList WHERE id = :id")
    void deleteByTimeBlock(long id);

    Optional<TaskList> findByTaskListName(String name);
}
