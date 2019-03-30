package com.company;

import static org.junit.Assert.assertEquals;

import com.company.categories.FastTestsCategory;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for simple App.
 */
public class LicensePlateDataAnalyzerTest 
{
    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenTestData_filterOnBlue_returnsExpectedSum() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 532;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.txt", "blue");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenTestData_filterOnNoneExistingColor_returnsZero() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 0;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.txt", "black");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenTestData_filterOnColorWithOnlyOneElement_returnsExpectedResult() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 529;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.txt", "red");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenInvalidTestData_returnsExpectedResult() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 532;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.invalid1.txt", "blue");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenInvalidTestDataWithSpecialLicenceNumber_returnsExpectedResult() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 532;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.invalid2.txt", "blue");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenInvalidTestDataWithColorThatContainsSpaces_returnsExpectedResult() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 150;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.variation.txt", "dark blue");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Category(FastTestsCategory.class)
    public void sumOfNumbersOnPlates_givenTestData_filterWithUpperCaseColor_returnsExpectedResult() throws Exception
    {
        //Arrange
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int expected = 532;

        //Act
        int actual = analyzer.sumOfNumbersOnPlates("input.txt", "BLUE");

        //Assert
        assertEquals(expected, actual);
    }
}
