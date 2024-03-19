package com.lhepper.samurisespringbootbackend.pojo;

public class TaskItemInformation {
    private String name;
    private boolean complete = false;
    private long taskListId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public long getTaskListId() {
        return taskListId;
    }
    public void setTaskListId(long taskListId) {
        this.taskListId = taskListId;
    }
}
