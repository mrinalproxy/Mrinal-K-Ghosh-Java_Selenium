package com.example.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test(priority = 1)
    public void testAddition() {
        int result = 10 + 5;
        Assert.assertEquals(result, 15, "Addition test failed!");
        System.out.println("Priority 1 → Addition passed");
    }

    @Test(priority = 2)
    public void testSubtraction() {
        int result = 10 - 5;
        Assert.assertEquals(result, 5, "Subtraction test failed!");
        System.out.println("Priority 2 → Subtraction passed");
    }

    @Test(priority = 3)
    public void testMultiplication() {
        int result = 10 * 5;
        Assert.assertEquals(result, 50, "Multiplication test failed!");
        System.out.println("Priority 3 → Multiplication passed");
    }

    @Test(priority = 4)
    public void testDivision() {
        int result = 10 / 5;
        Assert.assertEquals(result, 2, "Division test failed!");
        System.out.println("Priority 4 → Division passed");
    }
}