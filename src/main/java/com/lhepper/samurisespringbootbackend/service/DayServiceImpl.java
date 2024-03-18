package com.lhepper.samurisespringbootbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.repository.DayRepository;
import com.lhepper.samurisespringbootbackend.repository.TimeBlockRepository;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    TimeBlockRepository timeBlockRepository;

    @Override
    public Day getDayByID(Long id) throws ResourceNotFoundException {
        Optional<Day> foundDay = dayRepository.findById(id);
        return foundDay.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void createDay(Day day) {
        dayRepository.save(day);
    }

    @Override
    public Day updateDay(long id, Day newDay) {
        Day oldDay = dayRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        oldDay.setDate(newDay.getDate());
        oldDay.setdayLength(newDay.getdayLength());
        oldDay.setdayStartTime(newDay.getdayStartTime());

        timeBlockRepository.deleteByDay(oldDay);
        oldDay.prePersist();
        return dayRepository.save(oldDay);
    }
}
