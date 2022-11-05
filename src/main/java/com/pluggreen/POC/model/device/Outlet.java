package com.pluggreen.POC.model.device;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.DeviceType;
import com.pluggreen.POC.model.EnergyIndex;
import com.pluggreen.POC.model.Location;

public class Outlet extends Device {
    public Outlet(String id, DeviceType type, Location location, Double status) {
        super(id, type, location, status);
    }

    @Override
    public void onCleanEnergy(EnergyIndex index) {
        System.out.println("Outlet id: "+this.getId()+" Turning on with a carbon emission index of "+index.getIndex());
    }

    @Override
    public void onDirtyEnergy(EnergyIndex index) {

        System.out.println("Outlet id: "+this.getId()+" Turning off with a carbon emission index of "+index.getIndex());

    }
}
