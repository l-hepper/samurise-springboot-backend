package com.lhepper.samurisespringbootbackend.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "day_object")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private int dayStartTime;
    private int dayLength;
    private List<TimeBlock> timeBlockPlanner;
    private List<TaskList> taskListsForTheDay;

    public Day() {
        this.date = new Date();
        this.dayStartTime = 9;
        this.dayLength = 8;
        this.timeBlockPlanner = populateTimeBlockPlanner(dayStartTime, dayLength);
        this.taskListsForTheDay = new ArrayList<>();
        System.out.println("==== DAY ID : " + id + " ====");
    }

    // when a new day is created the timeBlockPlanner structure is updated to
    // reflect an empty, non-scheduled day
    public List<TimeBlock> populateTimeBlockPlanner(int dayStartTime, int dayLength) {

        List<TimeBlock> result = new ArrayList<>();

        String[] timeBlockEndings = { ":00", ":15", ":30", ":45" };
        for (int i = 0; i <= dayLength; i++) {
            for (int j = 0; j < 4; j++) {
                result.add(new TimeBlock((int) (dayLength + i) + timeBlockEndings[j]));
            }
        }

        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getdayStartTime() {
        return dayStartTime;
    }

    public void setdayStartTime(int dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public int getdayLength() {
        return dayLength;
    }

    public void setdayLength(int dayLength) {
        this.dayLength = dayLength;
    }

    public List<TimeBlock> gettimeBlockPlanner() {
        return timeBlockPlanner;
    }

    public void settimeBlockPlanner(List<TimeBlock> timeBlockPlanner) {
        this.timeBlockPlanner = timeBlockPlanner;
    }

    public List<TaskList> getTaskListsForTheDay() {
        return taskListsForTheDay;
    }

    public void setTaskListArray(List<TaskList> taskListsForTheDay) {
        this.taskListsForTheDay = taskListsForTheDay;
    }
}
