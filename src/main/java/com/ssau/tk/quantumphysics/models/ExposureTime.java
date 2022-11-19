package com.ssau.tk.quantumphysics.models;

import java.util.ArrayList;
import java.util.List;

import static com.ssau.tk.quantumphysics.models.Constants.J;
import static com.ssau.tk.quantumphysics.models.Constants.dO;

public class ExposureTime {

    public static double time(double w) {
        return 57 * (1 / (J * w * dO));
    }

    public static List<Double> angle(List<Double> newList) {
        List<Double> listik = new ArrayList<>(15);
        newList.forEach(l -> listik.add(time(l)));
        System.out.println(listik);
        return listik;
    }
}
