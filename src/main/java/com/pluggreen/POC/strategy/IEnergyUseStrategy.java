package com.pluggreen.POC.strategy;

import com.pluggreen.POC.model.*;

import java.util.Date;

public interface IEnergyUseStrategy {

    EnergyZone getEnergyZone(Location location);
    EnergyIndex getEnergyIndex(EnergyZone energyZone, Date date);
    void decide(EnergyIndex energyIndex, Device device);

}
