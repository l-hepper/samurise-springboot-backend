package com.lhepper.samurisespringbootbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.pojo.TaskItemInfo;
import com.lhepper.samurisespringbootbackend.service.TaskItemService;

@RestController
public class TaskItemController {
    
    @Autowired
    TaskItemService taskItemService;

    @PostMapping("create-task-item")
    public ResponseEntity<HttpStatus> createTaskItem(@RequestBody TaskItemInfo taskItemInfo) {
        System.out.println("TASKITEMINFO" + taskItemInfo);
        taskItemService.createTaskItem(taskItemInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete-task-item/{id}")
    public ResponseEntity<HttpStatus> deleteTaskItem(@PathVariable long id) {
        taskItemService.deleteTaskItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("complete-task-item/{id}")
    public ResponseEntity<TaskItem> setTaskItemToComplete(@PathVariable long id) {
        TaskItem taskItem = taskItemService.setTaskItemToComplete(id);
        return new ResponseEntity<>(taskItem, HttpStatus.ACCEPTED);
    }

    @PutMapping("uncomplete-task-item/{id}")
    public ResponseEntity<TaskItem> setTaskItemToUncomplete(@PathVariable long id) {
        TaskItem taskItem = taskItemService.setTaskItemToUncomplete(id);
        return new ResponseEntity<>(taskItem, HttpStatus.ACCEPTED);
    }

    @GetMapping("get-task-items/{id}")
    public ResponseEntity<List<TaskItem>> getTasksItems(@PathVariable long id) {
        List<TaskItem> taskItems = taskItemService.getTaskItemsByListId(id);
        return new ResponseEntity<>(taskItems, HttpStatus.OK);
    }
 }
