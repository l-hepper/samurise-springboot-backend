package com.lhepper.samurisespringbootbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping(value="/")
    public String testRunning() {
        return "testing";
    }
}
