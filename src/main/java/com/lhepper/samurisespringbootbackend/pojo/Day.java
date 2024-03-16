package com.lhepper.samurisespringbootbackend.pojo;

import java.util.Date;

public class Day {
    private Date date;
    private int dayStart;
    private int dayLength;
    private TimeBlock[] timeBlockArray;
    private TaskList[] taskListArray;

    public Day(Date date, int dayStart, int dayLength, TimeBlock[] timeBlockArray) {
        this.date = date;
        this.dayStart = dayStart;
        this.dayLength = dayLength;
        this.timeBlockArray = timeBlockArray;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDayStart() {
        return dayStart;
    }

    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }

    public int getDayLength() {
        return dayLength;
    }

    public void setDayLength(int dayLength) {
        this.dayLength = dayLength;
    }

    public TimeBlock[] getTimeBlockArray() {
        return timeBlockArray;
    }

    public void setTimeBlockArray(TimeBlock[] timeBlockArray) {
        this.timeBlockArray = timeBlockArray;
    }

    public TaskList[] getTaskListArray() {
        return taskListArray;
    }

    public void setTaskListArray(TaskList[] taskListArray) {
        this.taskListArray = taskListArray;
    }
}
