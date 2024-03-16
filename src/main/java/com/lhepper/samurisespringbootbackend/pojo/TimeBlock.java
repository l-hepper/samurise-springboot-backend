package com.lhepper.samurisespringbootbackend.pojo;

public class TimeBlock {
    private String name;
    private String startTime;
    private String endTime;
    private boolean scheduled;
    private boolean startOfBlock;
    private String color;

    public TimeBlock(String name, String startTime, String endTime, boolean scheduled, boolean startOfBlock,
            String color) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduled = scheduled;
        this.startOfBlock = startOfBlock;
        this.color = color;
    }

    public TimeBlock() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    public boolean isStartOfBlock() {
        return startOfBlock;
    }

    public void setStartOfBlock(boolean startOfBlock) {
        this.startOfBlock = startOfBlock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
