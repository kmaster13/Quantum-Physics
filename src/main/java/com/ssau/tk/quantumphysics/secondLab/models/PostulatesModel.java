package com.ssau.tk.quantumphysics.secondLab.models;

public class PostulatesModel {

    private String thesis;
    private String antithesis;

    public PostulatesModel(String thesis, String antithesis) {
        this.thesis = thesis;
        this.antithesis = antithesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public String getAntithesis() {
        return antithesis;
    }

    public void setAntithesis(String antithesis) {
        this.antithesis = antithesis;
    }
}
