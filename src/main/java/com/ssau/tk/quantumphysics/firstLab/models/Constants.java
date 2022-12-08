package com.ssau.tk.quantumphysics.firstLab.models;

import java.util.List;

public class Constants {
    public static final double Q1 = 3.218 * Math.pow(10, -19);
    public static final double Q2 = 1.266 * Math.pow(10, -17);
    public static final double E = 5 * Math.pow(10, 6);
    public static final double k = 9 * Math.pow(10, 9);
    public static final double evDj = 1.6 * Math.pow(10, -19);
    public static final double J = Math.pow(10 , 3);
    public static final double dO = 1;

    public static final double L = Math.pow(10, -6);
    public static final double n0 = 5.9 * Math.pow(10, 22);

    public static final double O = Math.toRadians(6.25);

    public static final List<Double> probList = List.of(
            0., 1., 2., 3., 4., 5., 6., 10., 12., 20., 30., 60., 90., 120., 170.
    );

    public static final List<Double> realProbList = List.of(
            12.296, 11.174, 6.7012, 3.4381, 1.1496, 0.81208, 0.57193, 0.14805, 0.086926, 0.018505, 0.0052309,
            0.00064983, 0.00018472, 0.000071541, 0.0000080157
    );

    public static final List<Double> timeList = List.of(
            10., 15., 20., 25., 30., 40., 50., 60., 70., 80., 90., 100., 120., 140., 170.
    );
}
