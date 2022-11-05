package com.pluggreen.POC.service;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.EnergyIndex;
import com.pluggreen.POC.model.Location;
import com.pluggreen.POC.model.User;
import com.pluggreen.POC.repository.DeviceRepository;
import com.pluggreen.POC.strategy.IEnergyUseStrategy;
import com.pluggreen.POC.strategy.StrategyFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DeviceDecisionService {
@Resource
private StrategyFactory strategyFactory;
@Resource
private DeviceRepository deviceRepository;
    private void decide(Location location, Device device, User user){
            IEnergyUseStrategy strategy = strategyFactory.create(location,device, user);

            EnergyIndex index = strategy.getEnergyIndex(location.getEnergyZone(),new Date());

            strategy.decide(index,device);
    }

    public void decide(Double lat, Double lon, String deviceId, Double battery, String userId){
        Device device = deviceRepository.getById(deviceId);
        Location loc = Location.fromLatLong(lat,lon);
        User user = new User(userId,"");
        device.setLocation(loc);
        device.setStatus(battery);
        decide(loc,device,user);
    }

}
