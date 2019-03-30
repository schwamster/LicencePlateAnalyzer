package com.company;

public class VehicleData{
    
    private String rawVehicleData;

    public VehicleData(String rawVehicleData) {
        this.rawVehicleData = rawVehicleData;
    }

    NumberPlate getPlate(){
        String plate = this.rawVehicleData.substring(0, this.rawVehicleData.indexOf(','));
        return new NumberPlate(plate);
    }

    String getColor(){
        return this.rawVehicleData.substring(this.rawVehicleData.indexOf(',') + 1);
    }
}