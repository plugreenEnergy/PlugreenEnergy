package com.pluggreen.POC.model;

public interface DeviceAction {

    void onCleanEnergy(EnergyIndex index);
    void onDirtyEnergy(EnergyIndex index);
}
