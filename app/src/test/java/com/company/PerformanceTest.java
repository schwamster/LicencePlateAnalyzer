package com.company;

import static org.junit.Assert.assertTrue;

import com.company.App.Summer;

import org.junit.Test;
import org.junit.experimental.categories.Category;

// Program to calculate execution time or elapsed time in Java
public class PerformanceTest
{
    @Test
    @Category(PerformanceTest.class)
    public void summerTest_givenTestData_filterOnBlue_returnsExpectedSum() throws Exception {
        long startTime = System.nanoTime();

		
        Summer summer = new Summer();
        //generated.txt contains 100K random plates => see /fakeplates (node.js app that utilizes faker)
        summer.calcSum("generated.txt", "blue");        	

		long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;

        System.out.println(summer.getSum());	
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        System.out.println("Execution time in nanoseconds/element: " + timeElapsed / 10000);
        
        //total runtime on local dev machine was below around 400ms
        assertTrue(timeElapsed / 1000000 < 500);
    }
}