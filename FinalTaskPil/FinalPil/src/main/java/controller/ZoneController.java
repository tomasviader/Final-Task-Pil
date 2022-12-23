package controller;

import lombok.RequiredArgsConstructor;
import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ZoneService;

@RestController
@RequestMapping("/zones")
@RequiredArgsConstructor
public class ZoneController {

    @Autowired
    ZoneService zoneService;
}
