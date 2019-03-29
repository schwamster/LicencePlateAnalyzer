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
                String line = lines.get(i);
                String colorOfVehicle = line.substring(line.indexOf(',') + 1);
                if (colorOfVehicle.equals(color)) {
                    String number = line.substring(3, line.indexOf(','));
                    Integer numberInt = Integer.parseInt(number);
                    sum += numberInt;
                }
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