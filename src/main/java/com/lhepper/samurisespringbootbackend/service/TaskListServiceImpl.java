package com.lhepper.samurisespringbootbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TaskList;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.repository.TaskListRepository;

@Service
public class TaskListServiceImpl implements TaskListService {

    @Autowired
    TaskListRepository taskListRepository;

    // called only by the creation of a timeblock event
    @Override
    public void createTaskList(TaskList taskList) {
        taskListRepository.save(taskList);
    }

    @Override
    public TaskList getTaskListById(long id) {
        Optional<TaskList> taskList =  taskListRepository.findById(id);
        if (taskList.isPresent()) {
            return taskList.get();
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public void deleteTaskList(long id) {
        taskListRepository.deleteById(id);
    }

    @Override
    public void deleteByTimeBlockId(long id) {
        taskListRepository.deleteByTimeBlock(id);
    }
}
