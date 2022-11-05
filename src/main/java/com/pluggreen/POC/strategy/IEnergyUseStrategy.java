package com.pluggreen.POC.strategy;

import com.pluggreen.POC.model.*;

import java.util.Date;

public interface IEnergyUseStrategy {

    EnergyIndex getEnergyIndex(EnergyZone energyZone, Date date);
    void decide(EnergyIndex energyIndex, Device device);

}
