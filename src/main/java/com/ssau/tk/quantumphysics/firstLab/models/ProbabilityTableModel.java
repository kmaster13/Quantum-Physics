package com.ssau.tk.quantumphysics.firstLab.models;

public class ProbabilityTableModel {

    private String angle;

    private String prob;

    private String realProb;

    private String thompsonProb;

    public ProbabilityTableModel(String angle, String rutherfordProb, String thompsonProb, String realProb) {
        this.angle = angle;
        this.prob = rutherfordProb;
        this.realProb = realProb;
        this.thompsonProb = thompsonProb;
    }

    public String getAngle() {
        return angle;
    }

    public String getRutherfordProb() {
        return prob;
    }

    public String getRealProb() {
        return realProb;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public void setRutherfordProb(String prob) {
        this.prob = prob;
    }

    public void setRealProb(String realProb) {
        this.realProb = realProb;
    }

    public String getThompsonProb() {
        return thompsonProb;
    }

    public void setThompsonProb(String thompsonProb) {
        this.thompsonProb = thompsonProb;
    }
}
