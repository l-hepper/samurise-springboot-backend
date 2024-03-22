package com.lhepper.samurisespringbootbackend.pojo;

public class TimeBlockEventInformation {
    private String name;
    private int length;
    private long dayID;
    private String startTime;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "TimeBlockEventInformation [name=" + name + ", length=" + length + ", dayID=" + dayID + ", startTime="
                + startTime + "]";
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
}
