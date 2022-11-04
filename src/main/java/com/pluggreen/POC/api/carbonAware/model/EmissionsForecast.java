package com.pluggreen.POC.api.carbonAware.model;

import lombok.Data;

import java.util.List;

@Data
public class EmissionsForecast {

    private String generatedAt;
    private String requestedAt;
    private String location;
    private String dataStartAt;
    private String dataEndAt;
    private int windowSize;
    private EmissionsData[] optimalDataPoints;
    private EmissionsData[] forecastData;

}
