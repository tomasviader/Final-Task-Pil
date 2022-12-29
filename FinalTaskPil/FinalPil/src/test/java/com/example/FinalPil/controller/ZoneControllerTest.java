package com.example.FinalPil.controller;

import com.example.FinalPil.model.Zone;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.FinalPil.repository.ZoneRepository;


@DataJpaTest
class ZoneControllerTest {
    @Autowired
    ZoneRepository zoneRepository;

    @Test
    void ANewZoneShouldBeCreate(){
        Zone zone = new Zone(1L, "almafuerte", "islas", 280, "por ahi",true);
        zoneRepository.save(zone);
    }

    @Test
    void theZoneStatusShouldBeUpdated(){
        Zone zone = new Zone(1L, "almafuerte", "islas", 280, "por ahi",true);
        zoneRepository.save(zone);

        Zone getZone = zoneRepository.getOne(1L);
        getZone.setStatus(false);
        zoneRepository.save(getZone);

        Assert.assertNotEquals(zone,getZone);
    }

}