package com.ssau.tk.quantumphysics.models;

public class ProbabilityTableModel {

    private double angle;

    private double prob;

    private double realProb;

    public ProbabilityTableModel(double angle, double prob, double realProb) {
        this.angle = angle;
        this.prob = prob;
        this.realProb = realProb;
    }

    public double getAngle() {
        return angle;
    }

    public double getProb() {
        return prob;
    }

    public double getRealProb() {
        return realProb;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public void setRealProb(double realProb) {
        this.realProb = realProb;
    }
}
