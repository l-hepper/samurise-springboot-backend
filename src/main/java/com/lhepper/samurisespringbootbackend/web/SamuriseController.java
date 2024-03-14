package com.lhepper.samurisespringbootbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.service.SamuriseService;

@RestController
public class SamuriseController {

    @Autowired
    SamuriseService samuriseService;

    @GetMapping(value = "/")
    public String testRunning() {
        return "samurise backend";
    }
}
