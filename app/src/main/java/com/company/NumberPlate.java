package com.company;

public class NumberPlate {
    
    private String plate;

    public NumberPlate(String plate) {
        this.plate = plate;
    }

    Integer getNumberPartOfPlate(){
        String number = this.plate.substring(3);
        return tryParseInt(number);
    }

    private static Integer tryParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            //TODO: clarify if this is the wanted behaviour. It may be better to actually throw an exception here.
            // A unit test documents the current behaviour
            System.out.printf("The string '{0}' cannot be converted to an Integer. Returning 0 instead", s);
            return 0;
        }
    }
}