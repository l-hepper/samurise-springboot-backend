package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.pojo.TaskItemInformation;

public interface TaskItemService {
    void createTaskItem(TaskItemInformation taskItemInformation);
    void deleteTaskItem(long id);
    TaskItem setTaskItemToComplete(long id);
    TaskItem setTaskItemToUncomplete(long id);
}
