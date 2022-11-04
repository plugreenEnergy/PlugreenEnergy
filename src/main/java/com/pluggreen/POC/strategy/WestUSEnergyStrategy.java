package com.pluggreen.POC.strategy;

import com.pluggreen.POC.model.*;
import com.pluggreen.POC.service.EmissionsService;

import javax.annotation.Resource;
import java.util.Date;

public class WestUSEnergyStrategy implements IEnergyUseStrategy{

    private static final Double BATTERY_LOWER_THRESHOLD = 40.0;
    private static final Double BATTERY_HIGHER_THRESHOLD = 95.0;
    private static final Double CLEAN_ENERGY_THRESHOLD = 400.0;
    @Resource
    private EmissionsService emissionsService;
    private static final EnergyZone ENERGY_ZONE = EnergyZone.WESTUS;
    @Override
    public EnergyZone getEnergyZone(Location location) {
        return ENERGY_ZONE;
    }

    @Override
    public EnergyIndex getEnergyIndex(EnergyZone energyZone, Date date) {
        return emissionsService.getEnergyStatusByLocation(energyZone.name());
    }

    @Override
    public void decide( EnergyIndex energyIndex, Device device) {
           if(DeviceType.OUTLET.equals(device.getType())){
               Double battery = device.getStatus();
               if(battery< BATTERY_LOWER_THRESHOLD){
                   device.onCleanEnergy(energyIndex);
                   return;
               }
               if(battery>BATTERY_HIGHER_THRESHOLD ) {
                   device.onDirtyEnergy(energyIndex);
                   return;
               }
               if(energyIndex.getIndex()>CLEAN_ENERGY_THRESHOLD){
                   device.onDirtyEnergy(energyIndex);
                   return;
               }
               device.onCleanEnergy(energyIndex);
           }
    }
}
