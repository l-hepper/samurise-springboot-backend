package com.lhepper.samurisespringbootbackend.entity;

import java.util.ArrayList;
import java.util.List;

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

    private String name; // will math the block name associated with this task list

    @ManyToOne(optional = false)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Day day;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tasklist_id", referencedColumnName = "id")
    private List<TaskItem> taskItems = new ArrayList<>();

    public TaskList(String name, Day day) {
        this.name = name;
        this.day = day;
    }

    public TaskList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskItem> getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(List<TaskItem> taskItems) {
        this.taskItems = taskItems;
    }
}
