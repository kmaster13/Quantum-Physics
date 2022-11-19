package com.ssau.tk.quantumphysics.models;

import static com.ssau.tk.quantumphysics.models.Constants.*;
import static java.lang.Math.PI;

public class RezerfordModel {
    private static double func(double b) {
        return 57 * 2 * (PI / 2 - (Math.atan((b * 2 * E * evDj) / (k * Q1 * Q2))));
    }

    public static double angle(double b, int degree) {
        return func(b * Math.pow(10, degree - 2));
    }
}