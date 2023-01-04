package com.example.FinalPil.repository;

import com.example.FinalPil.model.Zone;
import com.example.FinalPil.service.ZoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ZoneRepositoryTest {

    @Autowired
    ZoneRepository zoneRepository;

    @Test
    void ANewTestShouldBeCreated(){
        Zone zone = new Zone(1L, "Almafuerte", "Islas Malvinas", 700, "20");

        Zone savedZone = zoneRepository.save(zone);

        assertNotNull(savedZone);
    }

    @Test
    void aZoneShouldBeModified(){
        Zone zone = new Zone(1L, "Almafuerte", "Islas Malvinas", 700, "20");
        Zone savedZone = zoneRepository.save(zone);

        String newName = "Cordoba";
        Zone zone1 = new Zone(1L,newName,"Islas Malvinas",700,"20");
        zone1.setId(1L);
        zoneRepository.save(zone1);

        Zone updatedZone = zoneRepository.findByName(newName);
        assertEquals(zone1.getName(),newName);
        assertEquals(zone1.getCoordinates(),"20");

    }


}