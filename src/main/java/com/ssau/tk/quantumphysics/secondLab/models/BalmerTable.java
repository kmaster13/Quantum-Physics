package com.ssau.tk.quantumphysics.secondLab.models;

public class BalmerTable {

    private String name;

    private Integer N;

    private String realProb;

    private String thompsonProb;

    public BalmerTable(String angle, String rutherfordProb, String thompsonProb, String realProb) {
        this.name = name;
        this.N = N;
    }

    public String getName() {
        return name;
    }

    public Integer getN() {
        return N;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setN(Integer N) {
        this.N = N;
    }


}
