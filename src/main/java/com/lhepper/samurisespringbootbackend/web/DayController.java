package com.lhepper.samurisespringbootbackend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.service.DayService;

@RestController
public class DayController {

    @Autowired
    DayService dayService;

    @GetMapping("/get-day/{id}")
    public ResponseEntity<Day> getDay(@PathVariable long id) {
        Day day = dayService.getDayByID(id);
        return new ResponseEntity<>(day, HttpStatus.OK);
    }
}
