package com.lhepper.samurisespringbootbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.entity.TaskList;
import com.lhepper.samurisespringbootbackend.pojo.TestTaskList;
import com.lhepper.samurisespringbootbackend.service.TaskListService;

@RestController
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    @GetMapping("get-task-list/{name}")
    public ResponseEntity<TestTaskList> getTaskList(@PathVariable String name) {
        TestTaskList taskList = taskListService.getTaskListWithItems(name);
        System.out.println("In controller: " + taskList);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }
    
}
