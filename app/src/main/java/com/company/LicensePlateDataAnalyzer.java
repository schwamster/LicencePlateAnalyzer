package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class LicensePlateDataAnalyzer {

    Integer sumOfNumbersOnPlates(String fileName, String color) throws Exception {    
        return readVehicleDataDistinct(fileName)
            .filter(vehicleData -> vehicleData.getColor().equalsIgnoreCase(color))
            .map(vehicleData -> vehicleData.getPlate().getNumberPartOfPlate())
            .reduce(0, (a, b) -> a + b);
    }

    private Stream<VehicleData> readVehicleDataDistinct(String fileName) throws IOException {
        FileReader reader = new FileReader(new File(fileName));
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
        reader.close();

        return ls.stream().map(x -> new VehicleData(x));
    }
}