package com.lhepper.samurisespringbootbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// used for testing only
@Entity
public class TestObject {

    @Id
    private int id = 123;

    private String violenceField;
    private String speedField;
    private String momentumField;

    public String getViolence() {
        return violenceField;
    }

    public String getSpeed() {
        return speedField;
    }

    public String getMomentum() {
        return momentumField;
    }

    public void setViolence(String string) {
        this.violenceField = string;
    }

    public void setSpeed(String string) {
        this.speedField = string;
    }

    public void setMomentum(String string) {
        this.momentumField = string;
    }
}
