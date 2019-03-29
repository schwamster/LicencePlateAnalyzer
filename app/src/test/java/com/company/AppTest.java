package com.company;

import static org.junit.Assert.assertEquals;

import com.company.App.Summer;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 
     * @throws Exception
     */
    @Test
    public void summerTest_givenTestData_filterOnBlue_returnsExpectedSum() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 532;

        //Act
        summer.calcSum("input.txt", "blue");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }
}
