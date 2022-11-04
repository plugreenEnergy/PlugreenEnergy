package com.pluggreen.POC.api.carbonAware.client;

import com.pluggreen.POC.api.carbonAware.model.EmissionsData;
import com.pluggreen.POC.api.carbonAware.model.EmissionsForecast;
import feign.Param;
import feign.RequestLine;


public interface CarbonAwareClient {
    @RequestLine("GET /emissions/forecasts/current?location={location}")
    EmissionsForecast[] getCurrentForecast(@Param String location);

    @RequestLine("GET /emissions/bylocation?location={location}")
    EmissionsData[] getEmissionsByLocation(@Param String location);
}
