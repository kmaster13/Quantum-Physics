package com.ssau.tk.quantumphysics.models;

import java.util.ArrayList;
import java.util.List;

import static com.ssau.tk.quantumphysics.models.Constants.*;

public class ProbabilityDensity {

    private static final List<Double> list = List.of(
            0., 1., 2., 3., 4., 5., 6., 10., 12., 20., 30., 60., 90., 120., 170.);

    public static List<Double> rutherford() {
        List<Double> newList = new ArrayList<>(list.size());

        for (double a : list) {
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

    public static List<Double> getAngleList() {
        return list;
    }
}
