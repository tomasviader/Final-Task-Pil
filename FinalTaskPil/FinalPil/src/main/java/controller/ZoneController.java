package controller;

import lombok.RequiredArgsConstructor;
import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.ZoneService;

@RestController
@RequestMapping("/zones")
@RequiredArgsConstructor
public class ZoneController {

    @Autowired
    ZoneService zoneService;


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Zone zone){
        //zoneService.updateZone(id, zone);
    }

}
