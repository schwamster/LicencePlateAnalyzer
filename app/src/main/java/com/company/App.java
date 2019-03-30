package com.company;

public class App {
    public static void main(String[] args) throws Exception {
        LicensePlateDataAnalyzer analyzer = new LicensePlateDataAnalyzer();
        int sum = analyzer.sumOfNumbersOnPlates("input.txt", "blue");
        System.out.println(sum);
    }
}