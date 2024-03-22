package com.lhepper.samurisespringbootbackend.pojo;

import java.util.List;

import com.lhepper.samurisespringbootbackend.entity.TaskItem;

public class TestTaskList {
    private long id;
    private String taskListName;
    private List<TaskItem> taskListItems;

    public TestTaskList(long id, String taskListName, List<TaskItem> list) {
        this.id = id;
        this.taskListName = taskListName;
        this.taskListItems = list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public List<TaskItem> getTaskListItems() {
        return taskListItems;
    }

    public void setTaskListItems(List<TaskItem> list) {
        this.taskListItems = list;
    }

}
