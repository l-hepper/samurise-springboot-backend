package com.lhepper.samurisespringbootbackend.pojo;

public class TimeBlockEventInformation {
    private String name;
    private int length;

    private long timeBlockId;

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
