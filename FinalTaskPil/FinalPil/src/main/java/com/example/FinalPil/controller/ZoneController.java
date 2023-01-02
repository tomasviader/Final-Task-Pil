package com.example.FinalPil.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import com.example.FinalPil.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.FinalPil.service.ZoneService;

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
    public Zone modifyZone(@PathVariable Long id, @RequestBody Zone zone){
        return zoneService.modifyZone(id, zone);
    }
}
