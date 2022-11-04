package com.pluggreen.POC.controller;

import com.pluggreen.POC.service.EmissionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OutletController {
    @Resource
    private EmissionsService emissionsService;
    @RequestMapping(value = "/byLocation")
    public ResponseEntity<Object> getEnergyStatusByLocation(@RequestParam(value="location") String location){

        return  ResponseEntity.ok(emissionsService.getEnergyStatusByLocation(location));


    }
}
