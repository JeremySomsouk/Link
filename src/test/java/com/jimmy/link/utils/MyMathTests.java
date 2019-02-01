package com.jimmy.link.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathTests {

    @Test
    public void testRoundToHalfDownPositiveNumbers() {
        double delta = 0.001;

        assertEquals(3.5f, MyMath.getHalfDownValue(3.6f), delta);
        assertEquals(0f, MyMath.getHalfDownValue(0.4f), delta);
        assertEquals(3f, MyMath.getHalfDownValue(3f), delta);
        assertEquals(0.5f, MyMath.getHalfDownValue(0.8f), delta);

        assertEquals(0f, MyMath.getHalfDownValue(0f), delta);
        assertEquals(0f, MyMath.getHalfDownValue(0.1f), delta);
        assertEquals(0f, MyMath.getHalfDownValue(0.2f), delta);
        assertEquals(0f, MyMath.getHalfDownValue(0.3f), delta);
        assertEquals(0f, MyMath.getHalfDownValue(0.4f), delta);
        assertEquals(0.5f, MyMath.getHalfDownValue(0.5f), delta);
        assertEquals(0.5f, MyMath.getHalfDownValue(0.6f), delta);
        assertEquals(0.5f, MyMath.getHalfDownValue(0.7f), delta);
        assertEquals(0.5f, MyMath.getHalfDownValue(0.8f), delta);
        assertEquals(0.5f, MyMath.getHalfDownValue(0.9f), delta);
        assertEquals(1f, MyMath.getHalfDownValue(1f), delta);
        assertEquals(1f, MyMath.getHalfDownValue(1.1f), delta);
        assertEquals(1f, MyMath.getHalfDownValue(1.2f), delta);
        assertEquals(1f, MyMath.getHalfDownValue(1.3f), delta);
        assertEquals(1f, MyMath.getHalfDownValue(1.4f), delta);

        assertEquals(5.0f, MyMath.getHalfDownValue(5.2052142f), delta);
    }


    @Test
    public void testRoundToHalfDownNumbers() {
        double delta = 0.001;

        assertEquals(-4f, MyMath.getHalfDownValue(-3.6f), delta);
        assertEquals(-90f, MyMath.getHalfDownValue(-89.8f), delta);
        assertEquals(-3.5f, MyMath.getHalfDownValue(-3.3f), delta);
        assertEquals(-3f, MyMath.getHalfDownValue(-3f), delta);

        assertEquals(0f, MyMath.getHalfDownValue(-0f), delta);
        assertEquals(-0.5f, MyMath.getHalfDownValue(-0.1f), delta);
        assertEquals(-0.5f, MyMath.getHalfDownValue(-0.2f), delta);
        assertEquals(-0.5f, MyMath.getHalfDownValue(-0.3f), delta);
        assertEquals(-0.5f, MyMath.getHalfDownValue(-0.4f), delta);
        assertEquals(-0.5f, MyMath.getHalfDownValue(-0.5f), delta);
        assertEquals(-1f, MyMath.getHalfDownValue(-0.6f), delta);
        assertEquals(-1f, MyMath.getHalfDownValue(-0.7f), delta);
        assertEquals(-1f, MyMath.getHalfDownValue(-0.8f), delta);
        assertEquals(-1f, MyMath.getHalfDownValue(-0.9f), delta);
        assertEquals(-1f, MyMath.getHalfDownValue(-1f), delta);
    }
}
