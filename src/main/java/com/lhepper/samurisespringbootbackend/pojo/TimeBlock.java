package com.lhepper.samurisespringbootbackend.pojo;

public class TimeBlock {
    private String name;
    private String startTime;
    private String endTime;
    private boolean scheduled;
    private boolean startOfBlock;
    private String color;

    public TimeBlock(String startTime) {
        this.name = null;
        this.startTime = startTime;
        this.endTime = calculateEndTime(startTime);
        this.scheduled = false;
        this.startOfBlock = false;
        this.color = "gray";
    }

    public String calculateEndTime(String startTime) {
        if (startTime.length() == 4) {
            if (startTime.substring(2).equals("45")) {
                int nextHour = Integer.valueOf(startTime.substring(0, 1)) + 1;
                startTime = nextHour + ":00";
            } else {
                String pain = startTime.substring(2);
                int painInt = Integer.valueOf(pain) + 15;
                startTime = startTime.substring(0, 2) + painInt;
            }
        } else {
            if (startTime.substring(3).equals("45")) {
                startTime = (Integer.valueOf(startTime.substring(0, 2)) + 1) + ":00";
            } else {
                startTime = startTime.substring(0, 2) + ":" + (Integer.valueOf(startTime.substring(3)) + 15);
            }
        }
        return startTime;
    }

    public TimeBlock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getstartTime() {
        return startTime;
    }

    public void setstartTime(String startTime) {
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
