package com.lhepper.samurisespringbootbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TimeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name ="day_id", referencedColumnName = "id")
    private Day day;

    private String name;

    @Column(name = "start_time")
    private String startTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "end_time")
    private String endTime;
    private boolean scheduled;

    @Column(name = "start_of_block")
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

    public TimeBlock() {
    }

    public void setDay(Day day) {
        this.day = day;
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
