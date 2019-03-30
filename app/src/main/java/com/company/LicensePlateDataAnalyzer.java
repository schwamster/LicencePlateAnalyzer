package com.company;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
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

        Stream<String> stream = Files.lines(Paths.get(fileName));
        Set<String> ls = new HashSet<String>();
        stream.forEach(line -> {
            ls.add(line.toLowerCase());
        });
        stream.close();

        return ls.stream().map(x -> new VehicleData(x));
    }

}