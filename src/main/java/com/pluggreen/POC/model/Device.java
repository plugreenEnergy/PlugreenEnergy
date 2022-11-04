package com.pluggreen.POC.model;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class Device implements DeviceAction{

    private String id;
    private DeviceType type;
    private Location location;
    private Double status;
}
