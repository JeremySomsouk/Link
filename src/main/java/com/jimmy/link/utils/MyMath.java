package com.jimmy.link.utils;

import java.math.BigDecimal;

public class MyMath {

    public static double getHalfDownValue(double n) {
        if (Double.compare(n, 0.0) < 0) {
            return getHalfDownNegative(n);
        }

        return getHalfDownPositive(n);
    }

    private static double getHalfDownNegative(double n) {

        BigDecimal nRounded = BigDecimal.valueOf(n).setScale(1, BigDecimal.ROUND_HALF_UP);
        BigDecimal nRoundedCeil = BigDecimal.valueOf(Math.ceil(n));
        BigDecimal nTenth = nRoundedCeil.subtract(nRounded).abs();
        BigDecimal gap = BigDecimal.valueOf(0.5);

        if (nTenth.compareTo(BigDecimal.valueOf(0)) == 0) {
            return nRounded.doubleValue();
        }

        if (nTenth.compareTo(gap) < 0) {
            return nRounded.subtract(gap.subtract(nTenth)).doubleValue();
        } else if (nTenth.compareTo(gap) > 0) {
            return nRounded.subtract(BigDecimal.valueOf(1).subtract(nTenth)).doubleValue();
        }

        return nRounded.doubleValue();
    }

    private static double getHalfDownPositive(double n) {

        BigDecimal nRounded = BigDecimal.valueOf(n).setScale(1, BigDecimal.ROUND_HALF_UP);
        BigDecimal nRoundedFloor = BigDecimal.valueOf(Math.floor(n));
        BigDecimal nTenth = nRoundedFloor.subtract(nRounded).abs();
        BigDecimal gap = BigDecimal.valueOf(0.5);

        if (nTenth.compareTo(BigDecimal.valueOf(0)) == 0) {
            return nRounded.doubleValue();
        }

        if (nTenth.compareTo(gap) < 0) {
            return nRounded.subtract(nTenth).doubleValue();
        } else if (nTenth.compareTo(gap) > 0) {
            return nRounded.subtract(nTenth.subtract(gap)).doubleValue();
        }

        return nRounded.doubleValue();
    }
}
