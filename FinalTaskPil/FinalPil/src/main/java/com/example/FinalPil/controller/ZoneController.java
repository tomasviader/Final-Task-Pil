package com.example.FinalPil.controller;


import lombok.RequiredArgsConstructor;
import com.example.FinalPil.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.FinalPil.service.ZoneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zones")
@RequiredArgsConstructor
public class ZoneController {
    @Autowired
    ZoneService zoneService;


    @PostMapping
    public Zone saveZone(@RequestBody Zone zone){
        return zoneService.saveZone(zone);
    }

    @PutMapping("/{id}")
    public Zone modifyZone(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.modifyZone(id, zone);

    }

    @DeleteMapping("/{id}")
    public String deleteZone(@PathVariable Long id){
        zoneService.deleteZone(id);
        return "Zone deleted succefully.";

    }

    @GetMapping
    public List<Zone> getZones(){
        return zoneService.getZones();
    }

    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable Long id){
        return zoneService.getZoneById(id);
    }

    @GetMapping("/neighborhood/{neighborhood}")
    public Zone getZoneByNeighborhood(@PathVariable String neighborhood){
        return zoneService.getZoneByNeighborhood(neighborhood);
    }
}
