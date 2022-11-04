package com.pluggreen.POC.service;

import com.pluggreen.POC.api.airtable.client.AirTableClient;
import com.pluggreen.POC.api.airtable.client.AirTableRestClient;
import com.pluggreen.POC.api.airtable.model.Product;
import com.pluggreen.POC.api.airtable.model.ProductResponse;
import com.pluggreen.POC.api.carbonAware.client.CarbonAwareClient;
import com.pluggreen.POC.api.carbonAware.model.EmissionsData;
import com.pluggreen.POC.api.carbonAware.model.EmissionsForecast;
import com.pluggreen.POC.model.EnergyIndex;
import com.pluggreen.POC.model.EnergyStatus;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmissionsService {
   @Resource
    private AirTableClient airTableClient;
    public EnergyIndex getEnergyStatusByLocation(String location){
        CarbonAwareClient carbonAwareClient= Feign.builder()
                .client(new OkHttpClient())
               .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(CarbonAwareClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CarbonAwareClient.class,"https://carbon-aware-api.azurewebsites.net/");

        EmissionsData[] currentData = carbonAwareClient.getEmissionsByLocation(location);
        int resultsNumber =currentData.length;

        Double value = currentData[resultsNumber-1].getValue();
        return new EnergyIndex(value);


    }
}
