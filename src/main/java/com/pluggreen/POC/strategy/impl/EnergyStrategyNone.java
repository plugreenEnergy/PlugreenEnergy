package com.pluggreen.POC.strategy.impl;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.EnergyIndex;
import com.pluggreen.POC.model.EnergyZone;
import com.pluggreen.POC.model.Location;
import com.pluggreen.POC.strategy.IEnergyUseStrategy;

import java.util.Date;

public class EnergyStrategyNone implements IEnergyUseStrategy {

    @Override
    public EnergyIndex getEnergyIndex(EnergyZone energyZone, Date date) {
        return new EnergyIndex(0.0);
    }

    @Override
    public void decide(EnergyIndex energyIndex, Device device) {
            device.onCleanEnergy(energyIndex);
    }
}
