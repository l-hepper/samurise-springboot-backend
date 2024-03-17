package com.lhepper.samurisespringbootbackend.entity;

public class TaskItem {
    private String name;
    private boolean complete;

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
}
