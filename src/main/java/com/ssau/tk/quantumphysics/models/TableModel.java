package com.ssau.tk.quantumphysics.models;

public class TableModel {
    private double value;

    private double angle;

    public TableModel(double value, double angle) {
        this.value = value;
        this.angle = angle;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}