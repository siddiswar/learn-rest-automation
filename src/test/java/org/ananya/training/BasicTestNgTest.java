package org.ananya.training;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNgTest {

    @BeforeMethod
    public void setUpTestData(){
        System.out.println("===================================Setting up test data");
    }

    @AfterMethod
    public void cleanUpTestData(){
        System.out.println("===================================Cleaning up test data");
    }

    @Test
    public void numberTest(){
        System.out.println("===================================Executing Test1");
        int expectedNumber = 3;
        int actualNumber = 3;
        Assert.assertEquals(actualNumber,expectedNumber);
    }

    @Test
    public void numberTest2(){
        System.out.println("===================================Executing Test2");
        int expectedNumber = 5;
        int actualNumber = 5;
        Assert.assertEquals(actualNumber,expectedNumber);
    }
}
