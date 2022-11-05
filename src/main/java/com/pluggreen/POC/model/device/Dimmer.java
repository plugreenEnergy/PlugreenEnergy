package com.pluggreen.POC.model.device;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.DeviceType;
import com.pluggreen.POC.model.EnergyIndex;
import com.pluggreen.POC.model.Location;

public class Dimmer extends Device {

    private static final Double HIGHER_BRIGHT = 95.0;
    private static final Double LOWER_BRIGHT = 35.0;

    public Dimmer(String id, DeviceType type, Location location, Double status) {
        super(id, type, location, status);
    }

    @Override
    public void onCleanEnergy(EnergyIndex index) {
        System.out.println("Dimmer id: "+this.getId()+" Increasing light to "+HIGHER_BRIGHT+"% with a carbon emission index of "+index.getIndex());

    }

    @Override
    public void onDirtyEnergy(EnergyIndex index) {
        Double intensity = (1000- index.getIndex())/10;
        System.out.println("Outlet id: "+this.getId()+" Decreasing light to "+Math.max(intensity,LOWER_BRIGHT)+"%  with a carbon emission index of "+index.getIndex());

    }
}
