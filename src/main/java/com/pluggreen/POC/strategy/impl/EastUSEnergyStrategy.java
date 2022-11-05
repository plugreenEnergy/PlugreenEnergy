package com.pluggreen.POC.strategy.impl;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.DeviceType;
import com.pluggreen.POC.model.EnergyIndex;
import com.pluggreen.POC.model.EnergyZone;
import com.pluggreen.POC.service.EmissionsService;
import com.pluggreen.POC.strategy.IEnergyUseStrategy;
import lombok.AllArgsConstructor;

import javax.annotation.Resource;
import java.util.Date;

@AllArgsConstructor
public class EastUSEnergyStrategy implements IEnergyUseStrategy {

    private static final Double BATTERY_LOWER_THRESHOLD = 40.0;
    private static final Double BATTERY_HIGHER_THRESHOLD = 95.0;
    private static final Double CLEAN_ENERGY_THRESHOLD = 500.0;

    private EmissionsService emissionsService;



    @Override
    public EnergyIndex getEnergyIndex(EnergyZone energyZone, Date date) {
        return emissionsService.getEnergyStatusByLocation(energyZone.getId());
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

           }
           //Fallback
        if(energyIndex.getIndex()>CLEAN_ENERGY_THRESHOLD){
            device.onDirtyEnergy(energyIndex);
            return;
        }
        device.onCleanEnergy(energyIndex);
    }
}
