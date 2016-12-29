package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class PointSpec {

    private final int x = 12;
    private final int y = 21;
    private Point point;

    @BeforeMethod
    public void beforeTest() {
        point = new Point(x, y);
    }

    public void whenInstantiatedThenXIsSet() {
        assertEquals(point.getX(), x);
    }

    public void whenInstantiatedThenYIsSet() {
        assertEquals(point.getY(), y);
    }

}
