package com.lhepper.samurisespringbootbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.entity.TaskList;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.pojo.TaskItemInfo;
import com.lhepper.samurisespringbootbackend.repository.TaskItemRepository;

@Service
public class TaskItemServiceImpl implements TaskItemService {

    @Autowired
    TaskItemRepository taskItemRepository;

    @Autowired
    TaskListService taskListService;

    @Override
    public void deleteTaskItem(long id) {
        taskItemRepository.deleteById(id);
    }

    @Override
    public TaskItem setTaskItemToComplete(long id) {
        TaskItem taskItem = taskItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        if (!taskItem.isComplete()) {
            taskItem.setComplete(true);
        } else {
            taskItem.setComplete(false);
        }
        return taskItemRepository.save(taskItem);
    }

    @Override
    public TaskItem setTaskItemToUncomplete(long id) {
        TaskItem taskItem = taskItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        taskItem.setComplete(false);
        return taskItemRepository.save(taskItem);
    }

    @Override
    public TaskItem createTaskItem(TaskItemInfo taskItemInfo) {
        TaskList taskList = taskListService.getTaskListById(taskItemInfo.getTaskListId());
        TaskItem newTask = new TaskItem(taskItemInfo.getName(), taskList);
        taskItemRepository.save(newTask);
        return newTask;
    }

    @Override
    public List<TaskItem> getTaskItemsByListId(long id) {
        List<TaskItem> tasks = taskItemRepository.getTaskItems(id);
        return tasks;
    }

}
