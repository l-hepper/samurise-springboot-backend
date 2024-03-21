package com.lhepper.samurisespringbootbackend.pojo;

public class TimeBlockEventInformation {
    private String name;
    private int length;
    private long timeBlockId;
    private long dayID;
    private long taskListId;
    private String startTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(long taskListId) {
        this.taskListId = taskListId;
    }

    public long getDayID() {
        return dayID;
    }

    public void setDayID(long dayID) {
        this.dayID = dayID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getTimeBlockId() {
        return timeBlockId;
    }

    public void setTimeBlockId(long timeBlockId) {
        this.timeBlockId = timeBlockId;
    }
}
