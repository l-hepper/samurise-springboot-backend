package com.lhepper.samurisespringbootbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.entity.TimeBlock;
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

    @PostMapping("create-day")
    public ResponseEntity<HttpStatus> createCurrentDay(@RequestBody Day day) {
        dayService.createDay(day);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("update-day/{id}")
    public ResponseEntity<Day> updateDay(@PathVariable long id, @RequestBody Day day) {
        Day updatedDay = dayService.updateDay(id, day);
        return new ResponseEntity<>(updatedDay, HttpStatus.ACCEPTED);
    }

}
