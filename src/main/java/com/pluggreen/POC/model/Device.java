package com.pluggreen.POC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public abstract class Device implements DeviceAction{

    private String id;
    private DeviceType type;
    private Location location;
    private Double status;
}
