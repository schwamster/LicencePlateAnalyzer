package com.company;

import static org.junit.Assert.assertEquals;

import com.company.App.Summer;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
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

    @Test
    public void summerTest_givenTestData_filterOnNoneExistingColor_returnsZero() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 0;

        //Act
        summer.calcSum("input.txt", "black");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void summerTest_givenTestData_filterOnColorWithOnlyOneElement_returnsExpectedResult() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 529;

        //Act
        summer.calcSum("input.txt", "red");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void summerTest_givenInvalidTestData_returnsExpectedResult() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 532;

        //Act
        summer.calcSum("input.invalid1.txt", "blue");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void summerTest_givenInvalidTestDataWithSpecialLicenceNumber_returnsExpectedResult() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 532;

        //Act
        summer.calcSum("input.invalid2.txt", "blue");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void summerTest_givenInvalidTestDataWithColorThatContainsSpaces_returnsExpectedResult() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 150;

        //Act
        summer.calcSum("input.variation.txt", "dark blue");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void summerTest_givenTestData_filterWithUpperCaseColor_returnsExpectedResult() throws Exception
    {
        //Arrange
        Summer summer = new Summer();
        int expected = 532;

        //Act
        summer.calcSum("input.txt", "BLUE");
        int actual = summer.getSum();

        //Assert
        assertEquals(expected, actual);
    }
}
