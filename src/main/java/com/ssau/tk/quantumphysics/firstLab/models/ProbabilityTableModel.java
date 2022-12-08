package com.ssau.tk.quantumphysics.firstLab.models;

public class ProbabilityTableModel {

    private double angle;

    private double prob;

    private double realProb;

    private double thompsonProb;

    public ProbabilityTableModel(double angle, double rutherfordProb, double thompsonProb, double realProb) {
        this.angle = angle;
        this.prob = rutherfordProb;
        this.realProb = realProb;
        this.thompsonProb = thompsonProb;
    }

    public double getAngle() {
        return angle;
    }

    public double getRutherfordProb() {
        return prob;
    }

    public double getRealProb() {
        return realProb;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setRutherfordProb(double prob) {
        this.prob = prob;
    }

    public void setRealProb(double realProb) {
        this.realProb = realProb;
    }

    public double getThompsonProb() {
        return thompsonProb;
    }

    public void setThompsonProb(double thompsonProb) {
        this.thompsonProb = thompsonProb;
    }
}
