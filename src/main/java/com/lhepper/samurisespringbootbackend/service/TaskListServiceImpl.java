package com.lhepper.samurisespringbootbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;
import com.lhepper.samurisespringbootbackend.entity.TaskList;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.pojo.TestTaskList;
import com.lhepper.samurisespringbootbackend.repository.TaskListRepository;

@Service
public class TaskListServiceImpl implements TaskListService {

    @Autowired
    TaskListRepository taskListRepository;

    @Autowired
    TaskItemService taskItemService;

    // called only by the creation of a timeblock event
    @Override
    public void createTaskList(TaskList taskList) {
        taskListRepository.save(taskList);
    }

    @Override
    public TaskList getTaskListById(long id) {
        Optional<TaskList> taskList = taskListRepository.findById(id);
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

    @Override
    public TestTaskList getTaskListWithItems(String name) {
        Optional<TaskList> taskListOption = taskListRepository.findByTaskListName(name);
        TaskList taskList = null;
        if (!taskListOption.isPresent()) {
            new ResourceNotFoundException(-1);
        }
        taskList = taskListOption.get();
        // System.out.println("============== "  + taskList.getTaskListName() + "======================");2
        List<TaskItem> tasks = new ArrayList<>(taskItemService.getTaskItemsByListId(taskList.getId()));
        System.out.println("In task list service : " + taskList);

        TestTaskList test = new TestTaskList(taskList.getId(), taskList.getTaskListName(), tasks);
        return test;

    }
}
