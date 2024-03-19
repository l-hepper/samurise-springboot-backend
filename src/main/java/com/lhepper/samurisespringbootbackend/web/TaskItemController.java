package com.lhepper.samurisespringbootbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.pojo.TaskItemInformation;
import com.lhepper.samurisespringbootbackend.service.TaskItemService;

@RestController
public class TaskItemController {
    
    @Autowired
    TaskItemService taskItemService;

    @PostMapping("create-task-item")
    public ResponseEntity<HttpStatus> createTaskItem(@RequestBody TaskItemInformation taskItemInformation) {
        taskItemService.createTaskItem(taskItemInformation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
