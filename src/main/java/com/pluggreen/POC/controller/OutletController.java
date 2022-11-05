package com.pluggreen.POC.controller;

import com.pluggreen.POC.service.DeviceDecisionService;
import com.pluggreen.POC.service.EmissionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OutletController {
    @Resource
    private DeviceDecisionService decisionService;
    @RequestMapping(value = "/decide")
    public ResponseEntity getDecision(
            @RequestParam(value="lat") Double lat,
            @RequestParam(value="lon") Double lon,
            @RequestParam(value="deviceId") String deviceId,
            @RequestParam(value="battery") Double battery,
            @RequestParam(value="userId") String userId){
        try {
            decisionService.decide(lat, lon, deviceId, battery,userId);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }
}
