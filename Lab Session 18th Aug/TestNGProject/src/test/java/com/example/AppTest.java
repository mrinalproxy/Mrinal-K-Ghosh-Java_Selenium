package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testOne() {
        Assert.assertTrue(true, "This test should pass!");
    }

    @Test
    public void testTwo() {
        Assert.assertEquals("Hello", "Hello", "Strings match!");
    }
}
