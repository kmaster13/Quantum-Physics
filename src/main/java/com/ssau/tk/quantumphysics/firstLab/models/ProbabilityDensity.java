package com.ssau.tk.quantumphysics.firstLab.models;

import java.util.ArrayList;
import java.util.List;

import static com.ssau.tk.quantumphysics.firstLab.models.Constants.*;

public class ProbabilityDensity {


    public static List<Double> rutherford(List<Double> angles) {
        List<Double> newList = new ArrayList<>(angles.size());

        for (double a : angles) {
            double a2 = Math.toRadians(a);
            if (a >= 10 && a <= 170) {
                newList.add(2 * Math.PI * L * n0 * Math.pow(10, 6) * Math.pow((k * Q1 * Q2) / (4 * E * evDj), 2)
                        * (Math.sin(a2) / Math.pow(Math.sin(a2 / 2), 4)));
            } else if (a >= 0 && a <= 6) {
                newList.add(Math.pow((Math.PI * O), -0.5) * Math.pow(Math.E, -1 * Math.pow(a2, 2) / O));
//                System.out.println(a + " : " + Math.pow((Math.PI * O), -0.5) * Math.pow(Math.E, -1 * Math.pow(a2, 2) / O));
            }
        }
        return newList;
    }

    public static List<Double> thompson(List<Double> angles) {
        List<Double> newList = new ArrayList<>(angles.size());

        angles.forEach(angle -> {
            double a = Math.toRadians(angle);
            newList.add(Math.pow((Math.PI * O), -0.5) * Math.pow(Math.E, -1 * Math.pow(a, 2) / O));
        });

        return newList;
    }
}
