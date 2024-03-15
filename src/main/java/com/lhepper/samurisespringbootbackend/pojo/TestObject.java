package com.lhepper.samurisespringbootbackend.pojo;

public class TestObject {
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
