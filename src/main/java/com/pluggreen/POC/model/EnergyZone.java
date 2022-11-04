package com.pluggreen.POC.model;

public enum EnergyZone {
    WESTUS("westus"),
    EASTUS("eastus");

    private String name;
    EnergyZone(String name) {
        this.name = name;
    }
}
