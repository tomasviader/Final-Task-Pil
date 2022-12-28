package com.example.FinalPil.controller;

import com.example.FinalPil.model.Zone;
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
        Zone zone = new Zone(1L, "almafuerte", "islas", 280, "por ahi");
        zoneRepository.save(zone);
    }

}