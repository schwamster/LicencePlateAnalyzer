package com.company;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Summer summer = new Summer();
        summer.calcSum("input.txt", "blue");
        System.out.println(summer.getSum());
    }

    static class Summer {
        private int sum;

        void calcSum(String fileName, String color) throws Exception {
            FileReader reader = new FileReader(new File(fileName));
            List<String> lines = new ArrayList<>(readLines(reader));
            for (int i = 1; i < lines.size(); i++) {
                String plate = lines.get(i);
                String colorOfVehicle = plate.substring(plate.indexOf(',') + 1);
                if (colorOfVehicle.equalsIgnoreCase(color)) {

                    Integer numberInt = extractNumberOfPlate(plate);
                    sum += numberInt;
                }
            }
        }

        private Integer extractNumberOfPlate(String plate) {
            String number = plate.substring(3, plate.indexOf(','));
            return tryParseInt(number);
        }

        private Integer tryParseInt(String s) {
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                //TODO: clarify if this is the wanted behaviour. It may be better to actually throw an exception here.
                //A unit test documents the current behaviour
                System.out.printf("The string '{0}' cannot be converted to an Integer. Returning 0 instead", s);
                return 0;
            }
        }

        Set<String> readLines(FileReader reader) throws IOException {
            Set<String> ls = new HashSet<String>();
            String l = "";
            int c = reader.read();
            while (c != -1) {
                if (c == '\n') {
                    l = l.replaceAll("\\r", "");
                    ls.add(l.toLowerCase());
                    l = "";
                } else {
                    l += new Character((char) c);
                }
                c = reader.read();
            }
            return ls;
        }

        Integer getSum() {
            return sum;
        }
    }
}