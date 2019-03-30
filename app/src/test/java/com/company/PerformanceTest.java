package com.company;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.categories.Category;

// Program to calculate execution time or elapsed time in Java
public class PerformanceTest
{
    @Test
    @Category(PerformanceTest.class)
    public void licensePlateDataAnalyzerPerformanceTest() throws Exception {
        long startTime = System.nanoTime();

		
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        //generated.txt contains 100K random plates => see /fakeplates (node.js app that utilizes faker)
        int result = analyzer.sumOfNumbersOnPlates("generated.txt", "blue");        	

		long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;

        System.out.println("========================================");
        System.out.println("Sum:" + result);	
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        System.out.println("Execution time in nanoseconds/element: " + timeElapsed / 100000);
        System.out.println("========================================");
        
        //total runtime on local dev machine was below around 150 ms after performance update (prev 400ms)
        assertTrue(timeElapsed / 1000000 < 200);
        assertEquals(1576767, result);
    }
}