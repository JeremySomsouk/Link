package com.jimmy.link.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Position {

    private double lon;
    private double lat;

    public String getCounterKey() {
        return Double.toString(lon) + "|" + Double.toString(lat);
    }

    public static String getCounterKey(double lon, double lat) {
        return Double.toString(lon) + "|" + Double.toString(lat);
    }
}
