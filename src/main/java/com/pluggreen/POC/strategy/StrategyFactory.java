package com.pluggreen.POC.strategy;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.EnergyZone;
import com.pluggreen.POC.model.Location;
import com.pluggreen.POC.model.User;
import com.pluggreen.POC.service.EmissionsService;
import com.pluggreen.POC.strategy.impl.EastUSEnergyStrategy;
import com.pluggreen.POC.strategy.impl.EnergyStrategyNone;
import com.pluggreen.POC.strategy.impl.WestUSEnergyStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StrategyFactory {
   @Resource
    private  EmissionsService emissionsService;
    public IEnergyUseStrategy create(Location location, Device device, User user){
        //TODO:: Check if there are user or Device associated configurations
        if(EnergyZone.EASTUS.equals(location.getEnergyZone())){
            return new EastUSEnergyStrategy(emissionsService);
        }
        if(EnergyZone.WESTUS.equals(location.getEnergyZone())){
            return new WestUSEnergyStrategy(emissionsService);
        }
        return new EnergyStrategyNone();
    }

}
