package com.pluggreen.POC.model;

public enum EnergyZone {
    WESTUS("westus"),
    EASTUS("eastus");

    private String id;
    EnergyZone(String id) {
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}
