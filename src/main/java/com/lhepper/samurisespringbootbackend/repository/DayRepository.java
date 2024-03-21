package com.lhepper.samurisespringbootbackend.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lhepper.samurisespringbootbackend.entity.Day;

import jakarta.transaction.Transactional;

public interface DayRepository extends CrudRepository<Day, Long> {

    @Transactional
    @Query("SELECT d FROM Day d WHERE d.date = :date")
    Optional<Day> getDayByDate(@Param("date") String date);
}
