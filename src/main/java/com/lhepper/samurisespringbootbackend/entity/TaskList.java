package com.lhepper.samurisespringbootbackend.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String taskListName; // will math the block name associated with this task list

    @ManyToOne(optional = false)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Day day;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tasklist_id", referencedColumnName = "id")
    @JsonIgnore
    private List<TaskItem> taskListItems;



    @Override
    public String toString() {
        return "TaskList [id=" + id + ", name=" + taskListName + ", day=" + day + ", taskListItems=" + taskListItems
                + "]";
    }

    public TaskList(String name, Day day) {
        this.taskListName = name;
        this.day = day;
    }

    public TaskList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDayToNull() {
        this.day = null;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String name) {
        this.taskListName = name;
    }

    public List<TaskItem> getTaskListItems() {
        return taskListItems;
    }

    public void setTaskListItems(List<TaskItem> taskItems) {
        this.taskListItems = taskItems;
    }
}
