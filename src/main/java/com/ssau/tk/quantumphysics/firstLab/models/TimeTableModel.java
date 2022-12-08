package com.ssau.tk.quantumphysics.firstLab.models;

public class TimeTableModel {

    private double angle;

    private double probRuther;

    private double timeRuther;

    private double probTomp;

    private double timeTomp;

    public TimeTableModel(double angle, double probRuther, double timeRuther, double probTomp, double timeTomp) {
        this.angle = angle;
        this.probRuther = probRuther;
        this.timeRuther = timeRuther;
        this.probTomp = probTomp;
        this.timeTomp = timeTomp;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getProbRuther() {
        return probRuther;
    }

    public void setProbRuther(double probRuther) {
        this.probRuther = probRuther;
    }

    public double getTimeRuther() {
        return timeRuther;
    }

    public void setTimeRuther(double timeRuther) {
        this.timeRuther = timeRuther;
    }

    public double getProbTomp() {
        return probTomp;
    }

    public void setProbTomp(double probTomp) {
        this.probTomp = probTomp;
    }

    public double getTimeTomp() {
        return timeTomp;
    }

    public void setTimeTomp(double timeTomp) {
        this.timeTomp = timeTomp;
    }
}
