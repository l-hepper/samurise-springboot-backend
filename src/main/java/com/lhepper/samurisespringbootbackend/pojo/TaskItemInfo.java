package com.lhepper.samurisespringbootbackend.pojo;

public class TaskItemInfo {
    private long id;
    private String name;
    private boolean complete = false;
    private long taskListId;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    @Override
    public String toString() {
        return "TaskItemInfo [name=" + name + ", complete=" + complete + ", taskListId=" + taskListId + "]";
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
