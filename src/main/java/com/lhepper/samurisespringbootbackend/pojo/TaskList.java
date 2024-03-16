package com.lhepper.samurisespringbootbackend.pojo;

public class TaskList {
    private String name;
    private TaskItem[] taskItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskItem[] getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(TaskItem[] taskItems) {
        this.taskItems = taskItems;
    }
}
