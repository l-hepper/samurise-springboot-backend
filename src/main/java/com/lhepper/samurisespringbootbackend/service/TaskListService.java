package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.TaskList;

interface TaskListService {
    
    void createTaskList(TaskList taskList);
    TaskList getTaskListById(long id);

}
