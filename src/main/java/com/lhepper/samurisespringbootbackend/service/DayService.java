package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;

public interface DayService {

    Day getDayByID(Long id) throws ResourceNotFoundException;
    void createDay(Day day);
    Day updateDay(long id, Day day);

}