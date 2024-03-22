package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.TaskList;
import com.lhepper.samurisespringbootbackend.pojo.TestTaskList;

public interface TaskListService {
    
    void createTaskList(TaskList taskList);
    TaskList getTaskListById(long id);
    void deleteTaskList(long id);
    void deleteByTimeBlockId(long id);
    TestTaskList getTaskListWithItems(String name);

}
