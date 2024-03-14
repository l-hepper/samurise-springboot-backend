package com.lhepper.samurisespringbootbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.pojo.TestObject;
import com.lhepper.samurisespringbootbackend.service.SamuriseService;

@RestController
public class SamuriseController {

    @Autowired
    SamuriseService samuriseService;

    @GetMapping("/thedoc/{index}")
    public ResponseEntity<String> getAWord(@PathVariable int index) {
        String requestedWord = samuriseService.getWordByIndex(index);
        return new ResponseEntity<>(requestedWord, HttpStatus.OK);
    }

}
