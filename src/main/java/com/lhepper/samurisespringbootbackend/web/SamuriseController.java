package com.lhepper.samurisespringbootbackend.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.pojo.Day;
import com.lhepper.samurisespringbootbackend.pojo.TestObject;
import com.lhepper.samurisespringbootbackend.service.SamuriseService;

@RestController
public class SamuriseController {

    @Autowired
    SamuriseService samuriseService;

    // testing only
    @GetMapping("/thedoc/{index}")
    public ResponseEntity<TestObject> getAnObject(@PathVariable int index) {
        TestObject requestedObject = samuriseService.getObjectByIndex(index);
        return new ResponseEntity<>(requestedObject, HttpStatus.OK);
    }

    // testing only
    @PostMapping("/createdoc")
    public ResponseEntity<HttpStatus> createDoc(@RequestBody TestObject testObject) {
        samuriseService.saveObject(testObject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getCurrentDay/{id}")
    public ResponseEntity<Day> getCurrentDay(@PathVariable UUID id) {
        Day day = samuriseService.getDayByID(id);
        return new ResponseEntity<>(day, HttpStatus.OK);
    }
}
