package com.lhepper.samurisespringbootbackend.repository;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Query("SELECT t FROM TimeBlock t WHERE t.day.id = :id")
    Optional<List<TimeBlock>> getTimeBlockSchedule(long id);

    @Transactional
    @Query("SELECT t FROM TimeBlock t WHERE t.day.id = :dayId AND startTime = :startTime")
    Optional<TimeBlock> getTimeBlockByDayIdAndStartTime(long dayId, String startTime);
}
