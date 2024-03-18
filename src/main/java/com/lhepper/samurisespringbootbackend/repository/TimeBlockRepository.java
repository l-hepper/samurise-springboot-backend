package com.lhepper.samurisespringbootbackend.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.entity.TimeBlock;

import jakarta.transaction.Transactional;

public interface TimeBlockRepository extends CrudRepository<TimeBlock, Long>{
    @Transactional
    @Modifying
    @Query("DELETE FROM TimeBlock WHERE day = :day")
    void deleteByDay(Day day);
}
