package com.lhepper.samurisespringbootbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.entity.TimeBlock;
import com.lhepper.samurisespringbootbackend.service.TimeBlockService;

@RestController
public class TimeBlockController {

    @Autowired
    TimeBlockService timeBlockService;

    @GetMapping("/get-timeblock/{id}")
    public ResponseEntity<TimeBlock> getTimeBlock(@PathVariable long id) {
        TimeBlock timeBlock = timeBlockService.getTimeBlockByID(id);
        return new ResponseEntity<>(timeBlock, HttpStatus.OK);
    }

    @PostMapping("create-timeblock")
    public ResponseEntity<HttpStatus> createTimeBlock(@RequestBody TimeBlock timeBlock) {
        timeBlockService.createTimeBlock(timeBlock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}