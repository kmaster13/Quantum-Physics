package com.ssau.tk.quantumphysics.firstLab.models;

public class TimeTableModel {

    private String angle;

    private String probRuther;

    private String timeRuther;

    private String probTomp;

    private String timeTomp;

    public TimeTableModel(String angle, String probRuther, String timeRuther, String probTomp, String timeTomp) {
        this.angle = angle;
        this.probRuther = probRuther;
        this.timeRuther = timeRuther;
        this.probTomp = probTomp;
        this.timeTomp = timeTomp;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getProbRuther() {
        return probRuther;
    }

    public void setProbRuther(String probRuther) {
        this.probRuther = probRuther;
    }

    public String getTimeRuther() {
        return timeRuther;
    }

    public void setTimeRuther(String timeRuther) {
        this.timeRuther = timeRuther;
    }

    public String getProbTomp() {
        return probTomp;
    }

    public void setProbTomp(String probTomp) {
        this.probTomp = probTomp;
    }

    public String getTimeTomp() {
        return timeTomp;
    }

    public void setTimeTomp(String timeTomp) {
        this.timeTomp = timeTomp;
    }
}
