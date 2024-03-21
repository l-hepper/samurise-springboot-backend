package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.TaskList;

public interface TaskListService {
    
    void createTaskList(TaskList taskList);
    TaskList getTaskListById(long id);
    void deleteTaskList(long id);
    void deleteByTimeBlockId(long id);
    TaskList getTaskListWithItems(String name);

}
