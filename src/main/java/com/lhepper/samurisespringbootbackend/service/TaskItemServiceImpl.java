package com.lhepper.samurisespringbootbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.pojo.TaskItemInformation;
import com.lhepper.samurisespringbootbackend.repository.TaskItemRepository;

@Service
public class TaskItemServiceImpl implements TaskItemService {

    @Autowired
    TaskItemRepository taskItemRepository;

    @Autowired
    TaskListService taskListService;

    @Override
    public void createTaskItem(TaskItemInformation taskItemInformation) {
        TaskItem taskItem = new TaskItem(taskItemInformation.getName(),
                taskListService.getTaskListById(taskItemInformation.getTaskListId()));
        taskItemRepository.save(taskItem);
    }

}
