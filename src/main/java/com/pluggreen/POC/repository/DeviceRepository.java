package com.pluggreen.POC.repository;

import com.pluggreen.POC.model.Device;
import com.pluggreen.POC.model.DeviceType;
import com.pluggreen.POC.model.device.Dimmer;
import com.pluggreen.POC.model.device.Outlet;
import org.springframework.stereotype.Component;

@Component
public class DeviceRepository {
    public Device getById(String deviceId){
        //TODO: connect with device database
        if(deviceId.contains("OUTLET"))
          return new Outlet(deviceId, DeviceType.OUTLET,null,0.0);
        else
            return new Dimmer(deviceId, DeviceType.DIMMER,null,0.0);
    }

}
