package com.mrinal.selenium;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class MyTest {

    @Test
    public void testSuccess() {
        System.out.println("Executing testSuccess...");
    }

    @Test
    public void testFail() {
        System.out.println("Executing testFail...");
        assert false;
    }
}

