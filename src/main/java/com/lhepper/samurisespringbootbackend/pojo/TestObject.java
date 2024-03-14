package com.lhepper.samurisespringbootbackend.pojo;

public class TestObject {
    private String violenceField;
    private String speedField;
    private String momentumField;

    public TestObject(String violenceField, String speedField, String momentumField) {
        this.violenceField = violenceField;
        this.speedField = speedField;
        this.momentumField = momentumField;
    }

    public String getViolence() {
        return violenceField;
    }

    public String getSpeed() {
        return speedField;
    }

    public String getMomentum() {
        return momentumField;
    }
}
