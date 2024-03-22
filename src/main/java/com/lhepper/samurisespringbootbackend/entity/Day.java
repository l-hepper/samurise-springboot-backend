package com.lhepper.samurisespringbootbackend.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "day_object")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String date;

    @Override
    public String toString() {
        return "Day [id=" + id + ", date=" + date + ", dayStartTime=" + dayStartTime + ", dayLength=" + dayLength
                + ", timeBlocks=" + timeBlocks  + "]";
    }

    @Column(name = "day_start_time")
    private int dayStartTime;

    @Column(name = "day_length")
    private int dayLength;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<TimeBlock> timeBlocks = new ArrayList<>();

    public Day() {
        this.date = generateFormattedLocalDate();
        this.dayStartTime = 9;
        this.dayLength = 8;
        // this.timeBlockPlanner = populateTimeBlockPlanner(dayStartTime, dayLength);
        // this.taskListsForTheDay = new ArrayList<>();
        System.out.println("==== DAY ID : " + id + " ====");
    }

    // @PrePersist
    // public void prePersist() {
    // // Populate TimeBlock entries
    // for (int i = 0; i < 5; i++) { // Example: Creating 5 empty TimeBlock entries
    // TimeBlock timeBlock = new TimeBlock();
    // timeBlock.setDay(this);
    // // Set other properties of TimeBlock as needed
    // this.timeBlocks.add(timeBlock);
    // }
    // }

    // when a new day is created the timeBlockPlanner structure is updated to
    // reflect an empty, non-scheduled day

    @PrePersist
    public void prePersist() {
        String[] timeBlockEndings = { ":00", ":15", ":30", ":45" };
        for (int i = 0; i < dayLength; i++) {
            for (int j = 0; j < 4; j++) {
                TimeBlock newTimeBlock = new TimeBlock((int) (dayStartTime + i) + timeBlockEndings[j]);
                newTimeBlock.setDay(this);
                this.timeBlocks.add(newTimeBlock);
            }
        }
    }

    public static String generateFormattedLocalDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(formatter);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    // public List<TimeBlock> gettimeBlockPlanner() {
    // return timeBlockPlanner;
    // }

    // public void settimeBlockPlanner(List<TimeBlock> timeBlockPlanner) {
    // this.timeBlockPlanner = timeBlockPlanner;
    // }

    // public List<TaskList> getTaskListsForTheDay() {
    // return taskListsForTheDay;
    // }

    // public void setTaskListArray(List<TaskList> taskListsForTheDay) {
    // this.taskListsForTheDay = taskListsForTheDay;
    // }
}
