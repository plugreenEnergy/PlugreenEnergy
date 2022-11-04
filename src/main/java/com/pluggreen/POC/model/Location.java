package com.pluggreen.POC.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private Double latitude;
    private Double longitude;
    private String address;

    public EnergyZone getEnergyZone(){
        return longitude<= -110? EnergyZone.WESTUS:EnergyZone.EASTUS;
    }

    public static Location fromAddress(String address){
        //TODO: get Lat/Long from address processing system
        Double lat = 34.376333;
        Double lon = -118.531750;
        return new Location(lat,lon,address);
    }

    public static Location fromLatLong(Double lat, Double lon) {

        return new Location(lat,lon,"");
    }

}
