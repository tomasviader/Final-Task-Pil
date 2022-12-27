package controller;

import lombok.RequiredArgsConstructor;
import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ZoneService;

@RestController
@RequestMapping("/zones")
@RequiredArgsConstructor
public class ZoneController {
    @Autowired
    ZoneService zoneService;
    @PostMapping
    public Zone saveZone(Zone zone){
        return zoneService.saveZone(zone);
    }

    @PutMapping("/zones/{id}")
    public Zone modifyZone(@PathVariable("id") Long zoneId, @RequestBody Zone zone){
        return zoneService.modifyZone(zoneId,zone);
    }
}
