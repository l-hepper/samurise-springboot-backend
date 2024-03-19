package com.lhepper.samurisespringbootbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
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

    @Override
    public void deleteTaskItem(long id) {
        taskItemRepository.deleteById(id);
    }

    @Override
    public TaskItem setTaskItemToComplete(long id) {
        TaskItem taskItem = taskItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        taskItem.setComplete(true);
        return taskItemRepository.save(taskItem);
    }

    @Override
    public TaskItem setTaskItemToUncomplete(long id) {
        TaskItem taskItem = taskItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        taskItem.setComplete(false);
        return taskItemRepository.save(taskItem);
    }

}
