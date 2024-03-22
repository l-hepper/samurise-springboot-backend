package com.lhepper.samurisespringbootbackend.service;

import java.util.List;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.pojo.TaskItemInfo;

public interface TaskItemService {
    TaskItem createTaskItem(TaskItemInfo taskItemInfo);
    void deleteTaskItem(long id);
    TaskItem setTaskItemToComplete(long id);
    TaskItem setTaskItemToUncomplete(long id);
    List<TaskItem> getTaskItemsByListId(long id);
}
